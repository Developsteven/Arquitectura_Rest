package com.salle.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salle.menu.entities.Usuario;
import com.salle.menu.services.IUsuarioServices;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioServices usuarioService;

	@GetMapping("/usuario")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}

	@PostMapping("/usuario")
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.create(usuario);
	}
}
