package kjavac.util;

import java.util.Collection;

public interface Tree<E> extends Collection<E> {
	
	E root();
	
	Tree<E> subtree(E element);
	
	Collection<E> children(E element);
	
	boolean isLeaf();
	
	int height();

}
