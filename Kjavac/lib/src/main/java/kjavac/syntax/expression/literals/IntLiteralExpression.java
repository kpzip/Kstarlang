package kjavac.syntax.expression.literals;

import java.math.BigInteger;

import kjavac.syntax.expression.math.NumberExpression;
import kjavac.syntax.type.BuiltinType;
import kjavac.syntax.type.Type;

public class IntLiteralExpression implements NumberExpression {
	
	private final BigInteger value;
	
	private final BuiltinType type;

	public IntLiteralExpression(BigInteger value, BuiltinType type) {
		this.value = value;
		this.type = type;
	}
	
	public BigInteger getValue() {
		return value;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
