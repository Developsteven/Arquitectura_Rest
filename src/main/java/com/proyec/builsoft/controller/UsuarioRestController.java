package com.proyec.builsoft.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyec.builsoft.dao.ICargo;
import com.proyec.builsoft.dao.IRolDao;
import com.proyec.builsoft.entities.Cargo;
import com.proyec.builsoft.entities.Rol;
import com.proyec.builsoft.entities.Usuario;
import com.proyec.builsoft.services.IUsuarioServices;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IUsuarioServices usuarioService;

	@Autowired
	private IRolDao rolDao;
	
	@Autowired
	private ICargo cargoDao;
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/usuario")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}
	
	
	@GetMapping("/usuario/page/{page}")
	public Page<Usuario> index(@PathVariable Integer page) {
		return usuarioService.findAll(PageRequest.of(page, 4));
	}
	
	
	@PostMapping("/usuario")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		
		Usuario usuariotNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			Rol rol = new Rol();

//			if(usuario.getRol().contains("admin")) {
//				rol.setId((long) 2);
//				rol.setNombre("ROLE_ADMIN");
//			}
			
//			rol.setId((long) 2);
//			rol.setNombre("ROLE_ADMIN");
			
			rol.setId((long) 1);
			rol.setNombre("ROLE_USER");
				
			List<Rol> listaRoles = new ArrayList<>() ;
			listaRoles.add(rol);
			
			usuario.setRol(listaRoles);
			usuario.setEstado(true);
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			
			usuariotNew = usuarioService.findByMail(usuario.getMail());	
			if(usuariotNew == null) {				
				if(usuarioService.create(usuario) == null) {
					response.put("response", false);
					response.put("mensaje", "No se pudo crear el usuario intenta nuevamente");	
				}else {
					response.put("response", true);
					response.put("mensaje", "El usuario  fue creado con ??xito");
					
				}
				response.put("usuario", usuariotNew);	
			    return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			}else {
				response.put("response", false);			
				response.put("mensaje", "El usuario con el email: "+usuario.getMail()+" ya existe, intente con otro");
			    return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			}
			
					
//			usuariotNew = usuarioService.create(usuario);
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
//		response.put("mensaje", "El usuario ha sido creado con ??xito!");
//		response.put("usuario", usuariotNew);
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> findByid(@PathVariable Long id) {
		
		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();

		try {

			usuario = usuarioService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuario == null) {
			response.put("mensaje", "El usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
		
		Usuario usuarioActual = usuarioService.findById(id);
		
		Usuario usuarioUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (usuarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el usuario ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			usuarioActual.setNumero(usuario.getNumero());
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setApellido(usuario.getApellido());
			usuarioActual.setMail(usuario.getMail());
			usuarioActual.setEstado(usuario.getEstado());
			usuarioActual.setCargo(usuario.getCargo());
			usuarioActual.setRol(usuario.getRol());
			usuarioActual.setPassword(passwordEncoder.encode(usuario.getPassword()));

			usuarioUpdated = usuarioService.create(usuarioActual);

		}catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario ha sido actualizado con ??xito!");
		response.put("usuario", usuarioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/usuario/rol")
	public List<Rol> listarRoles() {
		return (List<Rol>) rolDao.findAll();
	}
	
	@GetMapping("/usuario/cargo")
	public List<Cargo> findAllCargo() {
		return (List<Cargo>) cargoDao.findAll();
	}
	
}
