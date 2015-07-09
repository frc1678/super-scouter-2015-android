package org.citruscircuits.super_scouter_2014_android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.widget.Toast;

class AcceptThread extends Thread {
	private final BluetoothServerSocket mmServerSocket;
	private final String MY_UUID = "3da6971e-f039-4c35-acab-dd46321505a1";
	private final String NAME = "1678-bluetooth-";
	private MainActivity activity;
	private String currentScheduleToSend;
	
	public AcceptThread(BluetoothAdapter adapter, MainActivity activity,
			int port, String currentSchedule) {
		// Use a temporary object that is later assigned to mmServerSocket,
		// because mmServerSocket is final
		BluetoothServerSocket tmp = null;
		this.activity = activity;
		currentScheduleToSend = currentSchedule;
		
		try {
			Method m = adapter.getClass().getMethod("listenUsingRfcommOn",
					new Class[] { int.class });
			tmp = (BluetoothServerSocket) m.invoke(adapter, port);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mmServerSocket = tmp;
	}

	public void run() {
		BluetoothSocket socket = null;
		// Keep listening until exception occurs or a socket is returned

		if (mmServerSocket == null) {
			Toaster.makeErrorToastOnMainThread(
					"Failed to initialize Bluetooth", Toast.LENGTH_SHORT,
					activity);
			return;
		}

		while (true) {
			try {
				Log.e("stupid logcat", "Waiting for scout to connect...");
				socket = mmServerSocket.accept();
			} catch (IOException e) {
				Log.e("i breathe life into this", "IOException at accepting socket");

				break;
			}
			// If a connection was accepted
			if (socket != null && socket.isConnected()) {
				// Do work to manage the connection (in a separate thread)
				// manageConnectedSocket(socket);
				Log.e("stupid logcat", "Scout tablet connected!");
				String inputString = "";
				try {
					InputStream in = socket.getInputStream();

                    Log.e("test", "We get here!");
                    Log.e("test", in.available() + "");
					int code = in.read();
                    Log.e("test", "How about here?");

					if (code == 1) {
						inputString = convertStreamToString(in);

						Log.e("stupid logcat", "Read string: " + inputString);

						Log.e("stupid logcat", "Waiting to get match data");

                        Random rand = new Random();

						JSONObject matchData = new JSONObject(inputString);
						final int teamNumber = matchData.getInt("uniqueValue");
						String matchNumber = Integer.toString(rand.nextInt((1000 - 1) + 1) + 1);

						Log.e("stupid logcat", teamNumber
								+ " data read from Bluetooth");

						activity.uploadRobotDataToDropbox(inputString,
								matchNumber, teamNumber, false);

						activity.runOnUiThread(new Runnable() {

							@Override
							public void run() {
								activity.showUploadDataToast(teamNumber, true);
							}
						});
					} else if (code == 0) {

						Log.e("stupid logcat", "Outputting schedule");
						// Write json schedule to scout
						OutputStream out = socket.getOutputStream();
                        // This is the old code:
						out.write(currentScheduleToSend.getBytes());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // This is the new code, and probably might maybe not work without corresponding changes to ConnectThread
                       /* byte[] toWrite = currentScheduleToSend.getBytes();
                        int toWriteIndex = 0;
                        int increment = 1024;
                        while(toWriteIndex < toWrite.length) {
                            int len = Math.min(increment, toWrite.length - toWriteIndex);
                            out.write(toWrite, toWriteIndex, len);
                            // flush?
                            toWriteIndex += len;
                        }*/

                        Log.e("test", "Schedule length is " + currentScheduleToSend.length());
                        Log.e("test", "Length is " + currentScheduleToSend.getBytes().length);


						Log.e("stupid logcat", "Outputted schedule");
					}


					// Log.e("stupid logcat", "Read string: " + inputString);

					in.close();
					socket.close();
				} catch (IOException e1) {
                    //THIS IS IT
					// TODO Auto-generated catch block
					Log.e("stupid logcat", "IOException: " + e1.toString());
					e1.printStackTrace();
					Toaster.makeErrorToastOnMainThread(
							"Error reading scout data: " + e1.toString(),
							500, activity);

				} catch (JSONException e) {
					Log.e("stupid logcat", "JSONException");
					e.printStackTrace();
					Toaster.makeErrorToastOnMainThread("Invalid scout JSON: "
							+ e.toString(), 500, activity);
				}
			} else {
				Log.e("stupid logcat", "socket null");
			}
		}
	}

	private String convertStreamToString(InputStream is) {
		Scanner s = new Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	/** Will cancel the listening socket, and cause the thread to finish */
	public void cancel() {
		try {
			if (mmServerSocket != null) {
				mmServerSocket.close();
			}
		} catch (IOException e) {
		}
	}
}