package com.plans.configure.kafka.consumer;

import com.plans.configure.MqReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Component;


/**
 * 启动kafka线程
 */
@Component("kafkaConsumer")
public class KafkaConsumer implements MqReceive {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("fromKafka")
    public PollableChannel pollableChannel;

    @Override
    public synchronized void receive() {
        Message<?> received = null;
        received = pollableChannel.receive(10000);
    }

    @Override
    public void run() {
        logger.info("启动kafka消费线程");
        while (true) {
            receive();
        }
    }

}
