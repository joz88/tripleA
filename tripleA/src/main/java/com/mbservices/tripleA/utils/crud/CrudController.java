package com.mbservices.tripleA.utils.crud;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbservices.tripleA.utils.paginador.PageRender;

public abstract class CrudController<T, K> {

	private String modName;
	private String submodName;
	private CrudService<T, K> service;

	@Autowired
	private Environment env;

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getSubmodName() {
		return submodName;
	}

	public void setSubmodName(String submodName) {
		this.submodName = submodName;
	}

	public CrudController(String modName, String submodName) {
		this.modName = modName;
		this.submodName = submodName;
	}

	public CrudService<T, K> getService() {
		return service;
	}

	public void setService(CrudService<T, K> service) {
		this.service = service;
	}
	
	public abstract T getNewModel();


	/**
	 * listado de registros
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String listar(@RequestParam(defaultValue = "0") Integer page, org.springframework.ui.Model model) {
		Pageable pageReq = PageRequest.of(page, 5);
		Page<T> pageList = this.service.findAll(pageReq);
		PageRender<T> pageRender = new PageRender<>("lista", pageList);

		model.addAttribute("titulo", this.env.getProperty(submodName + ".lista"));
		model.addAttribute("lista", pageList);
		model.addAttribute("page", pageRender);

		return this.submodName + "/listar";
	}
	
	/**
	 * formulario de alta
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/form")
	public String crear(Model model) {
		model.addAttribute("titulo",this.env.getProperty(submodName + ".form"));
		model.addAttribute("modelObject", getNewModel());
		return this.submodName +"/form";
	}
	
	/**
	 * guardado de formulario, alta o edit
	 * @param aseguradora
	 * @param result
	 * @param messagesFlash
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@Valid T modelObject,BindingResult result,RedirectAttributes messagesFlash) {
		if(result.hasErrors()){
			return this.submodName +"/form";
		}
		service.save(modelObject);
		messagesFlash.addFlashAttribute("success","creado con exito");
		return "redirect:/"+this.submodName+"/lista";
	}
	
	/**
	 * obtiene el formulario para editar
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable K id, Model model) {
		T modelObject=service.findById(id);
		if( modelObject ==null){
			return "redirect:/"+this.submodName+"/lista";
		}
		model.addAttribute("titulo",this.env.getProperty(submodName + ".form"));
		model.addAttribute("modelObject", modelObject);
		return this.submodName +"/form";
	}
	
	/**
	 * desactiva Registro
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/eliminar/{id}")
	public String delete(@PathVariable K id){
		service.delete((K) id);
		return "redirect:/"+this.submodName +"/lista";
	}
	
}
