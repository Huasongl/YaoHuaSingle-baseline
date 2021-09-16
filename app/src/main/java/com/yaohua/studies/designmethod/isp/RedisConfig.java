package com.yaohua.studies.designmethod.isp;

import java.util.Map;

public class RedisConfig implements ScheduledUpdater.Updater, SimpleHttpServer.Viewer {
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;

    public RedisConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    public String getAddress(){
        return this.address;
    }

    public void update(){

    }

    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
