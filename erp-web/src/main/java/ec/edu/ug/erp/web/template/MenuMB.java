package ec.edu.ug.erp.web.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;

@Named("menuMB")
@SessionScoped
public class MenuMB extends TemplateMB implements Serializable {

	private static final long serialVersionUID = -3106346111915127266L;
	
	 

	
	@PostConstruct
	public void init() {
		

	}

	public MenuModel getMenuModel() {
		return loadMenu();
	}

	private MenuModel loadMenu() {
		usuarioSesion.validaSesion();
		MenuModel menu = new DefaultMenuModel();
	
		List<ModuloDTO> modulos = new ArrayList<ModuloDTO>();
		try {			
			modulos =seguridad.loadMenu(usuarioSesion.getUsuarioSucursal());
			
			for (ModuloDTO modulo : modulos) {
				if(!modulo.getModuloDTOs().isEmpty()){
				DefaultSubMenu submenu = new DefaultSubMenu();
				submenu.setLabel(modulo.getDescripcion());
				submenu.setIcon(modulo.getIcono());
				for(ModuloDTO submodulo:modulo.getModuloDTOs()){
					submenu.getElements().add(getElementoSubmenu(submodulo));
				}
				menu.addElement(submenu);
				}else{
					DefaultMenuItem menItm = new DefaultMenuItem(modulo.getDescripcion());
					menItm.setIcon(modulo.getIcono());
					menItm.setTitle(modulo.getDescripcion());
					menItm.setUrl(modulo.getAccionListar());
					menu.addElement(menItm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
		

		return menu;
	}
	
	private MenuElement getElementoSubmenu(ModuloDTO modulo) {
		List<ModuloDTO> opcionesHijas = modulo.getModuloDTOs();
		if (opcionesHijas.isEmpty()) {
			DefaultMenuItem menItm = new DefaultMenuItem(modulo.getDescripcion());
			menItm.setIcon(modulo.getIcono());
			menItm.setTitle(modulo.getDescripcion());
			menItm.setUrl(modulo.getAccionListar());			
			return menItm;
		} else {
			DefaultSubMenu subMenu = new DefaultSubMenu(modulo.getDescripcion());			
			subMenu.setIcon(modulo.getIcono());
			for (ModuloDTO opcion : opcionesHijas) {
				subMenu.getElements().add(getElementoSubmenu(opcion));
			}
			return subMenu;
		}
	}
	
	

}
