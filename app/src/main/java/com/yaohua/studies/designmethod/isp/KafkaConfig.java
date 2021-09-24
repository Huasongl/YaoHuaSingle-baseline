package com.yaohua.studies.designmethod.isp;

public class KafkaConfig implements ScheduledUpdater.Updater{
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;

    public KafkaConfig(ConfigSource configSource){
        this.configSource = configSource;
    }

    public String getAddress(){
        return this.address;
    }

    public void update(){

    }
}
