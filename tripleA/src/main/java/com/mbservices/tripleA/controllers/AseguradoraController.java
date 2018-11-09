package com.mbservices.tripleA.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbservices.tripleA.models.dao.IAseguradoraDao;
import com.mbservices.tripleA.models.entity.Aseguradora;

@Controller
@RequestMapping(value="/aseguradora")
public class AseguradoraController {
	
	@Autowired
	private IAseguradoraDao dao;
	
	@RequestMapping(value="/listar",method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Aseguradoras");
		model.addAttribute("lista",dao.findAll());
		return "aseguradora/listar";
	}
	
	@RequestMapping(value="/form")
	private String crear(Model model) {
		Aseguradora aseguradora = new Aseguradora();
		model.addAttribute("titulo","FormularioAseguradora");
		model.addAttribute("aseguradora", aseguradora);
		
		return "aseguradora/form";
	}

	@RequestMapping(value="/form",method=RequestMethod.POST)
	private String save(@Valid Aseguradora aseguradora,BindingResult result) {
		if(result.hasErrors()){
			return "aseguradora/form";
		}
		dao.save(aseguradora);
		return "redirect:listar";
	}
}
