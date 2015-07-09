package org.citruscircuits.data_input;

import java.util.Arrays;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public abstract class DataInputView extends LinearLayout
{
	protected String dataKey;

	public void setDataKey(String key)
	{
		dataKey = key;
	}

	public String getDataKey()
	{
		return dataKey;
	}
	
	public abstract Object getDataValue();

	public DataInputView(Context context, String dataKey, String[] args)
	{
		super(context);

		this.dataKey = dataKey;
	}

	// Helper method for filling LinearLayouts with DataInputViews
	public static void fillLayoutWithItems(Context context, LinearLayout layout, String[][] items)
	{
		for (String[] item : items)
		{
			String key = item[0];
			String type = item[1];

			String[] args = {};
			if (item.length > 2)
			{
				args = Arrays.copyOfRange(item, 2, item.length);
			}

			try
			{
				Class<?> itemClass = Class.forName("org.citruscircuits.data_input." + type);
				if (DataInputView.class.isAssignableFrom(itemClass))
				{
					DataInputView inputView = (DataInputView) itemClass.getConstructor(Context.class, String.class, String[].class).newInstance(context, key, args);
					inputView.setPadding(0, 2, 0, 0);
					layout.addView(inputView, 1);
				}
				else
				{
					throw new ClassNotFoundException();
				}
			}
			catch (ClassNotFoundException e)
			{
				Log.e("ERROR", "Invalid input type " + type);
				e.printStackTrace();
			}
			catch (NoSuchMethodException e)
			{
				Log.e("ERROR", "Input type " + type + " does not contain the constructor DataInputView(Context context, String key, String[] args)");
				e.printStackTrace();
			}
			catch (Exception e)
			{
				Log.e("ERROR", "Unknown error instantiating input type " + type);
				e.printStackTrace();
			}

		}
	}

	public static HashMap<String, Object> collectDataInLayout(LinearLayout layout)
	{
		int count = layout.getChildCount();
		HashMap<String, Object> layoutData = new HashMap<String, Object>();
		for (int i = 0; i < count; i++)
		{
			View view = layout.getChildAt(i);
			if (view instanceof DataInputView)
			{
				DataInputView input = (DataInputView) view;
				
				String key = input.getDataKey();
				Object dataValue = input.getDataValue();
				
				layoutData.put(key, dataValue);
			}
		}
		
		return layoutData;
	}
}
