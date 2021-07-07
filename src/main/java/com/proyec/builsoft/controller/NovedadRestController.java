package com.proyec.builsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyec.builsoft.entities.Novedad;
import com.proyec.builsoft.entities.Observacion;
import com.proyec.builsoft.entities.TipoNovedad;
import com.proyec.builsoft.services.IAprendizServices;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class NovedadRestController {

	
	@Autowired
	private IAprendizServices aprendizServices;
	
	@GetMapping("/novedades/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Novedad verNovedad(@PathVariable Long id) {
		return aprendizServices.findByIdNovedad(id);
	}
	
	
	@PostMapping("/novedades")
	@ResponseStatus( HttpStatus.CREATED)
	public Novedad crearNovedad(@RequestBody Novedad novedad) {
		return aprendizServices.createNovedad(novedad);
	}
	
	@GetMapping("/novedades/tipoNovedad")
	@ResponseStatus(HttpStatus.OK)
	public List<TipoNovedad> listarTipoNovedad() {
		return aprendizServices.findAllTipoNovedad();
	}
	
	@GetMapping("/observacion")
	@ResponseStatus(HttpStatus.OK)
	public List<Observacion> listarObservacion() {
		return aprendizServices.findAllObservacion();
	}
	
	@PostMapping("/observacion")
	@ResponseStatus( HttpStatus.CREATED)
	public Observacion crearObservacion(@RequestBody Observacion observacion) {
		return aprendizServices.crearObservacion(observacion);
	}
}
