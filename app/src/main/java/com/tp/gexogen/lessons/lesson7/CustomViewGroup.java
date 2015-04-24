package com.tp.gexogen.lessons.lesson7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * author s.titaevskiy on 23.04.15.
 */
public class CustomViewGroup extends ViewGroup {

	private float lastX = 240;

	public CustomViewGroup(Context context) {
		this(context, null);
	}

	public CustomViewGroup(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int shift = (r - l) / 2;
		int middle = (r - l) / 4;

		int childCount = getChildCount();
		for (int i = 0; i < childCount; ++i) {
			getChildAt(i).layout(l - middle + i * shift, t, r - middle - (1 - i) * shift, b);
		}
	}

	@Override
	public boolean onTouchEvent(@NonNull MotionEvent event) {
		float curX = event.getX();
		float dx = curX - lastX;
		lastX = curX;

		int childCount = getChildCount();
		for (int i = 0; i < childCount; ++i) {
			getChildAt(i).offsetLeftAndRight((int) dx);
		}
		return true;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);

		int childCount = getChildCount();
		for (int i = 0; i < childCount; ++i) {
			getChildAt(i).measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
					MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
		}
		setMeasuredDimension(2 * width, height);
	}
}
