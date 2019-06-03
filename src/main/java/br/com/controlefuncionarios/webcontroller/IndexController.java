package br.com.controlefuncionarios.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/home")
	public String hello() {
		return "index";
	}

}
