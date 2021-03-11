package com.salle.menu.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROL")
public class Rol implements Serializable {

	private static final long serialVersionUID = 5603958125489596103L;
	private int id;
	private String descripcion;
	private String siglaRol;
	private boolean estado;

	public Rol() {

	}

	/**
	 * @return the idRol
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL_PK", nullable = false)
	public int getId() {
		return id;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setId(int idRol) {
		this.id = idRol;
	}

	/**
	 * @return the descripcion
	 */
	@Column(name = "DESCRIPCION", nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the siglaRol
	 */
	@Column(name = "SIGLA_ROL")
	public String getSiglaRol() {
		return siglaRol;
	}

	/*
	 * @param siglaRol the siglaRol to set
	 */
	public void setSiglaRol(String siglaRol) {
		this.siglaRol = siglaRol;
	}

	/**
	 * @return the estado
	 */
	@Column(name = "ESTADO", nullable = false)
	public boolean getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rol [id=" + id + ", descripcion=" + descripcion + ", siglaRol=" + siglaRol + ", estado=" + estado + "]";
	}

}
