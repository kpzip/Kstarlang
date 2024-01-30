package kjavac.syntax.expression.math;

import kjavac.syntax.type.Type;

public class AddExpression implements NumberExpression {
	
	private NumberExpression left, right;

	public AddExpression(NumberExpression left, NumberExpression right) {
		this.left = left;
		this.right = right;
	}
	
	public NumberExpression getLeft() {
		return left;
	}
	
	public NumberExpression getRight() {
		return right;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		return left.isValid() && right.isValid();
	}

}
