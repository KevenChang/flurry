package com.plans.configure;

/**
 * 收消息
 */
public interface MqReceive extends Runnable {

    void receive();

}
