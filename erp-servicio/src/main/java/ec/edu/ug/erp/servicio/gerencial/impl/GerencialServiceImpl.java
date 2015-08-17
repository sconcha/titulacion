package ec.edu.ug.erp.servicio.gerencial.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.gerencial.GerencialDao;
import ec.edu.ug.erp.servicio.gerencial.GerencialService;

@Service("gerencialService")
public class GerencialServiceImpl implements GerencialService {

	@Autowired
	private GerencialDao gerencialDao;

}
