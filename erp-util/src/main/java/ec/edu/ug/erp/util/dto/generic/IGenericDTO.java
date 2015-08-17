package ec.edu.ug.erp.util.dto.generic;

import ec.edu.ug.erp.util.dto.Generic;

public interface IGenericDTO<ID> extends Generic<String, String> {

	public ID getId();

	public void setId(ID id);
}
