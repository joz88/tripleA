package com.mbservices.tripleA.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5487196799893889413L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_siniestro")
	private String numeroSiniestro;
	private String asegurado;
	@Column(name = "telefono_contacto")
	private String telefonoContacto;
	private String poliza;
	private String inciso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroSiniestro() {
		return numeroSiniestro;
	}

	public void setNumeroSiniestro(String numeroSiniestro) {
		this.numeroSiniestro = numeroSiniestro;
	}

	public String getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getInciso() {
		return inciso;
	}

	public void setInciso(String inciso) {
		this.inciso = inciso;
	}

}
