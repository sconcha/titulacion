package edu.ug.dto.administracion;

import javax.persistence.Entity;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;



@Entity
@Table(name="UADMTSISTEMA")
public class SistemaDTO extends GenericDTO<Long> {

	private static final long serialVersionUID = 3781376647430403022L;

}