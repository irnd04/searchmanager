package kr.co.mayfarm.oper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayfarm.system.service.MenuService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/oper/menu")
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuService;

	@GetMapping
	public String menu(Model model) {
		model.addAttribute("menus", menuService.findAll());
		return "oper/menu/menuList";
	}
	
}
