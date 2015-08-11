package ec.edu.ug.chamaleon.util.type;

import ec.edu.ug.chamaleon.util.dto.Generic;


public interface StringValuedEnum<T extends Enum<T>> extends Generic<String, String> {
    public String getDescription();
    
}
