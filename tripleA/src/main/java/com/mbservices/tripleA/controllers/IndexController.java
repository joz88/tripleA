package com.mbservices.tripleA.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	private String index(Model model) {
		model.addAttribute("mensaje", "Hola este es mi mensaje!!");
		return "index";
	}
}
