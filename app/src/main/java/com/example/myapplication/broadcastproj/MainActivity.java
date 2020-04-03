package com.example.myapplication.broadcastproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final IntentFilter BROADCAST_ACTION = textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn= findViewById(R.id.btn);
    }

    protected void onStrat(){
        super.onStart();
        localListener = new Reveiver();
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION);
        this.registerReceiver(localListener, intentFilter);

    }

    protected void onStop(){

        super.onStop();
        this.unregisterReceiver(localListener);
    }

    protected void onClick(View view){
        if(view.getId()== R.Id.btnStartBroadcast){
            BackgroundServices.startAction(this.getApplicationContext());
        }
    }

        public class Reciver extends BroadcastReceiver{



            @Override
            public void onReceive(Context context, Intent intent) {

                String currentText = txtViewMsg.getText().toStrig();
                String message = intent.getStringExtra("value");
                currentText +="\nReceive" + message;
                txtViewMsg.setText(currentText);
            }
        }

}
