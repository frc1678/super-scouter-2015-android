package org.citruscircuits.data_input;

import android.content.Context;
import android.widget.ToggleButton;

public class Toggle extends DataInputView
{
	ToggleButton toggleButton;

	public Toggle(Context context)
	{
		this(context, "my_key", new String[] { "Off", "On" });
	}

	public Toggle(Context context, String dataKey, String[] args)
	{
		super(context, dataKey, args);

		toggleButton = new ToggleButton(context);

		toggleButton.setTextOff(args[0]);
		toggleButton.setTextOn(args[1]);
		toggleButton.setText(args[0]);

		toggleButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		this.addView(toggleButton);
	}

	public Object getDataValue()
	{
		return this.toggleButton.isChecked();
	}

}
