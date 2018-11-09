package com.mbservices.tripleA.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5921112266934518620L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private CarpetaDoc carpetaDoc;
	private String nombre;
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	private String extension;
	@Column(name = "unique_id")
	private String uniqueId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarpetaDoc getCarpetaDoc() {
		return carpetaDoc;
	}

	public void setCarpetaDoc(CarpetaDoc carpetaDoc) {
		this.carpetaDoc = carpetaDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

}
