/**
 * 
 */
package kjavac.ast.expression;

/**
 * 
 * @author kpzip
 * 
 */
public class Literal implements Expression {
	
	private String val;

	/**
	 * 
	 */
	public Literal(String val) {
		this.val = val;
	}

}
