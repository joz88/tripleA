package com.mbservices.tripleA.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mbservices.tripleA.models.entity.Aseguradora;
import com.mbservices.tripleA.services.AseguradoraService;

@RestController
@RequestMapping(value="/api/aseguradora")
public class AseguradoraRest {
	
	@Autowired
	private AseguradoraService service;
	
	@GetMapping(value="/lista")
	public @ResponseBody List<Aseguradora> listar() {
		return  service.findAll();
	}

}
