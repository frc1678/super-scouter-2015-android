package org.citruscircuits.super_scouter_2014_android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxException.Unauthorized;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileInfo;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;

import io.realm.*;

import org.citruscircuits.realm.*;

//1678

public class MainActivity extends Activity {

	public DbxAccountManager mDbxAcctMgr;
	public DbxFileSystem dbxFs;
	static final int REQUEST_LINK_TO_DBX = 234; // This value is up to you
	MediaPlayer mp;

	Competition competition;
	RealmList<Match> qualificationSchedule;
	private int matchIndex = 0;

    public Realm realm = null;

	boolean isRed = true;
	boolean allowOverride = false;
	final String competitionCode = "CASA";
	int portNumber = 5;

	AcceptThread acceptingThread;

	private String jsonSchedule;

	public final String PREFERENCES_FILE = "org.citruscircuits.super_scouter_2014_android.PreferencesFile";
    public final String PREFERENCES_SCHEDULE_KEY = "schedule";
    public final String PREFERENCES_MATCH_KEY = "match";
	public final String PREFERENCES_COLOR_KEY = "color";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and link Dropbox
        mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(),
                "PLACE_APP_KEY_HERE", "PLACE_APP_SECRET_HERE");

        if (!mDbxAcctMgr.hasLinkedAccount()) {
            Log.e("log", "Starting DB link");
            mDbxAcctMgr.startLink((Activity) this, REQUEST_LINK_TO_DBX);

        } else {
            afterDbxLink();
        }
    }

    public Integer getMatchNumberFromDisk() {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_FILE,
                Context.MODE_PRIVATE);
        return preferences.getInt(PREFERENCES_MATCH_KEY, 0);
    }

    public void writeMatchNumberToDisk(Integer matchNum) {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_FILE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(PREFERENCES_MATCH_KEY, matchNum);
        editor.commit();
    }

    public void afterDbxLink() {

        try {
            dbxFs = DbxFileSystem
                    .forAccount(mDbxAcctMgr.getLinkedAccount());
            Log.e("asdf", "itll work");
        } catch (Unauthorized e) {
            Log.e("fml", "Something decided to break.");
            e.printStackTrace();
        }


        // Set the title
        setTitle("Main Menu");

        realmSetup();
        Log.e("asdf", "asdf!!!");





        Realm realm = Realm.getInstance(this, Constants.REALM_FILE);

        Log.e("whatever", new File(Constants.REALM_FILE).length()/1024/1024+"");

        RealmQuery<Competition> query = realm.where(Competition.class);
        Competition compResult = query.findFirst();
        qualificationSchedule = compResult.getMatches();

        createBluetoothThread();

        matchIndex = getMatchNumberFromDisk();

        updateMatchAndTeamUI(true);
    }

    private void realmSetup() {
        try {
            DbxFile dbfile = dbxFs.open(new DbxPath("/Database File/" + Constants.REALM_FILE));
            FileInputStream stream = dbfile.getReadStream();

            File file = new File(Constants.REALM_FILE);
            file.delete();

            FileOutputStream out = openFileOutput(Constants.REALM_FILE, Context.MODE_PRIVATE);


            int b = 0;

            while ((b = stream.read()) != -1) {
                out.write(b);
            }

            out.close();
            stream.close();
            dbfile.close();

            Log.e("test", "Finished getting realm DB");

        } catch (DbxException e) {
            e.printStackTrace();
            Log.e("test", "Hit DbxException: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("test", "Hit IOException");
        }



        //}

        isRed = Boolean.valueOf(getSharedPreferences(PREFERENCES_FILE,
                Context.MODE_PRIVATE).getString(PREFERENCES_COLOR_KEY, null));

        EditText matchTextField = (EditText) findViewById(R.id.matchTextField);
        matchTextField.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.length() > 1) {
                    try {
                        matchIndex = Integer.parseInt(s.subSequence(1, s.length()).toString()) - 1;
                        updateMatchAndTeamUI(false);
                    } catch (NumberFormatException e) {
                        return;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

        setMatchOverride(false);
    }



	/*private String generateJSON() {
		JSONArray matchArray = new JSONArray();

		for (int i = 0; i < qualificationSchedule.size(); i++) {
			Match match = qualificationSchedule.get(i);
			List<Team> redAllianceTeams = match.getRedAlliance();
			List<Team> blueAllianceTeams = match.getBlueAlliance();

			JSONArray redAllianceArray = new JSONArray();
			redAllianceArray.put(redAllianceTeams.get(0).getNumber());
			redAllianceArray.put(redAllianceTeams.get(1).getNumber());
			redAllianceArray.put(redAllianceTeams.get(2).getNumber());

			JSONArray blueAllianceArray = new JSONArray();
			blueAllianceArray.put(blueAllianceTeams.get(0).getNumber());
			blueAllianceArray.put(blueAllianceTeams.get(1).getNumber());
			blueAllianceArray.put(blueAllianceTeams.get(2).getNumber());

			JSONObject matchObject = new JSONObject();
			try {
				matchObject.put("matchNumber", match.getMatch());
				matchObject.put("redAlliance", redAllianceArray);
				matchObject.put("blueAlliance", blueAllianceArray);

				matchArray.put(matchObject);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Log.e("FML", "Match: " +
			// qualificationSchedule.get(i).toString());
		}

		JSONObject scheduleObject = new JSONObject();
		try {
			scheduleObject.put("qualificationSchedule", matchArray);
			return scheduleObject.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}*/

	private void saveScheduleToDisk(String json) {
		SharedPreferences preferences = getSharedPreferences(PREFERENCES_FILE,
				Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString(PREFERENCES_SCHEDULE_KEY, json);
		editor.commit();
	}

    private String getScheduleFromDisk() {
        return getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
                .getString(PREFERENCES_SCHEDULE_KEY, null);
    }

    private String getScheduleFromVariable() {

        JSONArray finalS = new JSONArray();

        for (int i = 0; i < qualificationSchedule.size(); i++) {
            Match m = qualificationSchedule.get(i);
            JSONObject tmpMatch = new JSONObject();
            try {
                tmpMatch.put("matchNumber", m.getMatch());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray redAlliance = new JSONArray();
            for (int r = 0; r < qualificationSchedule.get(i).getRedTeams().size(); r++) {
                JSONObject tmpTeam = new JSONObject();
                try {
                    tmpTeam.put("number", qualificationSchedule.get(i).getRedTeams().get(r).getNumber());
                    tmpTeam.put("name", qualificationSchedule.get(i).getRedTeams().get(r).getName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                redAlliance.put(tmpTeam);
            }
            try {
                tmpMatch.put("redAlliance", redAlliance);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray blueAlliance = new JSONArray();
            for (int r = 0; r < qualificationSchedule.get(i).getBlueTeams().size(); r++) {
                JSONObject tmpTeam = new JSONObject();
                try {
                    tmpTeam.put("number", qualificationSchedule.get(i).getBlueTeams().get(r).getNumber());
                    tmpTeam.put("name", qualificationSchedule.get(i).getBlueTeams().get(r).getName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                blueAlliance.put(tmpTeam);
            }
            try {
                tmpMatch.put("blueAlliance", blueAlliance);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            finalS.put(tmpMatch);
        }
        return finalS.toString();
    }

	private void createBluetoothThread() {
		// Initiate Bluetooth listening
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
		if (adapter == null) {
			// Device does not support Bluetooth
			Toaster.makeErrorToast("Device does not support Bluetooth",
					Toast.LENGTH_LONG);
		} else {
			if (acceptingThread != null) {
				acceptingThread.cancel();
			}
			acceptingThread = new AcceptThread(adapter, this, portNumber,
                    getScheduleFromVariable());
			acceptingThread.start();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.action_set_match_number) {
			toggleMatchOverride();

		} else if (id == R.id.action_set_color) {

			isRed = !isRed;

			updateMatchAndTeamUI(true);

			SharedPreferences preferences = getSharedPreferences(
					PREFERENCES_FILE, Context.MODE_PRIVATE);
			Editor editor = preferences.edit();
			editor.putString(PREFERENCES_COLOR_KEY, Boolean.toString(isRed));
			editor.commit();

			Log.e("logcat sucks",
					getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
							.getString(PREFERENCES_COLOR_KEY, null));

		} else if (id == R.id.action_set_bluetooth_channel) {

			AlertDialog.Builder alert = new AlertDialog.Builder(this);

			alert.setTitle("Set Bluetooth Channel");

			// Set an EditText view to get user input
			final EditText input = new EditText(this);
			input.setInputType(InputType.TYPE_CLASS_NUMBER);
			alert.setView(input);

			final MainActivity myThis = this;
			final EditText matchTextField = (EditText) findViewById(R.id.matchTextField);
			final EditText team1TextField = (EditText) findViewById(R.id.team1TextField);
			final EditText team2TextField = (EditText) findViewById(R.id.team2TextField);
			final EditText team3TextField = (EditText) findViewById(R.id.team3TextField);
			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							String value = input.getText().toString();

							portNumber = Integer.parseInt(value);
							createBluetoothThread();

							InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
							imm.hideSoftInputFromWindow(input.getWindowToken(),
									0);
							imm.hideSoftInputFromWindow(
									matchTextField.getWindowToken(), 0);
							imm.hideSoftInputFromWindow(
									team1TextField.getWindowToken(), 0);
							imm.hideSoftInputFromWindow(
									team2TextField.getWindowToken(), 0);
							imm.hideSoftInputFromWindow(
									team3TextField.getWindowToken(), 0);
						}
					});

			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {

							InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
							imm.hideSoftInputFromWindow(input.getWindowToken(),
									0);
							imm.hideSoftInputFromWindow(
									matchTextField.getWindowToken(), 0);
							imm.hideSoftInputFromWindow(
									team1TextField.getWindowToken(), 0);
							imm.hideSoftInputFromWindow(
									team2TextField.getWindowToken(), 0);
							imm.hideSoftInputFromWindow(
									team3TextField.getWindowToken(), 0);
						}
					});

			alert.setOnDismissListener(new OnDismissListener() {

				@Override
				public void onDismiss(DialogInterface dialog) {

					InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
					imm.hideSoftInputFromWindow(
							matchTextField.getWindowToken(), 0);
					imm.hideSoftInputFromWindow(
							team1TextField.getWindowToken(), 0);
					imm.hideSoftInputFromWindow(
							team2TextField.getWindowToken(), 0);
					imm.hideSoftInputFromWindow(
							team3TextField.getWindowToken(), 0);
				}
			});

			alert.show();

		}
		return true;
	}

	public void setMatchIndex(int index) {
        if (index < qualificationSchedule.size()) {
			matchIndex = index;
			updateMatchAndTeamUI(true);
            Log.e("asdf", "If you see this, it is very broken... " + matchIndex);
        } else {
			//Toaster.makeErrorToast("No more matches to scout!",
			//		Toast.LENGTH_LONG);
		}
	}

	public void incrementMatchIndex() {
        Log.e("asdf", "If you see this, it is broken... " + matchIndex);
        setMatchIndex(matchIndex + 1);
        writeMatchNumberToDisk(matchIndex);
        Log.e("asdf", "If you see this, it is broken... " + matchIndex);
	}

	public void toggleMatchOverride() {
		setMatchOverride(!allowOverride);

	}

	public void setMatchOverride(boolean override) {
		allowOverride = override;

		EditText matchTextField = (EditText) findViewById(R.id.matchTextField);
		EditText team1TextField = (EditText) findViewById(R.id.team1TextField);
		EditText team2TextField = (EditText) findViewById(R.id.team2TextField);
		EditText team3TextField = (EditText) findViewById(R.id.team3TextField);

		matchTextField.setEnabled(allowOverride);
		team1TextField.setEnabled(allowOverride);
		team2TextField.setEnabled(allowOverride);
		team3TextField.setEnabled(allowOverride);
	}

	// Updates and fills the match and team number text fields with data
	public void updateMatchAndTeamUI(boolean updateMatch) {

		// Set the correct text and color for the alliance label
		TextView allianceText = (TextView) findViewById(R.id.allianceColorTextView);
		allianceText.setText(isRed ? "Red Alliance" : "Blue Alliance");
		allianceText.setTextColor(isRed ? Color.RED : Color.BLUE);

        Log.e("ASDF", "LOG #1");

		if (qualificationSchedule == null) {
			return;
		}

        Log.e("ASDF", "LOG #2");

		// Find text fields
		EditText matchTextField = (EditText) findViewById(R.id.matchTextField);
		EditText team1TextField = (EditText) findViewById(R.id.team1TextField);
		EditText team2TextField = (EditText) findViewById(R.id.team2TextField);
		EditText team3TextField = (EditText) findViewById(R.id.team3TextField);

		// Get the alliance
		if(matchIndex >= qualificationSchedule.size()) {
			return;
		}

		Log.e("asdf", qualificationSchedule.toString());
		Match currentMatch = qualificationSchedule.get(matchIndex);
        Log.e("asdf", "matchindex: " + matchIndex);
		RealmList<Team> teamNumbers;
		if (isRed) {
			teamNumbers = currentMatch.getRedTeams();
		} else {
			teamNumbers = currentMatch.getBlueTeams();
		}

        Log.e("adffdgfs", currentMatch.toString());

		// Set the match number text
		if(updateMatch) {
            String matchName = currentMatch.getMatch();
            Log.e("asdf", "Match name: " + matchName);
			matchTextField.setText(matchName);
		}

        Log.e("asdf", currentMatch.getBlueTeams().get(0).toString());


		// Set the team number text
        String team1Number = teamNumbers.get(0).getNumber() + "";
        String team2Number = teamNumbers.get(1).getNumber() + "";
        String team3Number = teamNumbers.get(2).getNumber() + "";

        team1TextField.setText(team1Number);
        team2TextField.setText(team2Number);//.get(1).getNumber() + "");
        team3TextField.setText(team3Number);//.get(2).getNumber() + "");

        Log.e("asdf", "matchindex is: " + matchIndex);
	}

	// When the scout button is tapped, read the team and match number info from
	// the text fields, and hand that data off to the MatchActivity
	public void scoutTapped(View view) {
		try {
			int team1 = Integer
					.parseInt(((EditText) findViewById(R.id.team1TextField))
							.getText().toString());
			int team2 = Integer
					.parseInt(((EditText) findViewById(R.id.team2TextField))
							.getText().toString());
			int team3 = Integer
					.parseInt(((EditText) findViewById(R.id.team3TextField))
							.getText().toString());
			String match = ((EditText) findViewById(R.id.matchTextField))
					.getText().toString();
			if (match == null || match.length() == 0) {
				throw new NumberFormatException();
			}

			Intent intent = new Intent(this, AutoActivity.class);
			intent.putExtra(AutoActivity.INTENT_EXTRA_TEAM1_INT, team1);
			intent.putExtra(AutoActivity.INTENT_EXTRA_TEAM2_INT, team2);
			intent.putExtra(AutoActivity.INTENT_EXTRA_TEAM3_INT, team3);
			intent.putExtra(AutoActivity.INTENT_EXTRA_MATCH_STRING, match);
			intent.putExtra(AutoActivity.INTENT_EXTRA_ALLIANCE_COLOR_BOOL,
					isRed ? AutoActivity.ALLIANCE_COLOR_RED
							: AutoActivity.ALLIANCE_COLOR_BLUE);

			startActivityForResult(intent, AutoActivity.REQUEST_ALLIANCE_DATA);
		} catch (NumberFormatException err) {
			Toast toast = Toast.makeText(this, "Invalid teams or match",
					Toast.LENGTH_SHORT);
			toast.show();
		}
	}

	public void showUploadDataToast(int team, boolean success) {
		if (success) {
			Toaster.makeToast(team + " data uploaded!", Toast.LENGTH_SHORT);

		} else {
			Toaster.makeErrorToast(team + " data failed to upload!",
					Toast.LENGTH_LONG);
		}

	}

    private void writeToFile(String text, String fileName) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(fileName.replace("/", ":"), Context.MODE_PRIVATE));
            outputStreamWriter.write(text);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }

    }

    public void uploadRobotDataToDropbox(String jsonData, String matchText,
                                         int teamNumber, boolean superData) {
        String suffix = superData ? "_super" : "";
        String name = "/Change Packets/Unprocessed/"
                + competitionCode + "-" + matchText + "-" + teamNumber
                + suffix + "|" + System.currentTimeMillis() + ".json";
        DbxPath path = new DbxPath(name);

        Log.e("test", "1. " + jsonData);
        try {
            DbxFile file = null;
            Log.e("stupid logcat", "Got path: " + path);

            if (!dbxFs.exists(path)) {
                file = dbxFs.create(path);
            } else {
                file = dbxFs.open(path);
            }

            Log.e("stupid logcat", "Writing " + teamNumber + " to Dropbox");

            file.writeString(jsonData);

            file.close();

            Log.e("stupid logcat", "Wrote " + teamNumber + " to Dropbox");
            Log.e("tag", file == null ? "(null)" : file.toString());

            writeToFile(jsonData, name);

        } catch (DbxException err) {
            err.printStackTrace();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void uploadScoreDataToDropbox(String jsonData, String matchText) {
        DbxPath path = new DbxPath("/Change Packets/Unprocessed/"
                + competitionCode + "-" + matchText + "-officialScores|" + System.currentTimeMillis() + ".json");

        Log.e("test", "1. " + jsonData);
        try {
            DbxFile file = null;
            Log.e("stupid logcat", "Got path: " + path);

            if (!dbxFs.exists(path)) {
                file = dbxFs.create(path);
            } else {
                file = dbxFs.open(path);
            }

            Log.e("stupid logcat", "Writing official scores to Dropbox");

            file.writeString(jsonData);

            file.close();

            Log.e("stupid logcat", "Wrote official scores to Dropbox");
            Log.e("tag", file == null ? "(null)" : file.toString());

        } catch (DbxException err) {
            err.printStackTrace();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

	@SuppressWarnings("unchecked")
	@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("log", "Activity result MAIN: " + resultCode + " TEST " + Activity.RESULT_OK);
        if (requestCode == REQUEST_LINK_TO_DBX) {
            Log.e("stupid logcat", "Link to dropbox done");
            if (resultCode == Activity.RESULT_OK) {
                try {
                    dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr
                            .getLinkedAccount());
                    Log.e("asdF", "it worked?");
                } catch (Unauthorized e) {
                    Log.e("fml", "Something decided to break.");
                    e.printStackTrace();
                }
            } else {
                Log.e("asdf", "THINGS ARE FAILING!!!");
            }
        } else if (requestCode == AutoActivity.REQUEST_ALLIANCE_DATA) {
            Log.e("ASdf", "I HATE ANDROID");
            if (resultCode == 42) {
                Log.e("asDF", "I HATE ANDROID EVEN MORE!!!");
                final HashMap<String, HashMap<String, Object>> matchData = (HashMap<String, HashMap<String, Object>>) data
                        .getSerializableExtra(MatchActivity.RESULT_ALLIANCE_DATA_KEY);
                final String matchText = ((EditText) findViewById(R.id.matchTextField))
                        .getText().toString();

                final HashMap<Integer, String> notes = (HashMap<Integer, String>) data.getSerializableExtra("notes");
                Log.e("stuff", notes.toString());

                Log.e("jdafklja", matchData.keySet().toString());
                Set<String> teamNumbers = matchData.keySet();

                for (String teamString : teamNumbers) {
                    HashMap<String, Object> teamData = matchData
                            .get(teamString);
                    JSONObject teamDataJSON = new JSONObject(teamData);

                    JSONObject teamMainJSON = new JSONObject();
                    try {
                        //teamMainJSON.put("matchNumber", matchText);
                        //teamMainJSON.put("teamNumber",
                        //		Integer.parseInt(teamString));
                        //teamMainJSON.put("superData", teamDataJSON);
                        //teamMainJSON.put("isRed", isRed);
                        teamMainJSON.put("class", "Team");
                        teamMainJSON.put("uniqueValue", Integer.parseInt(teamString));
                        teamMainJSON.put("allianceColor", isRed ? "red" : "blue");

                        JSONArray changesArray = new JSONArray();

                        for (Map.Entry<String, Object> entry : teamData.entrySet()) {
                            Log.e("Test", entry.getKey() + ":" + entry.getValue());
                            JSONObject tmpObject = new JSONObject();
                            tmpObject.put("keyToChange", "matchData." + matchText + ".uploadedData." + entry.getKey().replaceAll("[^a-zA-Z]", ""));
                            tmpObject.put("valueToChangeTo", entry.getValue());
                            changesArray.put(tmpObject);
                        }

                        JSONObject tmpObject = new JSONObject();
                        tmpObject.put("keyToChange", "matchData." + matchText + ".uploadedData.miscellaneousNotes");
                        tmpObject.put("valueToChangeTo", notes.get(Integer.parseInt(teamString)));
                        changesArray.put(tmpObject);

                        teamMainJSON.put("changes", changesArray);

                        JSONObject timeDataFiltered = new JSONObject();

                        String tmpTimeDataString = "[";

                        int index = 0;

                        for (HashMap<String, HashMap<String, Long>> s : (ArrayList<HashMap<String, HashMap<String, Long>>>)data.getSerializableExtra("timeData")) {
                            if (s.get(teamString) != null) {
                                Log.e("AsDf", s.get(teamString).toString());
                                //tmpTimeDataString = tmpTimeDataString + s.get(teamString).toString().replace("{", "{\"").replace("=", "\":") + ",";
                                Iterator it = s.get(teamString).entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry pairs = (Map.Entry)it.next();

                                    JSONObject tmpTimeNumberObject = new JSONObject();
                                    tmpTimeNumberObject.put("keyToChange", "matchData." + matchText + ".uploadedData.reconAcquisitions." + Integer.toString(index) + ".numReconsAcquired");
                                    tmpTimeNumberObject.put("valueToChangeTo", Integer.parseInt(((String)pairs.getKey()).substring(0, 1)));
                                    changesArray.put(tmpTimeNumberObject);

                                    JSONObject tmpTimeTypeObject = new JSONObject();
                                    tmpTimeTypeObject.put("keyToChange", "matchData." + matchText + ".uploadedData.reconAcquisitions." + Integer.toString(index) + ".acquiredMiddle");
                                    tmpTimeTypeObject.put("valueToChangeTo", ((String)pairs.getKey()).substring(((String)pairs.getKey()).length() - 1) == "M");
                                    changesArray.put(tmpTimeTypeObject);

                                    index++;
                                }
                            }
                            Log.e("AsdF", "Logged this thing");
                        }

                        teamMainJSON.put("changes", changesArray);


                        uploadRobotDataToDropbox(teamMainJSON.toString(), matchText, Integer.parseInt(teamString), true);

                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

                //requestOfficialScores();

                incrementMatchIndex();
            }
        } else {
            Log.e("ASdF", "FML");
        }
    }

    public void requestOfficialScores(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Official Scores for Match " + (matchIndex+1));

        final EditText redScore = new EditText(this);
        final EditText blueScore = new EditText(this);
        final RelativeLayout dialogLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams blueLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final RelativeLayout.LayoutParams redLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        redScore.setId(R.id.red_score_input);
        blueScore.setId(R.id.blue_score_input);

        redScore.setHint("Red Score");
        blueScore.setHint("Blue Score");

        dialogLayout.addView(redScore, redLayoutParams);
        dialogLayout.addView(blueScore, blueLayoutParams);

        blueLayoutParams.addRule(RelativeLayout.BELOW, redScore.getId());

        redScore.setInputType(InputType.TYPE_CLASS_NUMBER);
        blueScore.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(dialogLayout);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            String m_Text = "";

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!(redScore.getText().toString().equals("")) && !(blueScore.getText().toString().equals(""))) {
                    SubmitOfficialScores(redScore.getText().toString(), blueScore.getText().toString());
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                } else {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    dialog.cancel();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void SubmitOfficialScores(String redScore, String blueScore) {
        JSONObject changePacket = new JSONObject();
        try {
            changePacket.put("uniqueValue", "Q" + matchIndex);
            changePacket.put("class", "Match");
            JSONArray changesArray = new JSONArray();

            JSONObject redScoreObject = new JSONObject();
            redScoreObject.put("keyToChange", "officialRedScore");
            redScoreObject.put("valueToChangeTo", Integer.parseInt(redScore));
            changesArray.put(redScoreObject);

            JSONObject blueScoreObject = new JSONObject();
            blueScoreObject.put("keyToChange", "officialBlueScore");
            blueScoreObject.put("valueToChangeTo", Integer.parseInt(blueScore));
            changesArray.put(blueScoreObject);

            changePacket.put("changes", changesArray);

            Log.e("asdF", changePacket.toString());
            uploadScoreDataToDropbox(changePacket.toString(), "Q" + matchIndex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


	// Cat stuff...
	public void kittyClicked(View view) {
		int rnd = (int) (Math.random() * 11);
		switch (rnd) {
		case 0:
			playSound(R.raw.purr1);
			break;
		case 1:
			playSound(R.raw.purr2);
			break;
		case 2:
			playSound(R.raw.purr3);
			break;
		case 3:
			playSound(R.raw.distressedkitten);
			break;
		case 4:
			playSound(R.raw.purr5);
			break;
		case 5:
			playSound(R.raw.tinky);
			break;
		case 6:
			playSound(R.raw.tinky);
			break;
		case 7:
			playSound(R.raw.purr5);
			break;
		case 8:
			playSound(R.raw.purr1);
			break;
		case 9:
			playSound(R.raw.distressedkitten);
			break;
		case 10:
            int rnd2 = (int) (Math.random() * 3);
            if (rnd2 == 0) {
                playSound(R.raw.bark);
                Log.e("stupid logcat", "I'm a dog!");
            } else {
                playSound(R.raw.distressedkitten);
            }
			break;
		// HeheheheheheheHahahahahahahahhahahahahahahhahahhh!!!!!!!!!!
		// 3/11!
		// -Wesley.

		}
	}

	public void playSound(int sound) {
		if (mp == null) {
			mp = MediaPlayer.create(this, sound);

			final MainActivity myThis = this;
			mp.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					// TODO Auto-generated method stub
					mp.release();
					myThis.mp = null;
				}

			});
			mp.start();
		}
	}
}
