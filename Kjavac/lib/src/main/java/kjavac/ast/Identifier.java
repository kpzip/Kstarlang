/**
 * 
 */
package kjavac.ast;

import kjavac.ast.expression.Expression;

/**
 * 
 * @author kpzip
 * 
 */
public class Identifier implements Expression {
	
	private String name;

	/**
	 * 
	 */
	public Identifier(String name) {
		this.name = name;
	}

}
