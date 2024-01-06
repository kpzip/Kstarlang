package kjavac.syntax;

import kjavac.components.Lexer.TokenType;

public class Token {
	
	private TokenType t;
	
	private String value;

	public Token(TokenType t, String value) {
		this.t = t;
		this.value = value;
	}
	
	public TokenType getType() {
		return t;
	}
	
	public String getValue() {
		return value;
	}
	
	
	@Override
	public String toString() {
		return "Token [t=" + t.name() + ", value=" + value + "]";
	}

}
