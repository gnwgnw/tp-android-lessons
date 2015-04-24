package com.tp.gexogen.lessons.lesson7;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

/**
 * author s.titaevskiy on 23.04.15.
 */
public class Lesson7Activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v1 = new View(this);
		v1.setBackgroundColor(Color.GREEN);
		View v2 = new View(this);
		v2.setBackgroundColor(Color.CYAN);
		CustomViewGroup viewGroup = new CustomViewGroup(this);
		viewGroup.addView(v1);
		viewGroup.addView(v2);
		setContentView(viewGroup);
	}
}
