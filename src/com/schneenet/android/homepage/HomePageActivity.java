package com.schneenet.android.homepage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class HomePageActivity extends Activity
{

	private static final TableRow.LayoutParams ROW_PARAMS = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
	
	private LayoutInflater mFactory;
	private TableLayout mHomeGrid;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		mFactory = LayoutInflater.from(this);
		mHomeGrid = new TableLayout(this);
		
		//mHomeGrid.setLayoutAnimation(controller);
		
		ScrollView s = new ScrollView(this);
		s.addView(mHomeGrid, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		setContentView(s);
		
		populateHome();

	}
	
	private void populateHome()
	{
		// 0. Remove All Existing Views from Layout
		mHomeGrid.removeAllViews();
		
		// 1. Grab and interpret the layout from storage
		
		
		// 2. (TableLayout ONLY) For each widget in list:
		//    a. Double-wide?
		//       - Add widget directly to mHomeGrid
		//    b. Single-wide?
		//       - Build a TableRow
		//       - Add two widgets to TableRow using ROW_PARAMS
		//       - Add row to mHomeGrid
		
		int row = 0;
		
		TableRow row1 = new TableRow(this);
		
		View v3 = mFactory.inflate(R.layout.home_grid_item, null, false);
		v3.findViewById(R.id.container).setBackgroundColor(0xFF009900);
		TileView tv3 = new TileView(this);
		tv3.addView(v3);
		row1.addView(tv3);
		
		View v4 = mFactory.inflate(R.layout.home_grid_item, null, false);
		v4.findViewById(R.id.container).setBackgroundColor(0xFF000000);
		TileView tv4 = new TileView(this);
		tv4.addView(v4);
		row1.addView(tv4);
		
		mHomeGrid.addView(row1);
		
		row++;
		
		View v5 = mFactory.inflate(R.layout.digital_clock_grid_item, null, false);
		v5.findViewById(R.id.container).setBackgroundColor(0xFF995500);
		TileView tv5 = new TileView(this);
		tv5.setHalfHeight(true);
		tv5.addView(v5);
		mHomeGrid.addView(tv5);
		
		row++;
		
		TableRow row2 = new TableRow(this);
		
		View v = mFactory.inflate(R.layout.home_grid_item, null, false);
		v.findViewById(R.id.container).setBackgroundColor(0xFF990000);
		TileView tv = new TileView(this);
		tv.addView(v);
		row2.addView(tv);
		
		View v2 = mFactory.inflate(R.layout.home_grid_item, null, false);
		v2.findViewById(R.id.container).setBackgroundColor(0xFF000099);
		TileView tv2 = new TileView(this);
		tv2.addView(v2);
		row2.addView(tv2);
		
		mHomeGrid.addView(row2);
	
	}
}