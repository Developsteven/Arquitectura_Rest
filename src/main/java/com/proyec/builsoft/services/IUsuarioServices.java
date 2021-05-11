package com.proyec.builsoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyec.builsoft.entities.Rol;
import com.proyec.builsoft.entities.Usuario;


public interface IUsuarioServices {
	
	public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findById(Long id);
	
	public Usuario create(Usuario usuario);
	
	public List<Rol> findAllRol();
	
}
