package ec.edu.ug.erp.servicio.test;

import java.util.Calendar;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;


public class App {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/spring/bo/config/appContext.xml");


		
		//AdministracionService service = context.getBean("administracionService",AdministracionService.class);
		SeguridadService service = context.getBean("seguridadService",SeguridadService.class);
		
		ModuloDTO modulo;
		ModuloDTO submenu;
		ModuloDTO opcion;

		modulo=new ModuloDTO();		
		modulo.setCodigo("DASH");
		modulo.setDescripcion("Dashboard");
		modulo.setIcono("fa fa-dashboard");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(0);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);

		
		modulo=new ModuloDTO();		
		modulo.setCodigo("GENE");
		modulo.setDescripcion("Configuraciones Generales");
		modulo.setIcono("fa fa-wrench");
		//modulo.setIcono("fa fa-cogs");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(10);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);
		
		
		modulo=new ModuloDTO();		
		modulo.setCodigo("RRHH");
		modulo.setDescripcion("Recursos Humanos");
		modulo.setIcono("fa fa-users");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(20);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);


		
		
		modulo=new ModuloDTO();		
		modulo.setCodigo("ADMI");
		modulo.setDescripcion("Administracion");
		modulo.setIcono("fa fa-cogs");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(30);
		modulo.setTipo(Tipo.MODULO);
		
		service.saveModulo(modulo);

		modulo=new ModuloDTO();		
		modulo.setCodigo("SEGU");
		modulo.setDescripcion("Seguridad");
		modulo.setIcono("fa fa-lock");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(40);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);
		
		modulo=new ModuloDTO();		
		modulo.setCodigo("INVE");
		modulo.setDescripcion("Inventario");
		modulo.setIcono("fa fa-pie-chart");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(50);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);
		
		
		
		
		
		
		modulo=new ModuloDTO();		
		modulo.setCodigo("COMP");
		modulo.setDescripcion("Compras");
		modulo.setIcono("fa fa-shopping-cart");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(60);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);
		
		
			submenu=new ModuloDTO();		
			submenu.setCodigo("COMP.1");
			submenu.setDescripcion("Compra");
			submenu.setIcono("fa fa-cart-plus");
			submenu.setPadre(modulo);
			submenu.setEstado(Estado.ACTIVO);
			submenu.setFechaCreacion(Calendar.getInstance().getTime());
			submenu.setNivel(2);
			submenu.setOrden(10);
			submenu.setTipo(Tipo.MENU);
			service.saveModulo(submenu);
		
		
		
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.1.1");
				opcion.setDescripcion("Pedidos de Compra");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(10);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.1.2");
				opcion.setDescripcion("Cotizaciones a proveedores");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(20);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.1.3");
				opcion.setDescripcion("Ordenes de Compra");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(30);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.1.4");
				opcion.setDescripcion("Recepcion de Compra");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(40);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
		

			submenu=new ModuloDTO();		
			submenu.setCodigo("COMP.2");
			submenu.setDescripcion("Productos En Transito");
			submenu.setIcono("fa fa-truck");
			submenu.setPadre(modulo);
			submenu.setEstado(Estado.ACTIVO);
			submenu.setFechaCreacion(Calendar.getInstance().getTime());
			submenu.setNivel(2);
			submenu.setOrden(20);
			submenu.setTipo(Tipo.MENU);
			service.saveModulo(submenu);
					
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.2.1");
				opcion.setDescripcion("Compras Locales Por Llegar");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(10);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.2.2");
				opcion.setDescripcion("Importaciones Por Llegar");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(20);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				
			
			submenu=new ModuloDTO();		
			submenu.setCodigo("COMP.3");
			submenu.setDescripcion("Control de Documentos de Compras");
			submenu.setIcono("fa fa-file-text");
			submenu.setPadre(modulo);
			submenu.setEstado(Estado.ACTIVO);
			submenu.setFechaCreacion(Calendar.getInstance().getTime());
			submenu.setNivel(2);
			submenu.setOrden(30);
			submenu.setTipo(Tipo.MENU);
			service.saveModulo(submenu);
			
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.3.1");
				opcion.setDescripcion("Facturas de proveedores");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(10);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.3.2");
				opcion.setDescripcion("Documentos de Importacion");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(20);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
			submenu=new ModuloDTO();		
			submenu.setCodigo("COMP.4");
			submenu.setDescripcion("Productos & Proveedores");
			submenu.setIcono("fa fa-sistemap");
			submenu.setPadre(modulo);
			submenu.setEstado(Estado.ACTIVO);
			submenu.setFechaCreacion(Calendar.getInstance().getTime());
			submenu.setNivel(2);
			submenu.setOrden(40);
			submenu.setTipo(Tipo.MENU);
			service.saveModulo(submenu);
			
				opcion=new ModuloDTO();		
				opcion.setCodigo("COMP.4.1");
				opcion.setDescripcion("Precios de productos por proveedores");
				opcion.setIcono("fa fa-external-link");
				opcion.setPadre(submenu);
				opcion.setEstado(Estado.ACTIVO);
				opcion.setFechaCreacion(Calendar.getInstance().getTime());
				opcion.setNivel(3);
				opcion.setOrden(10);
				opcion.setTipo(Tipo.OPCION);
				service.saveModulo(opcion);
				
				
		
		
		
		
		
		
		
		
		modulo=new ModuloDTO();		
		modulo.setCodigo("FACT");
		modulo.setDescripcion("Facturacion");
		modulo.setIcono("fa fa-money");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(70);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);

		modulo=new ModuloDTO();		
		modulo.setCodigo("GERE");
		modulo.setDescripcion("Gerencial");
		modulo.setIcono("fa fa-area-chart");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(80);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);

		modulo=new ModuloDTO();		
		modulo.setCodigo("CONT");
		modulo.setDescripcion("Contabilidad");
		modulo.setIcono("fa fa-dollar");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(90);
		modulo.setTipo(Tipo.MODULO);

		service.saveModulo(modulo);
		
		
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
