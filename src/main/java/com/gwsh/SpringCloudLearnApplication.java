package com.gwsh;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class SpringCloudLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLearnApplication.class, args);
    }

    /**
     * 创建一个消息队列
     *
     * @return
     */
    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("active.queue");
    }
}
