package edu.dtcc.emailman.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createButton = (Button) findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                    new Intent(getBaseContext(), TargetActivity.class);
                PendingIntent pendIntent =
                    PendingIntent.getActivity(getBaseContext(),0, intent,0);
                NotificationManager notificationManager =
                    (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(getBaseContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setTicker("This is a new notification")
                        .setWhen(System.currentTimeMillis())
                        .setContentTitle("Notice")
                        .setContentText("You have a new notice")
                        .setContentIntent(pendIntent);

                notificationManager.notify(0, builder.build());
            }
        });
    }
}
