package com.proyec.builsoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyec.builsoft.entities.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	
	
//	@Query("select c from Usuario c where c.mail like %?1")
	public Usuario findByMail(String mail);
}
