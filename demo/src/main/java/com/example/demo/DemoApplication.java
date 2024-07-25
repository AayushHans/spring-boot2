package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/calculator")
	public String calculator(@RequestParam(value = "a", defaultValue = "0") int a,
							 @RequestParam(value = "b", defaultValue = "0") int b,
							 @RequestParam(value = "o", defaultValue = "+") String operation) {
		int result;
		switch (operation) {
			case "-":
				result = a - b;
				break;
			case "*":
				result = a * b;
				break;
			case "/":
				if (b == 0) {
					return "Error: Division by zero";
				}
				result = a / b;
				break;
			case "+":
			default:
				result = a + b;
				break;
		}
		return String.format("%d", result);
	}
}
