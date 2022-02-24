package com.gwsh.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * MQ 消息监听器
 *
 * @author gwsh
 * @date 2022-02-24 10:29:20
 */
@RestController
public class CustomerController {

    /**
     * 监听和读取消息
     *
     * @param message
     */
    @JmsListener(destination = "active.queue")
    public void readActiveQueue(String message) {
        System.out.println("接受到：" + message);
    }
}
