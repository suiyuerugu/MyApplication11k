package com.example.wxj.myapplication11k;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvText;
    private Button btnHandler;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = (TextView) findViewById(R.id.tv_text);
        btnHandler = (Button) findViewById(R.id.btn_handler);
        handler = new Handler() {
            int i=0;
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                tvText.setText(String.valueOf(++i));
            }
        };
        btnHandler.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            handler.sendEmptyMessage(1);
                            SystemClock.sleep(1000);
                        }
                    }
                }).start();
            }
        });
    }
}
