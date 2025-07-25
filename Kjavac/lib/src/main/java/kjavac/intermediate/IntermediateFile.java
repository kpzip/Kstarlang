/**
 * 
 */
package kjavac.intermediate;

import java.util.List;

/**
 * 
 * @author kpzip
 * 
 */
public class IntermediateFile {
	
	private List<IntermediateClass> classes;
	private List<IntermediateFunction> methods;
	
	
	
	public IntermediateFile(List<IntermediateClass> classes, List<IntermediateFunction> methods) {
		this.classes = classes;
		this.methods = methods;
	}
	

}
