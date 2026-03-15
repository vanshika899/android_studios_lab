package com.example.notfication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyBtn = findViewById(R.id.notifyBtn);

        notifyBtn.setOnClickListener(v -> showNotification());
    }

    public void showNotification() {

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        String channelId = "my_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "My Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("New Notification")
                        .setContentText("Hello! This is a notification.")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        manager.notify(1, builder.build());

        Toast.makeText(this,
                "Notification inserted: Hello! This is a notification.",
                Toast.LENGTH_LONG).show();
    }
}