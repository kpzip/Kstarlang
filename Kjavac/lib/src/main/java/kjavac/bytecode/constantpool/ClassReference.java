/**
 * 
 */
package kjavac.bytecode.constantpool;

/**
 * 
 * @author kpzip
 * 
 */
public class ClassReference implements ConstantPoolElement {
	
	public static final byte TAG_BYTE = 7;
	
	private short index;

	/**
	 * 
	 */
	public ClassReference(short index) {
		this.index = index;
	}

}
