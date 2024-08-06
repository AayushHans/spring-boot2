package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
					return "Error: Division by 0";
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

	@GetMapping("/fibonacci")
	public String fibonacci(@RequestParam(value = "z", defaultValue = "10") int z) {
		if (z < 0) {
			return "[]";
		}
		List<Integer> fibonacciSeries = new ArrayList<>();
		int a = 0, b = 1;
		if (z >= 0) {
			fibonacciSeries.add(a);
		}
		while (b <= z) {
			fibonacciSeries.add(b);
			int next = a + b;
			a = b;
			b = next;
		}
		return fibonacciSeries.toString();
	}
}
