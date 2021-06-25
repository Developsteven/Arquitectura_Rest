package com.proyec.builsoft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyec.builsoft.entities.Aprendiz;
import com.proyec.builsoft.entities.Ficha;
import com.proyec.builsoft.entities.Novedad;
import com.proyec.builsoft.entities.Programa;
import com.proyec.builsoft.entities.TipoDocumento;
import com.proyec.builsoft.entities.TipoNovedad;
import com.proyec.builsoft.entities.Trimestre;


public interface IAprendizServices {

	public List<Aprendiz> findAllAprendiz();
	
	public Page<Aprendiz> findAllAprendiz(Pageable pageable);
	
	public Aprendiz findByIdAprendiz(Long id);
	
	public Aprendiz createAprendiz(Aprendiz aprendiz);
	
	public List<TipoDocumento> findAllDocumento();
	
	public List<Trimestre> findAllTrimestres();
	
	public List<Ficha> findAllFichas();
	
	public Novedad findByIdNovedad(Long id);
	
	public Novedad createNovedad(Novedad novedad);
	
	public List<TipoNovedad> findAllTipoNovedad();
	
	public Aprendiz findByDocumento(String term);
	
	public List<Programa> findAllProgramas();
}
