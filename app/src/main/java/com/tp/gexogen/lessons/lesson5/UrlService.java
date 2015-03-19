package com.tp.gexogen.lessons.lesson5;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import java.util.concurrent.TimeUnit;

/**
 * author s.titaevskiy on 19.03.15.
 */
public class UrlService extends IntentService {

	public static final String RECEIVER = "receiver";
	public static final String JOB = "job";

	public UrlService() {
		super("name");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		ResultReceiver receiver = intent.getParcelableExtra(RECEIVER);
		Bundle bundle = new Bundle();
		bundle.putString(JOB, "Done");
		try {
			TimeUnit.SECONDS.sleep(1);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		receiver.send(Activity.RESULT_OK, bundle);
	}
}
