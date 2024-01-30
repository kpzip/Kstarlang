package kjavac.syntax.type;

public interface Type {
	
	public static int PointerSize = 8;

	int sizeof();
	
	boolean equals(Type t);
}
