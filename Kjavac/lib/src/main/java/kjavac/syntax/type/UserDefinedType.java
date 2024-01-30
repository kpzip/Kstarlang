package kjavac.syntax.type;

import kjavac.syntax.variables.LocalVariableTable;

public class UserDefinedType implements Type {
	
	private LocalVariableTable variables;

	public UserDefinedType() {
		variables = new LocalVariableTable();
	}
	
	@Override
	public int sizeof() {
		return variables.size();
	}

	@Override
	public boolean equals(Type t) {
		return this == t;
	}

}
