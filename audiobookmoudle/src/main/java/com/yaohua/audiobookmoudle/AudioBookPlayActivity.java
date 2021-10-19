package com.yaohua.audiobookmoudle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AudioBookPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private AudioBookPlayPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_book_play);
        button = findViewById(R.id.audio_book_play);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==button){
            if (!isError()) {
                mPresenter.nextChapter();
            }
        }
    }

    private boolean isError() {
        if (this.isFinishing() || mPresenter == null) {
            return true;
        }
        return false;
    }
}