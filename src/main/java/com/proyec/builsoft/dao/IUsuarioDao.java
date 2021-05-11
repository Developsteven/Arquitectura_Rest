package com.proyec.builsoft.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyec.builsoft.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
}
