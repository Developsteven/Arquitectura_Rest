package com.salle.menu.services;

import java.util.List;

import com.salle.menu.entities.Usuario;

public interface IUsuarioServices {
	public List<Usuario> findAll();
	public Usuario create(Usuario usuario);
	
}
