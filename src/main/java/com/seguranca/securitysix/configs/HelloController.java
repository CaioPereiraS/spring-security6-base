package com.seguranca.securitysix.configs;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}

	public void token(Authentication authentication){

	}
}