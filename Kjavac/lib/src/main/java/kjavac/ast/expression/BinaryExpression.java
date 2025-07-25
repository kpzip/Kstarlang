/**
 * 
 */
package kjavac.ast.expression;

/**
 * 
 * @author kpzip
 * 
 */
public class BinaryExpression implements Expression {
	
	private Type type;
	private Expression lhs, rhs;

	/**
	 * 
	 */
	public BinaryExpression(Expression lhs, Expression rhs, Type type) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.type = type;
	}
	
	public static enum Type {
		
		ADD,
		SUBTRACT,
		MULTIPLY,
		DIVIDE;
		
	}

}
