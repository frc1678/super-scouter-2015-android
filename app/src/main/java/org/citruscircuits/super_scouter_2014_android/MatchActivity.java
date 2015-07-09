package org.citruscircuits.super_scouter_2014_android;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.citruscircuits.data_input.DataInputView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFileSystem;

public class MatchActivity extends Activity
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

    public Map<Integer, String> notes;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_match);
		
		

		LinearLayout team1Layout = (LinearLayout) this.findViewById(R.id.team1Layout);
		LinearLayout team2Layout = (LinearLayout) this.findViewById(R.id.team2Layout);
		LinearLayout team3Layout = (LinearLayout) this.findViewById(R.id.team3Layout);

		// Setup layout params to center columns
		setupLayoutParams();

		// Fill the columns with UI controls
		DataInputView.fillLayoutWithItems(this, team1Layout, DataCollectionItems.items);
		DataInputView.fillLayoutWithItems(this, team2Layout, DataCollectionItems.items);
		DataInputView.fillLayoutWithItems(this, team3Layout, DataCollectionItems.items);

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

		int color = intent.getIntExtra("color", Color.GREEN);
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

    public void reconKnockedOverClick(View view) {

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.match, menu);
		return true;
	}

    public void openNotes(View view) {
        Log.e("asdf", (((Button)view).getTag()) + "");
        try {
            int teamNumber = Integer.parseInt((((Button)view).getTag()) + "");
            int realTeamNumber = 0;
            if (teamNumber == 0) {
                realTeamNumber = getIntent().getIntExtra(INTENT_EXTRA_TEAM1_INT, 0);
            } else if (teamNumber == 1) {
                realTeamNumber = getIntent().getIntExtra(INTENT_EXTRA_TEAM2_INT, 0);
            } else if (teamNumber == 2) {
                realTeamNumber = getIntent().getIntExtra(INTENT_EXTRA_TEAM3_INT, 0);
            }

            Log.e("asdf", realTeamNumber+"");

            String match = getIntent().getStringExtra(INTENT_EXTRA_MATCH_STRING);
            if (match == null || match.length() == 0) {
                throw new NumberFormatException();
            }

            Intent intent = new Intent(this, NoteActivity.class);
            intent.putExtra(NoteActivity.INTENT_EXTRA_TEAM_INT, realTeamNumber );
            intent.putExtra(NoteActivity.INTENT_EXTRA_MATCH_STRING, match);
            intent.putExtra(NoteActivity.INTENT_EXTRA_ALLIANCE_COLOR_BOOL,
                    (intent.getBooleanExtra(INTENT_EXTRA_ALLIANCE_COLOR_BOOL, ALLIANCE_COLOR_RED) == ALLIANCE_COLOR_RED) ? NoteActivity.ALLIANCE_COLOR_RED
                            : NoteActivity.ALLIANCE_COLOR_BLUE);

            startActivityForResult(intent, NoteActivity.REQUEST_ALLIANCE_DATA);
        } catch (NumberFormatException err) {
            Toast toast = Toast.makeText(this, "Invalid teams or match",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
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

            team1Data.put("numStepReconAcquisitionsFailed", getIntent().getIntExtra("team1failed", 0));
            team2Data.put("numStepReconAcquisitionsFailed", getIntent().getIntExtra("team2failed", 0));
            team3Data.put("numStepReconAcquisitionsFailed", getIntent().getIntExtra("team3failed", 0));

            HashMap<String, HashMap<String, Object>> allianceData = new HashMap<String, HashMap<String, Object>>();
			allianceData.put(team1 + "", team1Data);
			allianceData.put(team2 + "", team2Data);
			allianceData.put(team3 + "", team3Data);
			
			// Create an intent with the collected match data
			Intent resultIntent = new Intent();
			resultIntent.putExtra(RESULT_ALLIANCE_DATA_KEY, allianceData); // TODO: Replace with actual data (Dictionary)
            resultIntent.putExtra("notes", (HashMap<Integer, String>)notes);
            resultIntent.putExtra("timeData", getIntent().getSerializableExtra("timeData"));
            resultIntent.putExtra("status", "PASS_RESULT");
			setResult(Activity.RESULT_OK, resultIntent);

			finish();
		}
		return true;
	}

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Are you sure you want to stop scouting?");
        alert.setMessage("You will have to restart the match!");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                MatchActivity.this.setResult(666);
                MatchActivity.this.finish();
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("log", "Activity result");
        if (requestCode == MatchActivity.REQUEST_ALLIANCE_DATA) {
            if (resultCode == Activity.RESULT_OK) {
                Log.e("asdfTW", data.getStringExtra(RESULT_ALLIANCE_DATA_KEY));
                Log.e("tn", Integer.toString(data.getIntExtra("teamNum", 0)));
                notes.put(data.getIntExtra("teamNum", 0), data.getStringExtra(RESULT_ALLIANCE_DATA_KEY));
            }
        }
    }

}
