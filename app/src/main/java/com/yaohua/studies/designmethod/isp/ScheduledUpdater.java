package com.yaohua.studies.designmethod.isp;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledUpdater {
    public interface Updater{
        void update();
    }

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private long initialDelayInSeconds;
    private long periodInSeconds;
    private Updater updater;

    public ScheduledUpdater(Updater updater, long initialDelayInSeconds, long periodInSeconds){
        this.updater = updater;
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
    }

    public void run(){
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updater.update();
            }
        },this.initialDelayInSeconds,this.periodInSeconds, TimeUnit.SECONDS);
    }
}
