/**
 * 
 */
package kjavac.tree;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;

import kjavac.generated.KStarParser.Class_declarationContext;
import kjavac.generated.KStarParser.FileContext;
import kjavac.generated.KStarParser.Function_declarationContext;
import kjavac.tree.dataclass.ClassDeclaration;
import kjavac.tree.function.FunctionDeclaration;

/**
 * 
 * @author kpzip
 * 
 * Represents a parsed .ks file
 * 
 */
public class File {
	
	private ArrayList<Declaration> declarations;

	/**
	 * Convert the antlr generated syntax tree into a proper ast
	 */
	public File(FileContext c) {
		declarations = new ArrayList<Declaration>();
		for (ParseTree child : c.children) {
			if (child instanceof Class_declarationContext) {
				declarations.add(new ClassDeclaration((Class_declarationContext) child));
			} else if (child instanceof Function_declarationContext) {
				declarations.add(new FunctionDeclaration((Function_declarationContext) child));
			}
		}
	}

}
