package kjavac.syntax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kjavac.syntax.SyntaxTree.SyntaxTreeNode;
import kjavac.syntax.statements.Statement;

public class FunctionDefinition implements SyntaxTreeNode { 

	
	private List<Statement> body;
	
	private byte flags;
	
	public FunctionDefinition() {
		body = new ArrayList<Statement>();
		flags = (byte) 0xFF;
	}
	
	

	@Override
	public Collection<? extends SyntaxTreeNode> getChildren() {
		return body;
	}
	
	public byte getFlags() {
		return flags;
	}

}
