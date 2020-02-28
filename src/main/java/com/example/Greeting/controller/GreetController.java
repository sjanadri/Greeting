package com.example.Greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetController {

	@Autowired
	private RestTemplate rest;
	
	@GetMapping("/greet-message")
	public String greetMessage(String msg) {
		
		String url = "http://MESSAGE-SERVICE/message/messagenow/" + msg;
	
		
		return rest.getForObject(url, String.class);
	}
}
