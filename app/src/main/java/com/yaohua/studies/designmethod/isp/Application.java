package com.yaohua.studies.designmethod.isp;

public class Application {
    static ConfigSource configSource = new ZookepperConfigSource();
    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final MysqlConfig mySqlConfig = new MysqlConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);

    public Application() {
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig,300,300);
        redisConfigUpdater.run();

        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig,60, 60);
        kafkaConfigUpdater.run();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1",2389);
        simpleHttpServer.addViewers("/config",redisConfig);
        simpleHttpServer.addViewers("/config",mySqlConfig);
    }
}
