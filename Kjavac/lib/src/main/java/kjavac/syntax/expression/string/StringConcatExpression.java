package kjavac.syntax.expression.string;

public class StringConcatExpression {

	private CharacterExpression left, right;

	public StringConcatExpression(CharacterExpression left, CharacterExpression right) {
		this.left = left;
		this.right = right;
	}
	
	public CharacterExpression getLeft() {
		return left;
	}
	
	public CharacterExpression getRight() {
		return right;
	}

}
