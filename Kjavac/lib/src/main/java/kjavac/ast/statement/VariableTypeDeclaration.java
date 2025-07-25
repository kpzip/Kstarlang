/**
 * 
 */
package kjavac.ast.statement;

import kjavac.ast.Identifier;
import kjavac.ast.type.Type;

/**
 * 
 * @author kpzip
 * 
 */
public class VariableTypeDeclaration implements Statement {
	
	private Type type;
	private Identifier name;

	/**
	 * 
	 */
	public VariableTypeDeclaration(Type type, Identifier name) {
		this.type = type;
		this.name = name;
	}

}
