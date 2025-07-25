/**
 * 
 */
package kjavac.ast.lowering;

import kjavac.ast.Identifier;

/**
 * 
 * @author kpzip
 * 
 */
public class ResolvedName {

	private String resolved;
	private String code_name;
	
	/**
	 * @param name
	 */
	public ResolvedName(String name, String resolved) {
		this.code_name = name;
		this.resolved = resolved.replace('.', '/');
	}

}
