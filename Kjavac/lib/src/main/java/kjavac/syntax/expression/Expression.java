package kjavac.syntax.expression;

import kjavac.syntax.type.Type;

public interface Expression {
	
	public Type getType();
	
	public boolean isValid();

}
