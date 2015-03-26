package com.tp.gexogen.lessons.lesson5;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

/**
 * author s.titaevskiy on 26.03.15.
 */
public class ForegroundService extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Notification notification = new NotificationCompat.Builder(this)
				.setContentTitle("Title")
				.setContentText("Text")
				.setSmallIcon(android.R.drawable.ic_delete)
				.build();

		startForeground(1234, notification);

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		stopForeground(true);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
