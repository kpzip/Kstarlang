/**
 * 
 */
package kjavac.ast;

import java.util.List;

import kjavac.ast.statement.declaration.Declaration;

/**
 * 
 * @author kpzip
 * 
 */
public class ParsedFile {
	
	private List<Declaration> declarations;
	

	/**
	 * 
	 */
	public ParsedFile(List<Declaration> declarations) {
		this.declarations = declarations;
	}
	
	public void type_check() {
		
	}
	
	public ClassFile emitClassFile() {
		
	}

}
