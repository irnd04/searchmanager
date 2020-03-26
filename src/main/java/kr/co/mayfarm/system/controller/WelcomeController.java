package kr.co.mayfarm.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WelcomeController {

	@GetMapping("/")
	public String welcome(Model model) {
		log.debug("-");
		return "index";
	}
	
	@GetMapping("/sample")
	public String sample(Model model) {
		return "sample";
	}
	
}
