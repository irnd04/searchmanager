package kr.co.mayfarm.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import kr.co.mayfarm.login.domain.User;
import kr.co.mayfarm.login.service.UserService;
import kr.co.mayfarm.login.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
	
	private final String LOGIN_VIEW = "index";
	private final UserService userService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	@GetMapping("/zz")
	public String login(@Valid User user, BindingResult result, Model model) throws Exception {
		
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		System.out.println("123po[812390piu12 k4ljxzcl;fgjzx;lkcvj ioasduf");
		
		System.out.println(result.getErrorCount());
		if (result.hasErrors()) throw new Exception();
		
		model.addAttribute("myname", "jglee");
		
		log.info(model.toString());
		
		return LOGIN_VIEW;
	} 
	
	@GetMapping("/save")
	public String save() throws Exception {
		val user =  userService.createUser("jglee", "0000");
		log.debug(user.toString());
		return "redirect:/";
	}
}
