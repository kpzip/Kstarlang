/**
 * 
 */
package kjavac.bytecode.method.attribute;

import kjavac.bytecode.constantpool.ConstantPool;

/**
 * 
 * @author kpzip
 * 
 */
public interface MethodAttribute {
	
	public void addConstantPoolEntries(ConstantPool cp);
	
}
