package org.citruscircuits.super_scouter_2014_android;

import java.util.HashMap;

import org.citruscircuits.data_input.DataInputView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteActivity extends Activity
{
	public final static String INTENT_EXTRA_TEAM_INT = "org.citruscircuits.super_scouter_2014_android.team1";
	public final static String INTENT_EXTRA_MATCH_STRING = "org.citruscircuits.super_scouter_2014_android.match";
	public final static String INTENT_EXTRA_ALLIANCE_COLOR_BOOL = "org.citruscircuits.super_scouter_2014_android.allianceColor";

	public final static boolean ALLIANCE_COLOR_RED = false;
	public final static boolean ALLIANCE_COLOR_BLUE = true;

	public final static int REQUEST_ALLIANCE_DATA = 1;
	public final static String RESULT_ALLIANCE_DATA_KEY = "org.citruscircuits.super_scouter_2014_android.matchData";

	int team;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		
		

		LinearLayout team1Layout = (LinearLayout) this.findViewById(R.id.team1Layout);

		// Setup layout params to center columns
		setupLayoutParams();

		// Set the team label texts and colors to team info from the MainActivity,
		// and set the title to match number from the MainActivity
		Intent intent = getIntent();
		team = intent.getIntExtra(INTENT_EXTRA_TEAM_INT, 1337);

		TextView team1TextView = (TextView) this.findViewById(R.id.team1TextView);

		team1TextView.setText(team + "");

		int color = intent.getBooleanExtra(INTENT_EXTRA_ALLIANCE_COLOR_BOOL, ALLIANCE_COLOR_RED) == ALLIANCE_COLOR_RED ? Color.RED : Color.BLUE;
		team1TextView.setTextColor(color);

		setTitle("Match " + intent.getStringExtra(INTENT_EXTRA_MATCH_STRING));
	}

	private void setupLayoutParams()
	{
		LinearLayout team1Layout = (LinearLayout) this.findViewById(R.id.team1Layout);

		// Setup layout params to center columns
		//LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);

		LinearLayout rootLayout = (LinearLayout) this.findViewById(R.id.rootLayout);
		rootLayout.setWeightSum(1.0f);

		//team1Layout.setLayoutParams(params);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.match, menu);
		return true;
	}

    public void openNotes(View view) {
        Log.e("asdf", (((ImageButton)view).getTag()) + "");
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle presses on the action bar items
		if (item.getItemId() == R.id.action_done)
		{
			Log.e("logcat sucks", "Done pressed");

			LinearLayout team1Layout = (LinearLayout) this.findViewById(R.id.team1Layout);
			
			// Create an intent with the collected match data
			Intent resultIntent = new Intent();
            EditText et = (EditText)this.findViewById(R.id.noteText);
			resultIntent.putExtra(RESULT_ALLIANCE_DATA_KEY, et.getText().toString());
            resultIntent.putExtra("teamNum", team);
			setResult(Activity.RESULT_OK, resultIntent);

			finish();
		}
		return true;
	}

}
