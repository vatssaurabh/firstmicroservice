package com.matchscore.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matchscore.microservices.limitservice.beans.LimitConfiguration;

@RestController
public class LimitConfigurationController {
	 @Autowired
    Configuration configuration1;
	 @Autowired
    Configuration configuration2;
   
//    public LimitConfigurationController(Configuration configuration) {
//    	this.configuration1 = configuration;
//    }
	@GetMapping("/limits")
	public LimitConfiguration retreiveLimitConfiguration() {
		return new LimitConfiguration(configuration2.getMinimum(), configuration2.getMaximum());
	}
}
