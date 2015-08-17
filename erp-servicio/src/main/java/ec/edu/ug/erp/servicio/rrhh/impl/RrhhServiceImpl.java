package ec.edu.ug.erp.servicio.rrhh.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.rrhh.RrhhDao;
import ec.edu.ug.erp.servicio.rrhh.RrhhService;

@Service("rrhhService")
public class RrhhServiceImpl implements RrhhService {

	@Autowired
	private RrhhDao rrhhDao;

}
