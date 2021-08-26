package com.yaohua.studies.audioBookModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yaohua.studies.R;
import com.yaohua.studies.utils.WeakReferenceHandler;

public class AudioBookActivity extends AppCompatActivity implements Handler.Callback {

    public static final String TAG = "AudioBookActivity";
    protected WeakReferenceHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_book);
        Log.i(TAG,"onCreate");

        mHandler = new WeakReferenceHandler(this);
        initView();
    }

    private void initView() {
//        initBookInfoView();
//        initPlayControllerView();
//        initShareView();
//        initErrorView();
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        return false;
    }
}