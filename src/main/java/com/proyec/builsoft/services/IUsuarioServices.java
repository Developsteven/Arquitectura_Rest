package com.proyec.builsoft.services;

import java.util.List;
import java.util.Optional;

import com.proyec.builsoft.entities.Usuario;

public interface IUsuarioServices {
	public List<Usuario> findAll();
	Optional<Usuario> findById(long id);
	public Usuario create(Usuario usuario);
	
}
