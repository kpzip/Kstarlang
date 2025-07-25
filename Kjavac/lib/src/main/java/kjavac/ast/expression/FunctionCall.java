/**
 * 
 */
package kjavac.ast.expression;

import java.util.List;

import kjavac.ast.Identifier;

/**
 * 
 * @author kpzip
 * 
 */
public class FunctionCall implements Expression {
	
	private Identifier name;
	private List<Expression> arguments;

	/**
	 * 
	 */
	public FunctionCall(Identifier name, List<Expression> arguments) {
		this.name = name;
		this.arguments = arguments;
	}

}
