package com.mbservices.tripleA.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prueba")
public class PruebaController {

	
	@RequestMapping("/prueba")
	public String prueba(){
		
		return "prueba/prueba";
	}
}
