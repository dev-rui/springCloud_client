package com.example.eurekaclient.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 */
@RefreshScope
@RestController
public class UserController {
   private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    DiscoveryClient discoveryClient;
    @Value("${info.from}")
    private String from;


    @GetMapping("/dc")
    public String dc(HttpServletRequest request) throws InterruptedException {
        //Thread.sleep(2000L);
        String services = "Services: " + discoveryClient.getServices();
        logger.info("===请求client， TraceId={}, SpanId={}===",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        return services;
    }

    @GetMapping("/from")
    public String from() {
        System.out.println(this.from);
        return from;
    }



}
