package com.salle.menu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "DEPENDENCIAS" )
public class Dependencia {
	private int id;
	private String codigo;
	private String descripcion;
	private String cargo;
	private boolean estado;
	
	public Dependencia(){
		
	}
	@Column( name = "ID", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column( name ="CODIGO", nullable= false)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Column( name ="DESCRIPCION", nullable= false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column( name ="CARGO", nullable= false)
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Column( name ="ESTADO", nullable= false)
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Dependencia [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", cargo=" + cargo
				+ ", estado=" + estado + "]";
	}
	
}
