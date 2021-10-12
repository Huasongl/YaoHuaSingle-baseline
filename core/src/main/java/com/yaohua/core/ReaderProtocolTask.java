package com.yaohua.core;


import android.content.Context;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ReaderProtocolTask extends ReaderNetTask implements Callback {
    private static final long serialVersionUID = 1L;
    public static final String TASKNAME = "NetTask";
    protected String mRequest = null;
    protected String mContentType;
    protected transient ReaderNetTaskListener mListener;
    private transient int taskIndex = 0;
    protected transient Context mContext;
    private long mTid;
    public String mApn;
    public static final int[] lockObj = new int[0];
    private long mRunTime;
    private Response mResponse;

    public ReaderProtocolTask() {
        this.init((ReaderNetTaskListener)null);
    }

    public ReaderProtocolTask(ReaderNetTaskListener listener) {
        this.init(listener);
    }

    private void init(ReaderNetTaskListener listener) {
        this.mListener = listener;
        this.mContext = BaseApplication.getInstance().getApplicationContext();
    }

    public HashMap<String, String> getParamsMap() {
        return null;
    }

    public Context getContext() {
        if (this.mContext == null) {
            this.mContext = BaseApplication.getInstance().getApplicationContext();
        }

        return this.mContext;
    }

    public void registerNetTaskListener(ReaderNetTaskListener listener) {
        this.mListener = listener;
    }

    public ReaderNetTaskListener getRegisterNetTaskListener() {
        return this.mListener;
    }

    public void unregisterNetTaskListener() {
        this.mListener = null;
    }

    public Response getResponse() {
        return this.mResponse;
    }

    public String getRequestMethod() {
        return "GET";
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

    }


}
