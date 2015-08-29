package ec.edu.ug.erp.servicio.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;


public class App {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/bo/config/appContext.xml");


		
		//AdministracionService service = context.getBean("administracionService",AdministracionService.class);
		SeguridadService service = context.getBean("seguridadService",SeguridadService.class);
		
//		ModuloDTO modulo;
//		
//	    modulo=new ModuloDTO();		
//		modulo.setCodigo("ADMI");
//		modulo.setDescripcion("Administracion");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(10);
//		modulo.setTipo(Tipo.MODULO);
//		
//		service.saveModulo(modulo);
//
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("SEGU");
//		modulo.setDescripcion("Seguridad");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(20);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//		
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("GENE");
//		modulo.setDescripcion("General");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(30);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//		
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("INVE");
//		modulo.setDescripcion("Inventario");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(40);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//		
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("COMP");
//		modulo.setDescripcion("Compras");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(50);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//		
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("FACT");
//		modulo.setDescripcion("Facturacion");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(60);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("RRHH");
//		modulo.setDescripcion("Recursos Humanos");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(70);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("GERE");
//		modulo.setDescripcion("Gerencial");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(80);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
//
//		modulo=new ModuloDTO();		
//		modulo.setCodigo("CONT");
//		modulo.setDescripcion("Contabilidad");
//		modulo.setEstado(Estado.ACTIVO);
//		modulo.setFechaCreacion(Calendar.getInstance().getTime());
//		modulo.setNivel(1);
//		modulo.setOrden(90);
//		modulo.setTipo(Tipo.MODULO);
//
//		service.saveModulo(modulo);
		
		
		List<ModuloDTO> modulos=service.loadModuleList();
		modulos.forEach(m-> System.out.println(m));
		

		/*
		EmpresaDTO empresa=new EmpresaDTO();
		empresa.setCodigo("ITB2");
		empresa.setDescripcion("Intertubep S.A.");
		empresa.setFechaCreacion(Calendar.getInstance().getTime());
		empresa.setEstado(Estado.ACTIVO);

		// Add new Person records
		dao.saveEmpresa(empresa);
	*/	

		// Count Person records
//		System.out.println("Count empresa records: " +empresa);

		// Print all records
		//Iterable<EmpresaDTO> empresas =  dao.findAll(EmpresaDTO.class);
		//System.out.println(empresas);

		context.close();
	}
}
