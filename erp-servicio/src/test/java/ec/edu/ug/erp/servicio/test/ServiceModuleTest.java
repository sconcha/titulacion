package ec.edu.ug.erp.servicio.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("default")
//@ContextConfiguration
public class ServiceModuleTest {
//	
//	@Autowired
	private SeguridadService seguridad;
	
	

//	@Test
	public void testLoadModules() throws Exception {
		
		List<ModuloDTO> modulos= seguridad.loadMenu();
		
		modulos.forEach(modulo->System.out.println(modulo));
		
		org.junit.Assert.assertNotNull(modulos);		
	}

}
