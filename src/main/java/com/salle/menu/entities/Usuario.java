package com.salle.menu.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1265660971450473499L;
	private int id;
	private String documento;
	private String userName;
	private String nombre;
	private String mail;
	private boolean estado;
	private Rol rol;
	private Dependencia dependencia;

	public Usuario() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO_PK", nullable = false)
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the documento
	 */
	@Column(name = "DOCUMENTO", nullable = false)
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the userName
	 */
	@Column(name = "USERNAME", nullable = false, unique = true)
	public String getUserName() {
		return userName;
	}

	/*
	 * @param userName the userName to set
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nombre
	 */
	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the mail
	 */
	@Column(name = "EMAIL", nullable = false)
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the estado
	 */
	@Column(name = "ESTADO", nullable = false)
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @return the rol
	 */
	@OneToOne
	@JoinColumn(name = "ID_ROL_FK", nullable = false)
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * @return the dependencia
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_DEPENDENCIA_FK", nullable = false)
	public Dependencia getDependencia() {
		return dependencia;
	}

	/**
	 * @param dependencia the dependencia to set
	 */
	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsuarioBO [id=" + id + ", documento=" + documento + ", userName=" + userName + ", nombre=" + nombre
				+ ", mail=" + mail + ", estado=" + estado + ", rol=" + rol + ", dependencia=" + dependencia + "]";
	}
}
