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
@Table(name = "novedades")
public class Novedad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_novedad", nullable = false)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descripcion;
	
	@JsonIgnoreProperties(value={"novedades","hibernateLazyInitializer", "handler"}, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_aprendiz_fk")
	private Aprendiz aprendiz;
	
	@JsonIgnoreProperties(value={"novedades","hibernateLazyInitializer", "handler"}, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_novedad_fk")
	private TipoNovedad tipoNovedad;
	
	@PrePersist
	public void declararFecha() {
		this.fecha = new Date();
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Aprendiz getAprendiz() {
		return aprendiz;
	}


	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}


	public TipoNovedad getTipoNovedad() {
		return tipoNovedad;
	}


	public void setTipoNovedad(TipoNovedad tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}


	private static final long serialVersionUID = 1L;

}
