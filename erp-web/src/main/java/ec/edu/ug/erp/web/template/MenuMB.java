package ec.edu.ug.erp.web.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;

@Named("menuMB")
@SessionScoped
public class MenuMB implements Serializable {

	private static final long serialVersionUID = -3106346111915127266L;
	
	 @Inject
	 private SeguridadService seguridadService;

	private List<String> tabs;

	@PostConstruct
	public void init() {
		

	}

	public MenuModel getMenuModel() {
		return loadMenu();
	}

	private MenuModel loadMenu() {
		MenuModel menu = new DefaultMenuModel();

		List<ModuloDTO> modulos = new ArrayList<ModuloDTO>();
		try {
			modulos =seguridadService.loadModuleList();
			modulos.forEach(m-> System.out.println(m));

			for (ModuloDTO modulo : modulos) {
				DefaultSubMenu submenu = new DefaultSubMenu();
				submenu.setLabel(modulo.getDescripcion());
				submenu.setIcon(modulo.getIcono());
				menu.addElement(submenu);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// DefaultSubMenu menu=new DefaultSubMenu("MENU");

//		DefaultSubMenu submenu;
//
//		submenu = new DefaultSubMenu("General");
//		submenu.setIcon("fa fa-wrench");
//		menu.addElement(submenu);
//
//		DefaultMenuItem item1;
//		item1 = new DefaultMenuItem("Parametros Generales");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("Administracion");
//		submenu.setIcon("fa fa-gear");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Empresas");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Usuarios");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Modulos");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("Facturacion");
//		submenu.setIcon("fa fa-money");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Cotizacion");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Pedido");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Factura");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Despacho");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("RRHH");
//		submenu.setIcon("fa fa-users");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Ingreso de Peronas");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Clientes");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Proveedores");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Empleados");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("Inventario");
//		submenu.setIcon("fa fa-pie-chart");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Productos");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Stocks");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Movimientos de inventario");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("Compras");
//		submenu.setIcon("fa fa-shopping-cart");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Pedidos De Compra");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Orden De Compra");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Recepcion De Mercaderia");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Factura de Compra");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Partida de Compra");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("Gerencial");
//		submenu.setIcon("fa fa-area-chart");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Analisis de ventas por sucursal");
//		item1.setIcon("fa fa-file-pdf-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Analisis de Existencias");
//		item1.setIcon("fa fa-file-pdf-o");
//		submenu.addElement(item1);
//
//
//		submenu = new DefaultSubMenu("Contabilidad");
//		submenu.setIcon("fa fa-dollar");
//		menu.addElement(submenu);
//
//		item1 = new DefaultMenuItem("Cuentas Contables");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Cuentas Por Pagar");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);
//
//		item1 = new DefaultMenuItem("Cuentas Por Cobrar");
//		item1.setIcon("fa fa-file-o");
//		submenu.addElement(item1);

		// menu1.addElement(menu);

		return menu;
	}

	
	public List<String> getTabs() {
		tabs = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			tabs.add("Tab " + i);
		}
		return tabs;
	}
	
}
