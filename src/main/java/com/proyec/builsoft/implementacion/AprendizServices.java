package com.proyec.builsoft.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyec.builsoft.dao.IAprendizDao;
import com.proyec.builsoft.dao.IFichaDao;
import com.proyec.builsoft.dao.INovedadDao;
import com.proyec.builsoft.dao.IObservacion;
import com.proyec.builsoft.dao.IPrograma;
import com.proyec.builsoft.dao.ITipoDocumentoDao;
import com.proyec.builsoft.dao.ITipoNovedadDao;
import com.proyec.builsoft.dao.ITrimestreDao;
import com.proyec.builsoft.entities.Aprendiz;
import com.proyec.builsoft.entities.Ficha;
import com.proyec.builsoft.entities.Novedad;
import com.proyec.builsoft.entities.Observacion;
import com.proyec.builsoft.entities.Programa;
import com.proyec.builsoft.entities.TipoDocumento;
import com.proyec.builsoft.entities.TipoNovedad;
import com.proyec.builsoft.entities.Trimestre;
import com.proyec.builsoft.services.IAprendizServices;

@Service
public class AprendizServices implements IAprendizServices{

	@Autowired
	private IAprendizDao aprendizDao;
	
	@Autowired
	private ITipoDocumentoDao documentoDao;
	
	@Autowired
	private IFichaDao fichaDao;
	
	@Autowired
	private ITrimestreDao trimestreDao;
	
	@Autowired
	private INovedadDao novedadDao;
	
	@Autowired
	private ITipoNovedadDao tipoNovedadDao;
	
	@Autowired
	private IPrograma programaDao;
	
	@Autowired
	private IObservacion observacionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Aprendiz> findAllAprendiz() {
		return (List<Aprendiz>) aprendizDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Aprendiz> findAllAprendiz(Pageable pageable) {
		return aprendizDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Aprendiz findByIdAprendiz(Long id) {
		return aprendizDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Aprendiz createAprendiz(Aprendiz aprendiz) {
		return aprendizDao.save(aprendiz);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAllDocumento() {
		return (List<TipoDocumento>) documentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Trimestre> findAllTrimestres() {
		return (List<Trimestre>) trimestreDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ficha> findAllFichas() {
		return (List<Ficha>) fichaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Novedad findByIdNovedad(Long id) {
		return novedadDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Novedad createNovedad(Novedad novedad) {
		return novedadDao.save(novedad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoNovedad> findAllTipoNovedad() {
		return (List<TipoNovedad>) tipoNovedadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Aprendiz findByDocumento(String term) {
		return aprendizDao.findByDocumento(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Programa> findAllProgramas() {
		return (List<Programa>) programaDao.findAll();
	}

	@Override
	public Observacion crearObservacion(Observacion observacion) {
		return observacionDao.save(observacion);
	}

	@Override
	public List<Observacion> findAllObservacion() {
		return (List<Observacion>) observacionDao.findAll();
	}

}
