package kjavac.syntax;

import java.util.ArrayList;
import java.util.List;

import kjavac.components.Lexer.TokenType;
import kjavac.syntax.type.BuiltinType;
import kjavac.syntax.type.Type;

public class SyntaxTree {
	
	private List<FunctionDefinition> functions;

	public SyntaxTree() {
		functions = new ArrayList<FunctionDefinition>();
	}
	
	public void populate(List<Token> tokens) throws Throwable {
		int index = 0;
		while (index < tokens.size()) {
			
			Token currToken = tokens.get(index);
			TokenType currType = currToken.getType();
			
			if (!(currType == TokenType.KEYWORD || currType == TokenType.IDENTIFIER)) {
				throw new Exception("To Declare a function, start by declaring its return type");
			}
			
			Type returnType = null;
			
			if (currType == TokenType.KEYWORD) {
				returnType = BuiltinType.byName(currToken.getValue());
				if (returnType == null) throw new Exception("To Declare a function, start by declaring its return type");
			}
			else {
				//TODO custom return types
			}
			
			index++;
			currToken = tokens.get(index);
			currType = currToken.getType();
			if (!(currType == TokenType.IDENTIFIER)) {
				throw new Exception("Must declare a valid function name");
			}
			
			String functionName = currToken.getValue();
			
			index++;
			currToken = tokens.get(index);
			currType = currToken.getType();
			if (!(currType == TokenType.EXPRBEGIN)) {
				throw new Exception("Must have an open parenthesis to declare function arguments");
			}
			//TODO function Args
			index++;
			currToken = tokens.get(index);
			currType = currToken.getType();
			if (!(currType == TokenType.EXPREND)) {
				throw new Exception("Must have an close parenthesis to finish declaring function arguments");
			}
			
			index++;
			currToken = tokens.get(index);
			currType = currToken.getType();
			if (!(currType == TokenType.SCOPEBEGIN)) {
				throw new Exception("This function must have a body");
			}
			
			FunctionDefinition currFunction = new FunctionDefinition(returnType, functionName);
			functions.add(currFunction);
			
			//TODO statement pattern matching
			
			int scopedepth = 0;
			//doesn't include beginning curly brace
			int statementsbegin = ++index;
			for (;scopedepth < 0;index++) {
				if (index >= tokens.size()) throw new Exception("Must close scope block!");
				currToken = tokens.get(index);
				currType = currToken.getType();
				if (currType == TokenType.SCOPEBEGIN) {
					scopedepth++;
					continue;
				}
				if (currType == TokenType.SCOPEEND) {
					scopedepth--;
					continue;
				}
			}
			
			//incudes end curly brace
			int statementsend = index - 1;
			
			if (statementsbegin != statementsend) currFunction.populate(tokens.subList(statementsbegin, statementsend)); else currFunction.populate(new ArrayList<Token>());
			
		}
	}
	
	
	
}
