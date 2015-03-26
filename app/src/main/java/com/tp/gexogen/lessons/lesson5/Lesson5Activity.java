package com.tp.gexogen.lessons.lesson5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.tp.gexogen.lessons.R;

public class Lesson5Activity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lesson5);

		findViewById(R.id.activity_lesson5_button_doservice).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				Parcelable receiver = new ResultReceiver(new Handler()) {
					@Override
					protected void onReceiveResult(int resultCode, Bundle resultData) {
						((TextView) findViewById(R.id.activity_lesson5_edit_text_output))
								.setText(resultData.getString(UrlService.JOB));
					}
				};
				Intent intent = new Intent(Lesson5Activity.this, UrlService.class);
				intent.putExtra(UrlService.RECEIVER, receiver);
				startService(intent);
			}
		});

		findViewById(R.id.activity_lesson5_button_foreground_start).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Lesson5Activity.this, ForegroundService.class);
				startService(intent);
			}
		});

		findViewById(R.id.activity_lesson5_button_foreground_stop).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Lesson5Activity.this, ForegroundService.class);
				stopService(intent);
			}
		});
	}
}
