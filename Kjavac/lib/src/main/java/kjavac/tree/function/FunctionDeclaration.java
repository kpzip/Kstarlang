/**
 * 
 */
package kjavac.tree.function;

import java.util.ArrayList;

import kjavac.generated.KStarParser.Function_declarationContext;
import kjavac.tree.Declaration;
import kjavac.tree.Statement;
import kjavac.tree.info.Visibility;

/**
 * 
 * @author kpzip
 * 
 */
public class FunctionDeclaration implements Declaration {
	
	private Visibility vis;
	private boolean is_abstract;
	private ArrayList<Statement> statementlist;

	/**
	 * @param child 
	 * 
	 */
	public FunctionDeclaration(Function_declarationContext child) {
		// TODO Auto-generated constructor stub
	}

}
