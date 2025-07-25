/**
 * 
 */
package kjavac.ast.statement.declaration;

import java.util.List;

import kjavac.ast.Identifier;
import kjavac.ast.Visibility;
import kjavac.ast.statement.VariableTypeDeclaration;
import kjavac.ast.type.Type;

/**
 * 
 * @author kpzip
 * 
 */
public class FunctionInfo {

	private Visibility vis;
	private Type return_type;
	private List<VariableTypeDeclaration> parameters;
	private Identifier name;
	
	/**
	 * 
	 */
	public FunctionInfo(Visibility vis, Type return_type, List<VariableTypeDeclaration> parameters, Identifier name) {
		this.vis = vis;
		this.return_type = return_type;
		this.parameters = parameters;
		this.name = name;
	}

}
