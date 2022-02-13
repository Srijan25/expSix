package com.srijan.expSix;

import android.app.Notification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.srijan.expSix.App.CHANNEL_2_ID;
import static com.srijan.expSix.App.CHANNEL_1_ID;


public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
    }

    public void sendOnChannel1(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Intent resultIntent = new Intent(this,MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 1 ,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Intent resultIntent = new Intent(this,MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 1 ,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .build();

        notificationManager.notify(2, notification);
    }
}