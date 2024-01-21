package kjavac.syntax;

import java.util.Collection;

import javax.annotation.Nullable;

public class SyntaxTree {

	public SyntaxTree() {
		// TODO Auto-generated constructor stub
	}
	
	public interface SyntaxTreeNode {
		
		@Nullable
		Collection<? extends SyntaxTreeNode> getChildren();
		
	}
	
}
