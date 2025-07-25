/**
 * 
 */
package kjavac.ast.type;

import kjavac.ast.Identifier;

/**
 * 
 * @author kpzip
 * 
 */
public class DefinedType implements Type {

	private Identifier name;

	/**
	 * 
	 */
	public DefinedType(Identifier name) {
		this.name = name;
	}

}
