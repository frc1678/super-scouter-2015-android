package org.citruscircuits.data_input;

import android.content.Context;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Stepper extends DataInputView implements OnTouchListener
{
	private Button plusButton, minusButton;
	private TextView textLabel;
	private TextView valueText;
	private int value, max, min;

	public Stepper(Context context)
	{
		this(context, "my_key", new String[] { "Default" });
	}
	
	public Stepper(Context context, String dataKey, String[] args)
	{
		super(context, dataKey, args);
		
		String text = args[0];
		
		this.max = Integer.parseInt(args[2]);
		this.min = Integer.parseInt(args[1]);

		this.setWeightSum(1.0f);
		LayoutParams bigParams = new LayoutParams(0, LayoutParams.MATCH_PARENT);
		bigParams.weight = 0.4f;

		LayoutParams smallParams = new LayoutParams(0, LayoutParams.MATCH_PARENT);
		smallParams.weight = 0.2f;

		textLabel = new TextView(context);
		textLabel.setTextSize(16.0f);
		textLabel.setPadding(0, 0, 10, 0);
		textLabel.setText(text + ":");
		textLabel.setLayoutParams(bigParams);

		minusButton = new Button(context);
		minusButton.setText("\u2013");
		minusButton.setTextSize(20.0f);
		minusButton.setOnTouchListener(this);
		minusButton.setPadding(0, 0, 0, 0);
		minusButton.setLayoutParams(smallParams);

		valueText = new TextView(context);
		valueText.setTextSize(20.0f);
		valueText.setPadding(10, 0, 10, 0);
		valueText.setLayoutParams(smallParams);
		valueText.setGravity(Gravity.CENTER_HORIZONTAL);

		plusButton = new Button(context);
		plusButton.setText("+");
		plusButton.setTextSize(20.0f);
		plusButton.setOnTouchListener(this);
		plusButton.setPadding(0, 0, 0, 0);
		plusButton.setLayoutParams(smallParams);

		this.setOrientation(LinearLayout.HORIZONTAL);
		this.setPadding(0, 10, 0, 10);

		this.addView(textLabel);
		this.addView(minusButton);
		this.addView(valueText);
		this.addView(plusButton);

		this.setValue(0);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			if (plusButton == v)
			{
				if (value < max)
				{
					value++;
				}
			}
			else
			{
				if (value > min)
				{
					value--;
				}
			}
			setValue(value);
		}

		return false;
	}

	public Object getDataValue()
	{
		return this.value;
	}

	private void setValue(int value)
	{
		this.value = value;

		valueText.setText(Integer.toString(value));
	}
}
