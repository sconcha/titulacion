package ec.edu.ug.erp.util.type;

import ec.edu.ug.erp.util.dto.Generic;


public interface StringValuedEnum<T extends Enum<T>> extends Generic<String, String> {
    public String getDescription();
    
}
