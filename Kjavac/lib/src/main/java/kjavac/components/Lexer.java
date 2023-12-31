package kjavac.components;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import kjavac.syntax.Token;

public class Lexer {
	
	public static final String[] KEYWORDS = {"void", "public", "int"};
	
	public static final Pattern KEYWORD = Pattern.compile("\\G(int|float|char|public|void)");
	public static final Pattern WHITESPACE = Pattern.compile("\\G\\s+");
	public static final Pattern IDENTIFIER = Pattern.compile("\\G[a-zA-Z_$][a-zA-Z_$0-9]*");
	public static final Pattern ENDSTATEMENT = Pattern.compile("\\G;");
	public static final Pattern OPERATOR = Pattern.compile("\\G=");
	public static final Pattern DECLITERAL = Pattern.compile("\\G[0-9]*\\.[0-9]+");
	public static final Pattern INTLITERAL = Pattern.compile("\\G[0-9]+");
	public static final Pattern STRLITERAL = Pattern.compile("\\G\"([^\"\\\\]|\\\\.)*\"");
	public static final Pattern CHARLITERAL = Pattern.compile("\\G'.'");
	public static final Pattern DOT = Pattern.compile("\\G\\.");
	public static final Pattern SCOPEBEGIN = Pattern.compile("\\G\\{");
	public static final Pattern SCOPEEND = Pattern.compile("\\G\\}");
	

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
			if (checkForAndAppendToken(programScanner, KEYWORD, tokens, Token.Type.KEYWORD)) continue;
			if (checkForAndAppendToken(programScanner, IDENTIFIER, tokens, Token.Type.IDENTIFIER)) continue;
			if (checkForAndAppendToken(programScanner, ENDSTATEMENT, tokens, Token.Type.ENDSTATEMENT)) continue;
			if (checkForAndAppendToken(programScanner, OPERATOR, tokens, Token.Type.OPERATOR)) continue;
			if (checkForAndAppendToken(programScanner, DECLITERAL, tokens, Token.Type.DECLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, INTLITERAL, tokens, Token.Type.INTLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, STRLITERAL, tokens, Token.Type.STRLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, CHARLITERAL, tokens, Token.Type.CHARLITERAL)) continue;
			if (checkForAndAppendToken(programScanner, DOT, tokens, Token.Type.DOT)) continue;
			if (checkForAndAppendToken(programScanner, SCOPEBEGIN, tokens, Token.Type.SCOPEBEGIN)) continue;
			if (checkForAndAppendToken(programScanner, SCOPEEND, tokens, Token.Type.SCOPEEND)) continue;
			throw new IllegalStateException("failed to match any token!");
		}
		
		return tokens;
		
	}
	
	private static boolean checkForAndAppendToken(Scanner scan, Pattern match, List<Token> tokens, Token.Type type) {
		//Optimise with ternary operator
		String str;
		if ((str = scan.findWithinHorizon(match, 0)) != null) {
			tokens.add(new Token(type, str));
			return true;
		}
		return false;
	}

}
