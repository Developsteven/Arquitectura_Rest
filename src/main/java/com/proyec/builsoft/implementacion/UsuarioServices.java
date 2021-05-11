package com.proyec.builsoft.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyec.builsoft.dao.IRolDao;
import com.proyec.builsoft.dao.IUsuarioDao;
import com.proyec.builsoft.entities.Rol;
import com.proyec.builsoft.entities.Usuario;
import com.proyec.builsoft.services.IUsuarioServices;

@Service
public class UsuarioServices implements IUsuarioServices{
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;
	

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return usuarioDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Usuario create(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAllRol() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>)usuarioDao.findAll();
	}

}
