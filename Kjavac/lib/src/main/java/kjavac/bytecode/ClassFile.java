/**
 * 
 */
package kjavac.bytecode;

import java.io.File;

import kjavac.ast.type.DefinedType;
import kjavac.bytecode.constantpool.ConstantPool;
import kjavac.bytecode.field.FieldInfo;
import kjavac.bytecode.method.MethodInfo;

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
	
	private FieldInfo[] fields;
	private MethodInfo[] methods;
	private short[] attributes;

	/**
	 * 
	 */
	public ClassFile() {
		// TODO Auto-generated constructor stub
	}
	
	public void write(File f) {
		ConstantPool cp = new ConstantPool();
		
		cp.addClassRef(this.this_class);
		cp.addClassRef(this.super_class);
		for (DefinedType i : this.interfaces) {
			cp.addClassRef(i);
		}
		
		for (MethodInfo m : this.methods) {
			m.addConstantPoolEntries(cp);
		}
		
		
		
		
	}

}
