package ec.edu.ug.erp.servicio.general.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.general.GeneralDao;
import ec.edu.ug.erp.servicio.general.GeneralService;

@Service("generalService")
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private GeneralDao generalDao;

}
