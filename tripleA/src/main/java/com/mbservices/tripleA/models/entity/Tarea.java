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
@Table(name = "Tareas")
public class Tarea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1233927601506521769L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer secuencia;
	@Column(name = "nombre_tarea")
	private String nombreTarea;
	private String estatus;
	private String descripcion;
	private String publicar;

	@OneToOne(fetch = FetchType.LAZY)
	private CarpetaDoc carpetaDoc;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="idTarea")
	private List<Nota> notas;
	
	
	public Tarea() {
		this.notas= new ArrayList<Nota>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CarpetaDoc getCarpetaDoc() {
		return carpetaDoc;
	}

	public void setCarpetaDoc(CarpetaDoc carpetaDoc) {
		this.carpetaDoc = carpetaDoc;
	}

	public String getPublicar() {
		return publicar;
	}

	public void setPublicar(String publicar) {
		this.publicar = publicar;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void addNota(Nota nota){
		notas.add(nota);
	}

	
}
