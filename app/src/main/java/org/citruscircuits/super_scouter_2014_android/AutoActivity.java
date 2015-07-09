package org.citruscircuits.super_scouter_2014_android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.citruscircuits.data_input.DataInputView;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AutoActivity extends Activity
{
	public final static String INTENT_EXTRA_TEAM1_INT = "org.citruscircuits.super_scouter_2014_android.team1";
	public final static String INTENT_EXTRA_TEAM2_INT = "org.citruscircuits.super_scouter_2014_android.team2";
    public final static String INTENT_EXTRA_TEAM3_INT = "org.citruscircuits.super_scouter_2014_android.team3";
    public final static String INTENT_EXTRA_TEAM_INT = "org.citruscircuits.super_scouter_2014_android.team";
	public final static String INTENT_EXTRA_MATCH_STRING = "org.citruscircuits.super_scouter_2014_android.match";
	public final static String INTENT_EXTRA_ALLIANCE_COLOR_BOOL = "org.citruscircuits.super_scouter_2014_android.allianceColor";

	public final static boolean ALLIANCE_COLOR_RED = false;
	public final static boolean ALLIANCE_COLOR_BLUE = true;

	public final static int REQUEST_ALLIANCE_DATA = 1;
	public final static String RESULT_ALLIANCE_DATA_KEY = "org.citruscircuits.super_scouter_2014_android.matchData";

	int team1;
	int team2;
	int team3;

    int color;

    long startTime;

    private int middleRemainingRecons = 2;
    private int sideRemainingRecons = 2;

    ArrayList<HashMap<String, HashMap<String, Long>>> times = new ArrayList<HashMap<String, HashMap<String, Long>>>();

    public Map<Integer, String> notes;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto);

		// Set the team label texts and colors to team info from the MainActivity,
		// and set the title to match number from the MainActivity
		Intent intent = getIntent();
		team1 = intent.getIntExtra(INTENT_EXTRA_TEAM1_INT, 0);
		team2 = intent.getIntExtra(INTENT_EXTRA_TEAM2_INT, 0);
		team3 = intent.getIntExtra(INTENT_EXTRA_TEAM3_INT, 0);

		TextView team1TextView = (TextView) this.findViewById(R.id.team1TextView);
		TextView team2TextView = (TextView) this.findViewById(R.id.team2TextView);
		TextView team3TextView = (TextView) this.findViewById(R.id.team3TextView);

		team1TextView.setText(team1 + "");
		team2TextView.setText(team2 + "");
		team3TextView.setText(team3 + "");

        notes = new HashMap<Integer, String>();
        notes.put(team1, "");
        notes.put(team2, "");
        notes.put(team3, "");

		color = intent.getBooleanExtra(INTENT_EXTRA_ALLIANCE_COLOR_BOOL, ALLIANCE_COLOR_RED) == ALLIANCE_COLOR_RED ? Color.RED : Color.BLUE;
        Log.e("sdfg", color + " " + Color.RED + "=red  " + Color.BLUE + "=blue");
		team1TextView.setTextColor(color);
		team2TextView.setTextColor(color);
		team3TextView.setTextColor(color);

		setTitle("Match " + intent.getStringExtra(INTENT_EXTRA_MATCH_STRING));
	}

	private void setupLayoutParams()
	{
		LinearLayout team1Layout = (LinearLayout) this.findViewById(R.id.team1Layout);
		LinearLayout team2Layout = (LinearLayout) this.findViewById(R.id.team2Layout);
		LinearLayout team3Layout = (LinearLayout) this.findViewById(R.id.team3Layout);

		// Setup layout params to center columns
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
		params.weight = 0.333333f;

		LinearLayout rootLayout = (LinearLayout) this.findViewById(R.id.rootLayout);
		rootLayout.setWeightSum(1.0f);

		team1Layout.setLayoutParams(params);
		team2Layout.setLayoutParams(params);
		team3Layout.setLayoutParams(params);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auto, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle presses on the action bar items
		if (item.getItemId() == R.id.action_done)
		{
			Log.e("logcat sucks", "Done pressed");

			LinearLayout team1Layout = (LinearLayout) this.findViewById(R.id.team1Layout);
			LinearLayout team2Layout = (LinearLayout) this.findViewById(R.id.team2Layout);
			LinearLayout team3Layout = (LinearLayout) this.findViewById(R.id.team3Layout);

			HashMap<String, Object> team1Data = DataInputView.collectDataInLayout(team1Layout);
			HashMap<String, Object> team2Data = DataInputView.collectDataInLayout(team2Layout);
			HashMap<String, Object> team3Data = DataInputView.collectDataInLayout(team3Layout);

			HashMap<String, HashMap<String, Object>> allianceData = new HashMap<String, HashMap<String, Object>>();
			allianceData.put(team1 + "", team1Data);
			allianceData.put(team2 + "", team2Data);
			allianceData.put(team3 + "", team3Data);
			
			// Create an intent with the collected match data
//			Intent resultIntent = new Intent();
//			resultIntent.putExtra(RESULT_ALLIANCE_DATA_KEY, allianceData); // TODO: Replace with actual data (Dictionary)
//            resultIntent.putExtra("notes", (HashMap<Integer, String>)notes);
//			setResult(Activity.RESULT_OK, resultIntent);


            Intent intent = new Intent(this, MatchActivity.class);
            intent.putExtra(MatchActivity.INTENT_EXTRA_TEAM1_INT, team1);
            intent.putExtra(MatchActivity.INTENT_EXTRA_TEAM2_INT, team2);
            intent.putExtra(MatchActivity.INTENT_EXTRA_TEAM3_INT, team3);
            intent.putExtra(MatchActivity.INTENT_EXTRA_MATCH_STRING, getIntent().getStringExtra(INTENT_EXTRA_MATCH_STRING));
            intent.putExtra("color", (color == Color.RED) ? Color.RED : Color.BLUE);
            intent.putExtra("timeData", times);
            intent.putExtra("team1failed", Integer.parseInt((String)((TextView)findViewById(R.id.firstReconNum)).getText()));
            intent.putExtra("team2failed", Integer.parseInt((String)((TextView)findViewById(R.id.secondReconNum)).getText()));
            intent.putExtra("team3failed", Integer.parseInt((String)((TextView)findViewById(R.id.thirdReconNum)).getText()));

            startActivityForResult(intent, MatchActivity.REQUEST_ALLIANCE_DATA);

			//finish();
		}
		return true;
	}

    public void reconClick(View view) {  // AKA BEST CODE EVAR!
        HashMap<String, HashMap<String, Long>> tmpMap = new HashMap<String, HashMap<String, Long>>();
        HashMap<String, Long> tmpInnerHash = new HashMap<String, Long>();

        tmpInnerHash.put((((Button)view).getTag().toString().substring(0, ((Button) view).getTag().toString().length() - 1)), System.currentTimeMillis() - startTime);

        String team;

        if (((Button)view).getTag().toString().charAt(((Button)view).getTag().toString().length() - 1) == "1".toCharArray()[0]) {
            team = team1 + "";
        } else if (((Button)view).getTag().toString().charAt(((Button)view).getTag().toString().length() - 1) == "2".toCharArray()[0]) {
            team = team2 + "";
        } else {
            team = team3 + "";
        }

        tmpMap.put(team, tmpInnerHash);
        times.add(tmpMap);

        String clickedButtonText = ((Button) view).getText().toString();
        boolean clickedSide;
        if (clickedButtonText.substring(clickedButtonText.length() - 4, clickedButtonText.length()).equals("Side")) {
            Log.e("test", "True");
            clickedSide = true;
        } else {
            clickedSide = false;
        }

        int numRecons = Integer.parseInt(clickedButtonText.substring(0, 1));

        if (clickedSide || numRecons == 3) {
            int middle = numRecons - 1;
            Log.e("test", "The number of middle recons taken is " + middle);
            sideRemainingRecons--;
            middleRemainingRecons -= middle;
        } else if (numRecons == 4) {
            middleRemainingRecons = 0;
            sideRemainingRecons = 0;
        } else {
            middleRemainingRecons -= numRecons;
        }

        View rootLayout = findViewById(R.id.rootLayout);
        String[] locations = {"M", "S"};
        ArrayList<String> tags = new ArrayList<String>();

        String tag;
        for (int i = 1; i < 4; i++) {
            for (int o = 1; o < 5; o++) {
                if (o < 3) {
                    for (String location : locations) {
                        tag = o + location + i;
                        tags.add(tag);
                    }
                } else {
                    tag = o + (i + "");
                    tags.add(tag);
                }
            }
        }



        ArrayList<Button> reconButtons = new ArrayList<Button>();

        for (String tagToFind : tags) {
            Button reconButton = (Button) rootLayout.findViewWithTag(tagToFind);
            reconButtons.add(reconButton);
        }

        Log.e("test", tags.toString());

//        Map<Button, Object> reconButtonsWithInfo = new HashMap<Button, Object>();
//        for (Button reconButton : reconButtons) {
//            Map<String, Object> buttonInfo = new HashMap<String, Object>();
//            String buttonText = (String)reconButton.getText();
//
//
//            boolean side;
//            if (buttonText.substring(buttonText.length() - 4, buttonText.length()).equals("Side")) {
//                Log.e("test", "True");
//                side = true;
//            } else {
//                side = false;
//            }
//            buttonInfo.put("side", side);
//
//        }

        for (Button button : reconButtons) {
            String forButtonText = button.getText().toString();
            int forButtonNumRecons = Integer.parseInt(forButtonText.substring(0, 1));
            Log.e("test", forButtonNumRecons + "");
            boolean isSide = false;
            if (forButtonText.length() != 1) {
                isSide = forButtonText.substring(forButtonText.length() - 4, forButtonText.length()).equals("Side");
            } else if (forButtonNumRecons == 3) {
                isSide = true;
            }

            if (forButtonNumRecons > middleRemainingRecons + sideRemainingRecons) {
                button.setEnabled(false);
            } else if (isSide && sideRemainingRecons < 1 || (forButtonNumRecons - 1) > middleRemainingRecons) {
                button.setEnabled(false);
            } else if (!isSide && forButtonNumRecons > middleRemainingRecons) {
                button.setEnabled(false);
            }
        }
    }

    public void reconFailedClick(View view) {

        TextView numView = null;

        if (view.getTag().toString().substring(0,1).equals("1")) {
            numView = ((TextView)(findViewById(R.id.firstReconNum)));
        }

        if (view.getTag().toString().substring(0,1).equals("2")) {
            numView = ((TextView)(findViewById(R.id.secondReconNum)));
        }

        if (view.getTag().toString().substring(0,1).equals("3")) {
            numView = ((TextView)(findViewById(R.id.thirdReconNum)));
        }

        int num = 0;
        if (view.getTag().toString().substring(1,2).equals("+")) {
            num = Integer.parseInt((String)numView.getText())+1;
        } else {
            num = Integer.parseInt((String)numView.getText())-1;
        }
        if (num<0) {
            num = 0;
        }
        numView.setText(Integer.toString(num));
    }

    public void startMatch(View view) {
        Log.e("asdf", "YOU CLICKED THE THING!");
        ((Button)view).setVisibility(View.GONE);
        startTime = System.currentTimeMillis();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Create an intent with the collected match data
        if (resultCode == RESULT_OK) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra(RESULT_ALLIANCE_DATA_KEY, data.getSerializableExtra(RESULT_ALLIANCE_DATA_KEY)); // TODO: Replace with actual data (Dictionary)
            resultIntent.putExtra("notes", data.getSerializableExtra("notes"));
            Log.e("test", "Does this happen?????");
            resultIntent.putExtra("timeData", data.getSerializableExtra("timeData"));
            setResult(42, resultIntent);
            finish();
        } else if (resultCode == 666) {
            setResult(666);
            finish();
        }
    }

}
