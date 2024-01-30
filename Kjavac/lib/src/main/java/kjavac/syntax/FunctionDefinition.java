package kjavac.syntax;

import java.util.ArrayList;
import java.util.List;

import kjavac.components.Lexer.TokenType;
import kjavac.syntax.statements.Statement;
import kjavac.syntax.type.Type;

public class FunctionDefinition { 

	private List<Statement> body;
	private byte flags;
	
	private Type returnType;
	private String name;
	
	public FunctionDefinition(Type returnType, String name) {
		body = new ArrayList<Statement>();
		flags = (byte) 0xFF;
		this.returnType = returnType;
		this.name = name;
	}
	
	public byte getFlags() {
		return flags;
	}
	
	public Type getReturnType() {
		return returnType;
	}
	
	public String getName() {
		return name;
	}
	
	public void populate(List<Token> tokens) {
		int beginindex = 0;
		int index = 0;
		Token currToken;
		TokenType currType;
		while (index < tokens.size()) {
			currToken = tokens.get(index);
			currType = currToken.getType();
			if (currType == TokenType.ENDSTATEMENT || currType == TokenType.SCOPEBEGIN) {
				body.add(Statement.create(index != beginindex ? tokens.subList(beginindex, index) : new ArrayList<Token>()));
				beginindex = ++index;
				continue;
			}
			index++;
			continue;
		}
	}

}
