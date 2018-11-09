package com.mbservices.tripleA.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String crear(Model model) {
		Aseguradora aseguradora = new Aseguradora();
		model.addAttribute("titulo","FormularioAseguradora");
		model.addAttribute("aseguradora", aseguradora);
		
		return "aseguradora/form";
	}

	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String save(@Valid Aseguradora aseguradora,BindingResult result) {
		if(result.hasErrors()){
			return "aseguradora/form";
		}
		dao.save(aseguradora);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Aseguradora aseguradora=null;
		if(id>0){
			aseguradora=dao.findById(id);
		}else{
			return "redirect:listar";
		}
		model.addAttribute("titulo","FormularioAseguradora");
		model.addAttribute("aseguradora", aseguradora);
		return "aseguradora/form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String delete(@PathVariable Long id){
		if(id>0){
			dao.delete(id);
		}
		return "redirect:listar";
	}
}
