package kr.co.mayfarm.dict.indexdict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dict/indexdict/userdict")
public class IndexDictController {

	@GetMapping(value = {"", "/list"})
	public String list() {
		return "dict/indexdict/indexDictList";
	}
	
}