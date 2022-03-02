package com.gwsh.controller;

import com.gwsh.config.SwaggerTagsValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * 消息生产者
 *
 * @author gwsh
 * @date 2022-02-24 10:25:23
 */
@Api(tags = SwaggerTagsValue.QUEUE_CONTROLLER_TAG)
@RestController
public class QueueController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue                queue;

    /**
     * 消息生产者
     */
    @ApiOperation(value = "生产消息", notes = "生产用户信息。")
    @ApiImplicitParam(
            name = "msg", value = "消息内容", readOnly = true, dataType = "String", paramType = "path"
    )
    @ApiResponse(
            responseCode = "1", description = "成功", ref = "ref")
    @ApiResponse(
            responseCode = "0", description = "失败", ref = "ref")
    @GetMapping("/send/{msg}")
    public void send(@PathVariable String msg) {
        this.jmsMessagingTemplate.convertAndSend(queue, msg);
    }
}
