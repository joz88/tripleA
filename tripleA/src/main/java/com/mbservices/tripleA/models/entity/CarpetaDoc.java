package com.mbservices.tripleA.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carpetas_doc")
public class CarpetaDoc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1807074379802669188L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_carpeta")
	private String nombreCarpeta;

	@OneToOne(mappedBy = "carpetaDoc", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Tarea tarea;
	
	@OneToMany(mappedBy="carpetaDoc",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="documento_id")
	private List<Documento> documentos;
	
	
	public CarpetaDoc() {
		this.documentos= new ArrayList<Documento>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCarpeta() {
		return nombreCarpeta;
	}

	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}

}
