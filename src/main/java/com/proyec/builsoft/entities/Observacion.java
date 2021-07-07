package com.proyec.builsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "observaciones")
public class Observacion implements Serializable{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_observacion", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@JsonIgnoreProperties(value={"observaciones","hibernateLazyInitializer", "handler"}, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_novedad_fk")
	private Novedad novedad;
	
	@JsonIgnoreProperties(value={"observaciones","hibernateLazyInitializer", "handler"}, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usuario_fk")
	private Usuario usuario;
	
	@PrePersist
	public void asignarfecha() {
		this.fecha = new Date();
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Novedad getNovedad() {
		return novedad;
	}


	public void setNovedad(Novedad novedad) {
		this.novedad = novedad;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	private static final long serialVersionUID = 1L;
}
