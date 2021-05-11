package com.proyec.builsoft.implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyec.builsoft.dao.IUsuarioDao;
import com.proyec.builsoft.entities.Usuario;
import com.proyec.builsoft.services.IUsuarioServices;

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
	
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(long id) {
		return clienteDao.findById(id);
	}
	
}
