/**
 * 
 */
package kjavac.ast.statement;

import kjavac.ast.Identifier;
import kjavac.ast.expression.Expression;

/**
 * 
 * @author kpzip
 * 
 */
public class VariableAssignment implements Statement {
	
	private Identifier variable;
	private Expression rhs;
	

	/**
	 * 
	 */
	public VariableAssignment(Identifier variable, Expression rhs) {
		this.variable = variable;
		this.rhs = rhs;
	}

}
