package kjavac.syntax.statements;

import javax.annotation.Nullable;

import kjavac.syntax.expression.Expression;
import kjavac.syntax.type.Type;
import kjavac.syntax.variables.LocalVariableTable;

public class LocalVariableDeclaration extends Statement {
	
	private boolean is_final;
	private Type type;
	private String name;

	@Nullable
	private Expression assignment;
	
	public LocalVariableDeclaration(boolean is_final, Type type, String name, Expression assignment) {
		this.is_final = is_final;
		this.type = type;
		this.name = name;
		this.assignment = assignment;
	}
	
	public LocalVariableDeclaration(boolean is_final, Type type, String name) {
		this(is_final, type, name, null);
	}

	public void generateLocalVariableTable(LocalVariableTable lvt) {
		lvt.add(name, type);
	}
	
	public boolean isFinal() {
		return is_final;
	}

}
