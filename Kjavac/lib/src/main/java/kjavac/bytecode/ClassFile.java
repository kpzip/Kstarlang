/**
 * 
 */
package kjavac.bytecode;

import java.io.File;

import kjavac.ast.type.DefinedType;
import kjavac.bytecode.constantpool.ConstantPool;

/**
 * 
 * @author kpzip
 * 
 */
public class ClassFile {
	
	public static final int MAGIC = 0xcafebabe;
	
	public static final short MINOR_VERSION = 1;
	public static final short MAJOR_VERSION = 0x41;
	
	private AccessFlags access_flags = new AccessFlags();
	
	private DefinedType this_class;
	private DefinedType super_class;
	private DefinedType[] interfaces;
	
	private short[] fields;
	private short[] methods;
	private short[] attributes;

	/**
	 * 
	 */
	public ClassFile() {
		// TODO Auto-generated constructor stub
	}
	
	public void write(File f) {
		ConstantPool cp = new ConstantPool();
		
		
		
		short this_class_num = cp.addClassRef(this.this_class);
		short super_class_num = cp.addClassRef(this.super_class);
		
		short[] interfaces_num = new short[interfaces.length];
		for (int i = 0; i < interfaces.length; i++) {
			interfaces_num[i] = cp.addClassRef(interfaces[i]);
		}
		
		
	}

}
