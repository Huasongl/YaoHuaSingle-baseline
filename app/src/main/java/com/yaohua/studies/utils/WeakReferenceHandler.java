package com.yaohua.studies.utils;

import android.os.Looper;
import android.os.Message;
import android.os.Handler;
import android.os.Handler.Callback;
import java.lang.ref.WeakReference;


public class WeakReferenceHandler extends Handler {
    private WeakReference<Callback> mWeakReferCallBack;

    public WeakReferenceHandler(Callback cb){
        this.mWeakReferCallBack = new WeakReference(cb);
    }

    public WeakReferenceHandler(Looper looper, Callback cb){
        super(looper);
        this.mWeakReferCallBack = new WeakReference(cb);
    }

    public void handleMessage(Message msg){
        Callback cb = (Callback)this.mWeakReferCallBack.get();
        if(null != cb){
            cb.handleMessage(msg);
        }
    }
}
