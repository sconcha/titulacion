package ec.edu.ug.chamaleon.util.type;

public interface CharValuedEnum<T extends Enum<T>> extends StringValuedEnum<T> {
	public Character getCharValue();

}
