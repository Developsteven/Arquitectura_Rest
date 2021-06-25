package com.proyec.builsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "programas")
public class Programa implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_programa", nullable = false)
	private Long id;

	@NotEmpty
	@Column(nullable = false)
	private String nombre;

	@NotEmpty
	@Column(nullable = false, unique = true)
	private String siglas;

	public Programa() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
