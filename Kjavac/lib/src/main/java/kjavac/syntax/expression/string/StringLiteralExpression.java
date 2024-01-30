package kjavac.syntax.expression.string;

import kjavac.syntax.type.BuiltinType;
import kjavac.syntax.type.ReferenceType;
import kjavac.syntax.type.Type;

public class StringLiteralExpression implements CharacterExpression {

	private String value;
	
	public StringLiteralExpression(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public Type getType() {
		return new ReferenceType(BuiltinType.CHAR);
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
