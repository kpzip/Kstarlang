package kjavac.syntax.type;

public class ReferenceType implements Type {
	
	private Type reference;

	public ReferenceType(Type reference) {
		this.reference = reference;
	}
	
	public Type getReference() {
		return reference;
	}

	@Override
	public int sizeof() {
		return Type.PointerSize;
	}

	@Override
	public boolean equals(Type t) {
		return t instanceof ReferenceType r && r.reference.equals(this.reference);
	}

}
