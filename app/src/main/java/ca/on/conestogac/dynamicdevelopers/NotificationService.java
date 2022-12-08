package ca.on.conestogac.dynamicdevelopers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {

    private int counter = 0;

    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
      //  throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {

        Toast toast = Toast.makeText(this, "Service loop", Toast.LENGTH_SHORT);

        final Timer timer = new Timer(true);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_message))
                .build();
        final NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        counter = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                counter++;
                toast.show();

                if (counter >= 3) {
                    manager.notify(1,notification);

                    timer.cancel();
                    stopSelf();
                }
            }
        }, 2000, 5000 );

        Toast.makeText(this,"Service onCreate called TESTING THIS", Toast.LENGTH_SHORT).show();
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service on deStroy called", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}