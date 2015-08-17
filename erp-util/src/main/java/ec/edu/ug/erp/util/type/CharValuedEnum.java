package ec.edu.ug.erp.util.type;

public interface CharValuedEnum<T extends Enum<T>> extends StringValuedEnum<T> {
	public Character getCharValue();

}
