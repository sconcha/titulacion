package ec.edu.ug.erp.util.dto;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

public class DTOUtils {

	public static boolean isPersistent(GenericDTO<?> dto){
		if(dto!=null&&dto.getId()!=null)
			return true;
		else
			return false;
	}
	
	public static boolean isNull(GenericDTO<?> dto){
		return dto==null;
	}
	
	public static boolean isNotNull(GenericDTO<?> dto){
		return !isNull(dto);
	}
	
}
