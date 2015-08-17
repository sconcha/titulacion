package ec.edu.ug.erp.servicio.test;

import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.servicio.administracion.AdministracionService;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;


public class App {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"config/applicationContext.xml");
		AdministracionService dao = context.getBean("administracionService",AdministracionService.class);
		EmpresaDTO empresa=new EmpresaDTO();
		empresa.setCodigo("ITB2");
		empresa.setDescripcion("Intertubep S.A.");
		empresa.setFechaCreacion(Calendar.getInstance().getTime());
		empresa.setEstado(Estado.ACTIVO);

		// Add new Person records
		dao.saveEmpresa(empresa);
		

		// Count Person records
		System.out.println("Count empresa records: " +empresa);

		// Print all records
		//Iterable<EmpresaDTO> empresas =  dao.findAll(EmpresaDTO.class);
		//System.out.println(empresas);

		context.close();
	}
}
