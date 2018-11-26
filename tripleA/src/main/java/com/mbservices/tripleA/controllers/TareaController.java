package com.mbservices.tripleA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbservices.tripleA.models.entity.Tarea;
import com.mbservices.tripleA.services.TareaService;
import com.mbservices.tripleA.utils.crud.CrudController;

@Controller
@RequestMapping(value="/tarea")
public class TareaController extends CrudController<Tarea, Long>{

	@Autowired
	private TareaService service;
	
	public TareaService getService() {
		return service;
	}

	@Autowired
	public void setService(TareaService service) {
		super.setService(service);
		this.service = service;
	}
	
	public TareaController() {
		super("", "tarea");
	}

	@Override
	public Tarea getNewModel() {
		return new Tarea();
	}

	@Override
	protected void addAdditionalObjectsToModel(Model model, Tarea paramT) {
		// TODO Auto-generated method stub
		
	}

	
}
