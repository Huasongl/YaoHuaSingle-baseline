package com.yaohua.studies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yaohua.routemoudle.RoutePath;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button criminalIntent = findViewById(R.id.criminalIntent);
        criminalIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(RoutePath.CRIMINAL_ACTIVITY)
                        .navigation(getBaseContext());
            }
        });

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
        String date = dateFormat.format(new Date());
        Button button = findViewById(R.id.date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(date);
            }
        });
    }


}