/**
 * 
 */
package kjavac.ast.statement.declaration;

import javax.annotation.Nullable;

import kjavac.ast.statement.StatementList;

/**
 * 
 * @author kpzip
 * 
 */
public class FunctionDeclaration extends Declaration {
	
	private FunctionInfo info;
	@Nullable
	private StatementList implementation;

	/**
	 * 
	 */
	public FunctionDeclaration(FunctionInfo info, StatementList implementation) {
		this.info = info;
		this.implementation = implementation;
	}

}
