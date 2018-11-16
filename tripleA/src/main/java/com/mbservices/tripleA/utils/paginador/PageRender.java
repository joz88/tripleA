package com.mbservices.tripleA.utils.paginador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;
	
	private Integer totalPaginas;
	private Integer numElementosPagina;
	private Integer paginaActual;
	
	private List<PageItem> paginas;
	
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		numElementosPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;
		
		
		Integer desde,hasta,paginasX;
		paginasX=5;
		if(totalPaginas <= paginasX){
			desde = 1;
			hasta = totalPaginas;
		}else {
			if(paginaActual <= paginasX/2){
				desde = 1;
				hasta = paginasX;
			}else if(paginaActual >= totalPaginas- paginasX/2) {
				desde = totalPaginas - paginasX +1;
				hasta = numElementosPagina;
			}else {
				desde = paginasX - paginaActual ;
				hasta = paginasX;
			}
				
		}
		
		for(int i=0; i < hasta; i++){
			paginas.add(new PageItem(desde +i, paginaActual == desde+i));
		}
	}
	
	
	public String getUrl() {
		return url;
	}
	public Integer getTotalPaginas() {
		return totalPaginas;
	}
	public Integer getPaginaActual() {
		return paginaActual;
	}
	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	public Boolean isFirst() {
		return page.isFirst();
	}
	public Boolean isLast() {
		return page.isLast();
	}
	
	public Boolean isHasNext() {
		return page.hasNext();
	}
	
	public Boolean isHasPrevious(){
		return page.hasPrevious();
	}
}
