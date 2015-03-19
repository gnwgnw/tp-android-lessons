package com.tp.gexogen.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.tp.gexogen.lessons.lesson1.Lesson1Activity;
import com.tp.gexogen.lessons.lesson2.Lesson2Activity;
import com.tp.gexogen.lessons.lesson5.Lesson5Activity;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.main_activity_button_open_lesson1).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Lesson1Activity.class));
			}
		});

		findViewById(R.id.main_activity_button_open_lesson2).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Lesson2Activity.class));
			}
		});

		findViewById(R.id.main_activity_button_open_lesson5).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Lesson5Activity.class));
			}
		});
	}
}
