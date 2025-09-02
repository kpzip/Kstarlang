/**
 * 
 */
package kjavac.bytecode.constantpool;

import kjavac.ast.type.DefinedType;

/**
 * 
 * @author kpzip
 * 
 */
public class ClassReference {

	
	private DefinedType dt;
	private int string_index;
	/**
	 * 
	 */
	public ClassReference(DefinedType dt, int string_index) {
		this.dt = dt;
		this.string_index = string_index;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ClassReference && ((ClassReference) obj).dt.equals(this.dt);
	}

}
