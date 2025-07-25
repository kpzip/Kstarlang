/**
 * 
 */
package kjavac.ast.statement.declaration;

import java.util.List;

import kjavac.ast.Visibility;
import kjavac.ast.type.Type;

/**
 * 
 * @author kpzip
 * 
 */
public class ClassDeclaration extends Declaration {
	
	private Visibility vis;
	private Type class_type;
	private Type superclass;
	private List<Type> interfaces;
	private boolean is_enum, is_singleton;
	private List<Declaration> inner;

	/**
	 * 
	 */
	public ClassDeclaration(Visibility vis, Type class_type, Type superclass, List<Type> interfaces, boolean is_enum, boolean is_singleton, List<Declaration> inner) {
		this.vis = vis;
		this.class_type = class_type;
		this.superclass = superclass;
		this.interfaces = interfaces;
		this.is_enum = is_enum;
		this.is_singleton = is_singleton;
		this.inner = inner;
	}

}
