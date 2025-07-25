/**
 * 
 */
package kjavac.ast.lowering;

import java.util.HashMap;
import java.util.Map;

import kjavac.ast.Identifier;

/**
 * 
 * @author kpzip
 * 
 */
public class IdentifierContext {
	
	private Map<Identifier, ResolvedName> imported;

	/**
	 * 
	 */
	public IdentifierContext() {
		imported = new HashMap<Identifier, ResolvedName>();
		
	}

}
