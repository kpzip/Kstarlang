/**
 * 
 */
package kjavac.ast.statement;

import kjavac.ast.expression.Expression;

/**
 * 
 * @author kpzip
 * 
 */
public class VariableDeclarationAssignment implements Statement {
	
	private VariableTypeDeclaration decl;
	private Expression rhs;
	

	/**
	 * 
	 */
	public VariableDeclarationAssignment(VariableTypeDeclaration decl, Expression rhs) {
		this.decl = decl;
		this.rhs = rhs;
	}

}
