package com.salle.menu.implementacion;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salle.menu.dao.IUsuarioDao;
import com.salle.menu.entities.Usuario;

@Service
public class ClienteServices implements IUsuarioServices{
	@Autowired
	private IUsuarioDao clienteDao;
	
	@Transactional(readOnly = true)
	public List<Usuario>findAll(){
		return (List<Usuario>) clienteDao.findAll();
	}
	@Transactional(readOnly = false)
	public Usuario create(Usuario usuario) {
		System.out.println(usuario.getDependencia());
		return clienteDao.save(usuario);
	}
}
