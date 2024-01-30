package kjavac.syntax.statements;

import java.util.List;

import kjavac.syntax.Token;

public abstract class Statement {

	public Statement() {
		
	}
	
	public static Statement create(List<Token> tokens) {
		if (tokens.size() == 0) {
			return new NullStatement();
		}
		
		//TODO Match variable declaration
		return null;
	}

}
