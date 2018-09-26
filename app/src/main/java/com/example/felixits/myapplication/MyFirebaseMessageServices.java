package com.example.felixits.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessageServices extends FirebaseMessagingService {
    public MyFirebaseMessageServices() {
    }
    public void onMessageRecived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);

        onSendNotification(remoteMessage.getMessageType());
    }


    private void onSendNotification(String messageBody) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder= new NotificationCompat.Builder(this);

        notificationBuilder.setSmallIcon(R.drawable.akash);
        notificationBuilder.setContentText("Akash Inkar");
        notificationBuilder.setContentText(messageBody);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSound(defaultSoundUri);


        NotificationManager notificationManager= (NotificationManager)getSystemService(Context
        .NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());




        //PendingIntent pendingIntent = PendingIntent.getActivity(this,0,PendingIntent.FLAG_ONE_SHOT);
    }




}
