package ec.edu.ug.erp.web.template;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;

@Named("tabOptionsMB")
@SessionScoped
public class TabOptionsMB extends TemplateMB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10820309169280424L;
	
	private List<ModuloDTO> options;
	
	@PostConstruct
	protected void init(){
		
		ModuloDTO modulo;
		ModuloDTO opcion;
		
		options=new ArrayList<ModuloDTO>();
		
		modulo=new ModuloDTO();		
		modulo.setCodigo("DASH");
		modulo.setDescripcion("Dashboard");
		modulo.setIcono("fa fa-dashboard");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(0);
		modulo.setAccionListar("/pages/general/dashboard.xhtml");		
		modulo.setTipo(Tipo.OPCION);		
		options.add(modulo);
		
		opcion=new ModuloDTO();		
		opcion.setCodigo("COMP");
		opcion.setDescripcion("Pedidos de Compra");
		opcion.setIcono("fa fa-external-link");
		opcion.setEstado(Estado.ACTIVO);
		opcion.setNivel(3);
		opcion.setOrden(10);
		opcion.setAccionListar("/pages/compras/pedido.xhtml");
		opcion.setTipo(Tipo.OPCION);
		options.add(opcion);
		
		

	}
	
	
	
	public void onTabChange(TabChangeEvent event) {        
        addMessageInfo("Tab Changed", "Active Tab: " + event.getTab().getTitle());
    }
         
    public void onTabClose(TabCloseEvent event) {        
        addMessageInfo("Tab Closed", "Closed tab: " + event.getTab().getTitle());
    }
    
    public void addOption(ModuloDTO option){
    	options=options!=null?options:new ArrayList<ModuloDTO>();
    	options.add(option);
    }
    
	
	public List<ModuloDTO> getOptions() {
		return options;
	}

	public void setOptions(List<ModuloDTO> options) {
		this.options = options;
	}
	
	

}
