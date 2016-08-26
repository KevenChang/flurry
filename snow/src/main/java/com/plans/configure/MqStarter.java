package com.plans.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 收消息启动线程
 */
@Component
@ConfigurationProperties(value = "mq")
public class MqStarter {
    @Autowired
    @Qualifier("kafkaConsumer")
    MqReceive mqReceive;

    private boolean enabled;

    @PostConstruct
    public void init() {
        //利用kafka
        if (enabled) {
            Thread t = new Thread(mqReceive);
            t.start();
        }
    }

}
