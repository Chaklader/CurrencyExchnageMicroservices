package com.chaklader.microservices.LimitService.controller;

import com.chaklader.microservices.LimitService.bean.Limits;
import com.chaklader.microservices.LimitService.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chaklader on Nov, 2021
 */
@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimum(),
            configuration.getMaximum());
//		return new Limits(1,1000);
    }
}
