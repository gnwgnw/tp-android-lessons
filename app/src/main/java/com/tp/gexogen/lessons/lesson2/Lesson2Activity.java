package com.tp.gexogen.lessons.lesson2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tp.gexogen.lessons.R;


public class Lesson2Activity extends ActionBarActivity {

	private boolean gone = false;
	private ProgressDialog dialog = null;
	private Button buttonAsync = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lesson2_activity);

		buttonAsync = (Button) findViewById(R.id.lesson2_activity_button_async);
		buttonAsync.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog = new ProgressDialog(Lesson2Activity.this);
				dialog.setTitle("Async");
				dialog.setMessage("Message");
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.setMax(15);

				buttonAsync.setEnabled(false);

				new SleepTask().execute();
			}
		});

		findViewById(R.id.lesson2_activity_button_hide).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				View view = findViewById(R.id.lesson2_activity_button_async);
				if (gone) {
					view.setVisibility(View.VISIBLE);
					gone = false;
				}
				else {
					view.setVisibility(View.GONE);
					gone = true;
				}
			}
		});

		findViewById(R.id.lesson2_activity_button_toast).setOnClickListener(new View
				.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Toast.makeText(getApplicationContext(), Thread.currentThread()
										.getName(), Toast.LENGTH_SHORT).show();
							}
						});
					}
				}).start();
			}
		});
	}

	private class SleepTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			for (int i = 0; i < 15; ++i) {
				publishProgress(i);
				SystemClock.sleep(1000);
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			dialog.setProgress(values[0]);
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			dialog.hide();
			buttonAsync.setEnabled(true);
		}
	}
}
