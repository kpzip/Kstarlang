package kjavac.syntax;

public class Token {
	
	private Type t;
	
	private String value;

	public Token(Type t, String value) {
		this.t = t;
		this.value = value;
	}
	
	public Type getType() {
		return t;
	}
	
	public String getValue() {
		return value;
	}
	
	
	@Override
	public String toString() {
		return "Token [t=" + t.name() + ", value=" + value + "]";
	}


	public enum Type {
		IDENTIFIER,
		KEYWORD,
		OPERATOR,
		ENDSTATEMENT,
		STRLITERAL,
		CHARLITERAL,
		INTLITERAL,
		DECLITERAL,
		DOT,
		SCOPEBEGIN,
		SCOPEEND,
		EXPRBEGIN,
		EXPREND
	}

}
