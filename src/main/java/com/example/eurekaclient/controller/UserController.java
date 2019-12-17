package com.example.eurekaclient.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RefreshScope
@RestController
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Value("${info.from}")
    private String from;


    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        //Thread.sleep(2000L);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/from")
    public String from() {
        System.out.println(this.from);
        return from;
    }



}
