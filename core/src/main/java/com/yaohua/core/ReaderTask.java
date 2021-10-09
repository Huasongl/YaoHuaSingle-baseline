package com.yaohua.core;

import android.util.Log;

import java.io.Serializable;

public abstract class ReaderTask implements Runnable, Serializable, Comparable<ReaderTask> {
    private static final long serialVersionUID = 1L;
    protected boolean isFailedTask = false;
    public static final int NO_RETRY = 0;
    public static final int AUTO_RETRY = 1;
    private int mTaskFailedType = 0;
    protected String mTaskKey = null;
    protected static int MAX_AUTO_FAILED_TIME = 2;
    protected static final int DEFAULT_AUTO_FAILED_TIME = 1;
    protected static final int MIN_AUTO_FAILED_TIME = 1;
    private static int mValueAutoFailedTime = 1;
    private int mFailedAutoRetryTime = 0;
    private long mDelayTime = 0L;
    private transient Thread mCurrentThread;
    public ReaderTask(){
    }

    public static void stopRetry() {
        MAX_AUTO_FAILED_TIME = 0;
    }

    public static void resumeRetry() {
        MAX_AUTO_FAILED_TIME = 2;
    }

    public void setDelayTime(long t) {
        this.mDelayTime = t;
    }

    public long getDelayTime() {
        return this.mDelayTime;
    }

    public void addFailedAutoRetryTimeTime() {
        ++this.mFailedAutoRetryTime;
        Log.d("FailedAutoRetryTime", "auto try:" + this.mFailedAutoRetryTime);
    }

    public void resetFailedAutoRetryTimeTime() {
        this.mFailedAutoRetryTime = 0;
    }

    public final boolean isReachMaxAutoFailedTime() {
        return this.mFailedAutoRetryTime >= mValueAutoFailedTime;
    }

    public int getFailedType() {
        return this.mTaskFailedType;
    }

    public void setFailedType(int type) {
        this.setFailedType(type, MAX_AUTO_FAILED_TIME);
    }

    public void setFailedType(int type, int autoTryTimes) {
        if (type == 0 || type == 1) {
            this.mTaskFailedType = type;
            if (this.mTaskFailedType == 1) {
                if (autoTryTimes > MAX_AUTO_FAILED_TIME) {
                    mValueAutoFailedTime = MAX_AUTO_FAILED_TIME;
                } else if (autoTryTimes < 1) {
                    mValueAutoFailedTime = 1;
                } else {
                    mValueAutoFailedTime = autoTryTimes;
                }
            }
        }
    }

    public abstract String getTaskName();

    public void setCurrentThread(Thread thread) {
        this.mCurrentThread = thread;
    }

    public Thread getCurrentThread() {
        return this.mCurrentThread;
    }

    @Override
    public int compareTo(ReaderTask o) {
        return 0;
    }

    @Override
    public void run() {
        Log.i("Task", this.getClass().getName());
        this.setCurrentThread(Thread.currentThread());
    }

    protected String generateTaskKey() {
        return "";
    }

    public String getTaskKey() {
        if (this.mTaskKey == null || this.mTaskKey.length() == 0) {
            this.mTaskKey = this.getClass().getSimpleName() + this.generateTaskKey();
        }

        return this.mTaskKey;
    }

    public boolean isSameOfTask(ReaderTask task) {
        return this.mTaskKey != null && this.getTaskKey().equals(task.getTaskKey());
    }

    public boolean isSameKindOfTask(ReaderTask task) {
        return this.mTaskKey != null && this.getTaskKey().equals(task.getTaskKey());
    }
}
