package com.mbservices.tripleA.utils.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(defaultValue = "0") Integer page, org.springframework.ui.Model model) {
		Pageable pageReq = PageRequest.of(page, 5);
		Page<T> pageList = this.service.findAll(pageReq);
		PageRender<T> pageRender = new PageRender<>("listar", pageList);

		model.addAttribute("titulo", this.env.getProperty(submodName + ".lista"));
		model.addAttribute("lista", pageList);
		model.addAttribute("page", pageRender);

		return this.submodName + "/listar";
	}
}
