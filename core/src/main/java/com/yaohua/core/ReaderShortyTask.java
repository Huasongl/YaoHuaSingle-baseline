package com.yaohua.core;

import android.os.Handler;

public abstract class ReaderShortyTask extends ReaderTask {
    public static final String TASKNAME = "ReaderShortTask";
    protected Handler mActivityHandler;

    public ReaderShortyTask() {
    }

    public String getTaskName() {
        return "ReaderShortTask";
    }

    public void setHandler(Handler handler) {
        this.mActivityHandler = handler;
    }
}
