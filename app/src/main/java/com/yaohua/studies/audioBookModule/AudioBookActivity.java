package com.yaohua.studies.audioBookModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.yaohua.studies.R;
import com.yaohua.studies.databinding.ActivityAudioBookBinding;
import com.yaohua.studies.ui.view.IAlertDialog;
import com.yaohua.studies.ui.view.ReaderAlertDialog;
import com.yaohua.studies.utils.WeakReferenceHandler;

public class AudioBookActivity extends AppCompatActivity implements Handler.Callback {

    private ActivityAudioBookBinding audioBookBinding;
    public static final String TAG = "AudioBookActivity";
    protected WeakReferenceHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setContentView(audioBookBinding.getRoot());
        Log.i(TAG,"onCreate");

        mHandler = new WeakReferenceHandler(this);
    }

    private void initView() {
        audioBookBinding = ActivityAudioBookBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onResume() {
        super.onResume();
        audioBookBinding.llEnterRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReaderAlertDialog alertDialog = (ReaderAlertDialog) new ReaderAlertDialog.Builder(v.getContext())
                        .setTitle("关闭自动续费")
                        .setMessage("关闭自动续费",true)
                        .setPositiveButton("确认关闭",(dialog, which) -> {
                })
                        .setNegativeButton("在想想",(dialog, which) -> {
                }).create();
                alertDialog.show();
            }
        });
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        return false;
    }
}