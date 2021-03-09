package com.salle.menu.dao;
import org.springframework.data.repository.CrudRepository;
import com.salle.menu.entities.Usuario;
public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
}
