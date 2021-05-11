package com.proyec.builsoft.controller;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyec.builsoft.entities.Aprendiz;
import com.proyec.builsoft.entities.Ficha;
import com.proyec.builsoft.entities.TipoDocumento;
import com.proyec.builsoft.entities.Trimestre;
import com.proyec.builsoft.services.IAprendizServices;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AprendizRestController {

	@Autowired
	private IAprendizServices aprendizServices;
	
	
	@GetMapping("/aprendiz/page/{page}")
	public Page<Aprendiz> index(@PathVariable Integer page) {
		return aprendizServices.findAllAprendiz(PageRequest.of(page, 4));
	}
	
	@GetMapping("/aprendiz/{id}")
	public ResponseEntity<?> findByid(@PathVariable Long id) {

		Aprendiz aprendiz = null;
		Map<String, Object> response = new HashMap<>();

		try {

			aprendiz = aprendizServices.findByIdAprendiz(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (aprendiz == null) {
			response.put("mensaje", "El Aprendiz ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Aprendiz>(aprendiz, HttpStatus.OK);
	}
	
	
	@PostMapping("/aprendiz")
	public ResponseEntity<?> create(@Valid @RequestBody Aprendiz aprendiz, BindingResult result) {

		Aprendiz aprendizNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {

			aprendizNew = aprendizServices.createAprendiz(aprendiz);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El aprendiz ha sido creado con éxito!");
		response.put("aprendiz", aprendizNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/aprendiz/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Aprendiz aprendiz, BindingResult result,
			@PathVariable Long id) {

		Aprendiz aprendizActual = aprendizServices.findByIdAprendiz(id);

		Aprendiz aprendizUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (aprendizActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			aprendizActual.setApellido(aprendiz.getApellido());
			aprendizActual.setNombre(aprendiz.getNombre());
			aprendizActual.setMail(aprendiz.getMail());
			aprendizActual.setDocumento(aprendiz.getDocumento());
			aprendizActual.setTelefono(aprendiz.getTelefono());
			aprendizActual.setTipoDocumento(aprendiz.getTipoDocumento());
			aprendizActual.setFicha(aprendiz.getFicha());
			aprendizActual.setTrimestre(aprendiz.getTrimestre());

			aprendizUpdated = aprendizServices.createAprendiz(aprendizActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("aprendiz", aprendizUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/aprendiz/tipoDocumentos")
	public List<TipoDocumento> listarDocumentos() {
		return aprendizServices.findAllDocumento();
	}
	
	@GetMapping("/aprendiz/fichas")
	public List<Ficha> listarFichas() {
		return aprendizServices.findAllFichas();
	}
	
	
	@GetMapping("/aprendiz/trimestres")
	public List<Trimestre> listarTrimestres() {
		return aprendizServices.findAllTrimestres();
	}
	
	@GetMapping("/aprendiz/documento/{term}")
	public ResponseEntity<?> findByDocuemtno(@PathVariable String term) {
		
		Aprendiz aprendiz = null;
		Map<String, Object> response = new HashMap<>();
		try {

			aprendiz = aprendizServices.findByDocumento(term);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (aprendiz == null) {
			response.put("mensaje","El Aprendiz con documento: ".concat(term.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Aprendiz>(aprendiz, HttpStatus.OK);
	}
}
