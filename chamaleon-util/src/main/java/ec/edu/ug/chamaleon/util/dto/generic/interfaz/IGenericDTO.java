package ec.edu.ug.chamaleon.util.dto.generic.interfaz;

import ec.edu.ug.chamaleon.util.dto.Generic;

public interface IGenericDTO<ID> extends Generic<String, String> {

	public ID getId();

	public void setId(ID id);
}
