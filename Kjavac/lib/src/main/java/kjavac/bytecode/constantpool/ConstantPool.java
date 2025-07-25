/**
 * 
 */
package kjavac.bytecode.constantpool;

import java.util.ArrayList;

import kjavac.ast.Identifier;
import kjavac.ast.type.DefinedType;

/**
 * 
 * @author kpzip
 * 
 */
public class ConstantPool {

	private ArrayList<ConstantPoolElement> cp;
	
	/**
	 * 
	 */
	public ConstantPool() {
		this.cp = new ArrayList<ConstantPoolElement>();
	}
	
	public short addClassRef(DefinedType t) {
		// TODO see if there is an existing reference
		
		cp.add(new UTF8String(t.toString()));
		short idx = (short) (cp.size() - 1);
		cp.add(new ClassReference(idx));
		return (short) (this.cp.size() - 1);
	}

}
