package com.mbservices.tripleA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbservices.tripleA.models.entity.Aseguradora;
import com.mbservices.tripleA.services.AseguradoraService;
import com.mbservices.tripleA.utils.crud.CrudController;

@Controller
@RequestMapping(value="/aseguradora")
public class AseguradoraController extends CrudController<Aseguradora, Long> {
	
	public AseguradoraController() {
		super("", "aseguradora");
	}

	@Autowired
	private AseguradoraService service;
	
	public AseguradoraService getService() {
		return service;
	}

	@Autowired
	public void setService(AseguradoraService service) {
		super.setService(service);
		this.service = service;
	}
	
	@Override
	public Aseguradora getNewModel() {
		return new Aseguradora();
	}

	@Override
	protected void addAdditionalObjectsToModel(Model model, Aseguradora paramT) {
		// TODO Auto-generated method stub
		
	}
	
		
//	@RequestMapping(value="/listar",method=RequestMethod.GET)
//	public String listar(@RequestParam(defaultValue="0") Integer page,Model model) {
//		
//		Pageable pageReq = PageRequest.of(page, 5);
//		Page<Aseguradora> aseguradoras = service.findAll(pageReq);
//		
//		PageRender<Aseguradora> pageRender = new PageRender<>("listar",aseguradoras);
//		model.addAttribute("titulo", "Listado de Aseguradoras");
//		model.addAttribute("lista",aseguradoras);
//		model.addAttribute("page",pageRender);
//		return "aseguradora/listar";
//	}
	
	

//	@RequestMapping(value="/form")
//	public String crear(Model model) {
//		Aseguradora aseguradora = new Aseguradora();
//		model.addAttribute("titulo","FormularioAseguradora");
//		model.addAttribute("aseguradora", aseguradora);
//		
//		return "aseguradora/form";
//	}

//	@RequestMapping(value="/save",method=RequestMethod.POST)
//	public String save(@Valid Aseguradora aseguradora,BindingResult result,RedirectAttributes messagesFlash) {
//		if(result.hasErrors()){
//			return "aseguradora/form";
//		}
//		service.save(aseguradora);
//		messagesFlash.addFlashAttribute("success","creado con exito");
//		return "redirect:/aseguradora/listar";
//	}
	
//	@RequestMapping(value="/edit/{id}")
//	public String edit(@PathVariable Long id, Model model) {
//		Aseguradora aseguradora=null;
//		if(id>0){
//			aseguradora=service.findById(id);
//		}else{
//			return "redirect:/aseguradora/listar";
//		}
//		model.addAttribute("titulo","FormularioAseguradora");
//		model.addAttribute("aseguradora", aseguradora);
//		return "aseguradora/form";
//	}
	
//	@RequestMapping(value="/eliminar/{id}")
//	public String delete(@PathVariable Long id){
//		if(id>0){
//			service.delete(id);
//		}
//		return "redirect:/aseguradora/listar";
//	}

	
}
