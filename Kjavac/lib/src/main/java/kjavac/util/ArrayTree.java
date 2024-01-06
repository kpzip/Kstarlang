package kjavac.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArrayTree<E> implements Tree<E> {
	
	private E data;
	private ArrayList<ArrayTree<E>> children;

	public ArrayTree(E data) {
		this.data = data;
		children = new ArrayList<ArrayTree<E>>();
	}

	@Override
	public int size() {
		return children.isEmpty() ? (data == null ? 0 : 1) : children.stream().mapToInt((t) -> t.size()).sum() + 1;
	}

	@Override
	public boolean isEmpty() {
		return data == null && children.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return data.equals(o) || children.stream().map((c) -> c.contains(o)).anyMatch((b) -> b);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		return children.add(new ArrayTree<E>(e));
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E root() {
		return data;
	}

	@Override
	public Tree<E> subtree(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<E> children(E element) {
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

}
