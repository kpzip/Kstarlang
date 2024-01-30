package kjavac.components;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import kjavac.syntax.Token;

public class Lexer {
	
	public static final String[] KEYWORDS = {"void", "public", "int"};
	
	public static final Pattern WHITESPACE = Pattern.compile("\\G\\s+");

	private Lexer() {}
	
	public static List<Token> lexicalAnalysis(Scanner programScanner) {
		List<Token> tokens = new LinkedList<Token>();
		programScanner.useDelimiter("");
		
		while (programScanner.hasNext()) {
			if (programScanner.hasNext(WHITESPACE)) {
				programScanner.skip(WHITESPACE);
				continue;
			}
			
			//Order Matters!
			if (checkForAndAppendToken(programScanner, tokens, TokenType.KEYWORD)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.IDENTIFIER)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.ENDSTATEMENT)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.OPERATOR)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.DECLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.INTLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.STRLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.CHARLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.DOT)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.SCOPEBEGIN)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.SCOPEEND)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.EXPRBEGIN)) continue;
			if (checkForAndAppendToken(programScanner, tokens, TokenType.EXPREND)) continue;
			throw new IllegalStateException("failed to match any token! -> " + programScanner.next());
		}
		
		return tokens;
		
	}
	
	private static boolean checkForAndAppendToken(Scanner scan, List<Token> tokens, TokenType type) {
		//Optimise with ternary operator
		String str;
		if ((str = scan.findWithinHorizon(type.getPattern(), 0)) != null) {
			tokens.add(new Token(type, str));
			return true;
		}
		return false;
	}
	
	public enum TokenType {
		
		IDENTIFIER("\\G[a-zA-Z_$][a-zA-Z_$0-9]*"),
		KEYWORD("\\G(int|float|char|public|void)"),
		OPERATOR("\\G="),
		ENDSTATEMENT("\\G;"),
		STRLITERAL("\\G\"([^\"\\\\]|\\\\.)*\""),
		CHARLITERAL("\\G'.'"),
		INTLITERAL("\\G[0-9]+"),
		DECLITERAL("\\G[0-9]*\\.[0-9]+"),
		DOT("\\G\\."),
		SCOPEBEGIN("\\G\\{"),
		SCOPEEND("\\G\\}"),
		EXPRBEGIN("\\G\\("),
		EXPREND("\\G\\)");
		
		private final Pattern matcher;
		
		private TokenType(String regex) {
			matcher = Pattern.compile(regex);
		}
		
		public Pattern getPattern() {
			return matcher;
		}
		
		
	}

}
