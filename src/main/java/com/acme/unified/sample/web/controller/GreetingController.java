package com.acme.unified.sample.web.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.acme.unified.sample.web.dto.GreetingDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class Greeting Controller.
 *
 * @author Jim.DelloStritto
 * @project template-service-java
 * @created Oct 17, 2020
 * @references
 * @credits pivotal.io
 */
@RestController
public class GreetingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/** 
	 * @param "name"
	 * @param name
	 * @return GreetingDTO
	 */
	@GetMapping("/greeting")
	public GreetingDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingDTO(counter.incrementAndGet(), String.format(template, name));
	}
	
}
