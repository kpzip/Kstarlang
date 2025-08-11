/**
 * 
 */
package kjavac.bytecode.constantpool;

import kjavac.ast.Identifier;
import kjavac.ast.expression.BinaryExpression.Type;
import kjavac.ast.type.DefinedType;

/**
 * 
 * @author kpzip
 * 
 */
public class FieldReference {
	
	private DefinedType clazz;
	private Identifier name;
	private Type ty;

	/**
	 * 
	 */
	public FieldReference(DefinedType clazz, Identifier name, Type ty) {
		this.clazz = clazz;
		this.name = name;
		this.ty = ty;
	}

}
