package com.peiwan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resources;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 消息生产者
 * @program: springbootdemo
 * @author: 张家明
 * @create: 2019-01-18 13:57
 **/

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void send(String test){
        jmsMessagingTemplate.convertAndSend("itcast",test);
    }

    @RequestMapping("/sendmap")
    public void dendMap(){
        Map map = new HashMap();
        map.put("mobile","15937345245");
        map.put("template_code","PW工作室");
        map.put("sign_name","SMS_155861806");
        map.put("param","{\"name\":\"Tom\", \"code\":\"123456\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);
    }


}
