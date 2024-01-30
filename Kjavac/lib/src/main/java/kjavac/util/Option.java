package kjavac.util;

public class Option<T, E> {
	
	private enum Type {
		FIRST,
		SECOND,
		NEITHER
	}
	
	private Type type;
	
	private Object data;
	
	public Option(Class<T> tclass, Class<E> eclass, Object data) {
		this.data = data;
		if (tclass.isAssignableFrom(data.getClass())) {
			type = Type.FIRST;
		}
		else if (eclass.isAssignableFrom(data.getClass())) {
			type = Type.SECOND;
		}
		else {
			type = Type.NEITHER;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T getT() {
		return (T) data;
	}
	
	@SuppressWarnings("unchecked")
	public E getE() {
		return (E) data;
	}
	
	public boolean isT() {
		return type == Type.FIRST;
	}
	
	public boolean isE() {
		return type == Type.SECOND;
	}

}
