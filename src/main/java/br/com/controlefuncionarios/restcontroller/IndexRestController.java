package br.com.controlefuncionarios.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {
	
	@GetMapping("/home")
	public String hello() {
		return "Hello buddy!";
	}

}
