package com.schneenet.android.homepage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableRow;

public class TileView extends FrameLayout
{

	private boolean mHalfHeight = false;

	public TileView(Context context)
	{
		super(context);
		init();
	}

	public TileView(Context context, AttributeSet attributeSet)
	{
		super(context, attributeSet);
		init();
	}

	public void setHalfHeight(boolean halfHeight)
	{
		mHalfHeight = halfHeight;
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int width = MeasureSpec.getSize(widthMeasureSpec);
		setMeasuredDimension(width, mHalfHeight ? width / 2 : width);
		ViewGroup.MarginLayoutParams mlp;
		if (getLayoutParams() instanceof TableRow.LayoutParams)
			mlp = new TableRow.LayoutParams(width, mHalfHeight ? width / 2 : width, 1.0f);
		else
			mlp = new LinearLayout.LayoutParams(width, mHalfHeight ? width / 2 : width);
		setLayoutParams(mlp);

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	private void init()
	{
		int padding = getResources().getDimensionPixelSize(R.dimen.tile_margin);
		setPadding(padding, padding, padding, padding);
	}

}
