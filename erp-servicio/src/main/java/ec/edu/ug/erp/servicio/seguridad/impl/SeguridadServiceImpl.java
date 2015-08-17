package ec.edu.ug.erp.servicio.seguridad.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;

@Service("seguridadService")
public class SeguridadServiceImpl implements SeguridadService {

	@Autowired
	private SeguridadDao seguridadDao;

}
