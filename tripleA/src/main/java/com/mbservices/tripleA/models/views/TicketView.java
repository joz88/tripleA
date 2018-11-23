package com.mbservices.tripleA.models.views;

import com.mbservices.tripleA.models.entity.Ticket;

public class TicketView extends Ticket {

	private String nombreAseguradora;

	public String getNombreAseguradora() {
		return nombreAseguradora;
	}

	public void setNombreAseguradora(String nombreAseguradora) {
		this.nombreAseguradora = nombreAseguradora;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
