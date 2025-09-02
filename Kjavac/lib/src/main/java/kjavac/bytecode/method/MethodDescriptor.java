/**
 * 
 */
package kjavac.bytecode.method;

/**
 * 
 * @author kpzip
 * 
 */
public class MethodDescriptor {
	
	private String descriptor;

	/**
	 * 
	 */
	public MethodDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	
	public String getDescriptor() {
		return this.descriptor;
	}

}
