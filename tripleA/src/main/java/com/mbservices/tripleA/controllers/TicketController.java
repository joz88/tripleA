package com.mbservices.tripleA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbservices.tripleA.models.entity.Aseguradora;
import com.mbservices.tripleA.models.entity.Tarea;
import com.mbservices.tripleA.models.entity.Ticket;
import com.mbservices.tripleA.services.AseguradoraService;
import com.mbservices.tripleA.services.TicketService;
import com.mbservices.tripleA.utils.crud.CrudController;

@Controller
@RequestMapping(value="/ticket")
public class TicketController extends CrudController<Ticket, Long> {

	public TicketController() {
		super("", "ticket");
	}

	@Autowired
	private TicketService service;
	
	@Autowired
	private AseguradoraService aseguradoraService;
	
	public TicketService getService() {
		return service;
	}

	@Autowired
	public void setService(TicketService service) {
		super.setService(service);
		this.service = service;
	}

	@Override
	public Ticket getNewModel() {
		return new Ticket();
	}
	
	@GetMapping(value="/acAseguradora/{term}",produces="application/json")
	public @ResponseBody List<Aseguradora> asAseguradora(@PathVariable String term){
		List<Aseguradora> lista = aseguradoraService.findByNombre(term);
		return lista;
	}

	@Override
	protected void addAdditionalObjectsToModel(Model model, Ticket object) {
		model.addAttribute("nombreAseguradora", this.aseguradoraService.getNombreByid(object.getId()));
		model.addAttribute("titulo1","Datos de Generales");
		model.addAttribute("titulo2","Datos de Seguimiento");
		model.addAttribute("tareaV", new Tarea());
	}
}
