package com.ntt_data_bootcamp.microservicios.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {
	
	private Counter counter;

	public TestController(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.hello").description("Contador de invocaciones").register(registry);
	}
	
	@GetMapping("/helloworld")
	public ResponseEntity<String> saludo() {
		counter.increment();
		return ResponseEntity.status(HttpStatus.OK).body("Hola mundo");
	}
	
	
	
}
