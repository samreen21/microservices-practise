package com.microservice.limitservice.controller;

import com.microservice.limitservice.bean.Limits;
import com.microservice.limitservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public Limits retreiveLimit(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }

}
