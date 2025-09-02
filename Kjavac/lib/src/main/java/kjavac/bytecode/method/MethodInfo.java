/**
 * 
 */
package kjavac.bytecode.method;

import kjavac.ast.Identifier;
import kjavac.bytecode.AccessFlags;
import kjavac.bytecode.constantpool.ConstantPool;
import kjavac.bytecode.method.attribute.MethodAttribute;

/**
 * 
 * @author kpzip
 * 
 */
public class MethodInfo {
	
	private AccessFlags flags;
	private Identifier name;
	private MethodDescriptor descriptor;
	private MethodAttribute[] attributes;

	/**
	 * 
	 */
	public MethodInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public void addConstantPoolEntries(ConstantPool cp) {
		cp.addString(name.getName());
		cp.addString(descriptor.getDescriptor());
		for (MethodAttribute ma : this.attributes) {
			ma.addConstantPoolEntries(cp);
		}
	}

}
