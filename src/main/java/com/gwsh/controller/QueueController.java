package com.gwsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * 消息生产者
 *
 * @author gwsh
 * @date 2022-02-24 10:25:23
 */
@RestController
public class QueueController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue                queue;

    /**
     * 消息生产者
     */
    @RequestMapping("/send/{msg}")
    public void send(@PathVariable String msg) {
        this.jmsMessagingTemplate.convertAndSend(queue, msg);
    }
}
