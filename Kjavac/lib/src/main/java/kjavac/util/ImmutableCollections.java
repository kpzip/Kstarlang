package kjavac.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class ImmutableCollections {

	private ImmutableCollections() {}
	
	@SafeVarargs
	public static <E> Collection<E> of(final E... elements) {
		return new Collection<E>() {

			@Override
			public int size() {
				return elements.length;
			}

			@Override
			public boolean isEmpty() {
				return elements.length == 0;
			}

			@Override
			public boolean contains(Object o) {
				for (E e : elements) {
					if (e.equals(o)) return true;
				}
				return false;
			}

			@Override
			public Iterator<E> iterator() {
				return new Iterator<E>() {
					
					private int pointer = 0;

					@Override
					public boolean hasNext() {
						return pointer < elements.length;
					}

					@Override
					public E next() {
						return elements[pointer++];
					}
					
				};
			}

			@Override
			public Object[] toArray() {
				return Arrays.copyOf(elements, elements.length);
			}

			@SuppressWarnings("unchecked")
			@Override
			public <T> T[] toArray(T[] a) {
				if (a.length < elements.length) return (T[]) Arrays.copyOf(elements, elements.length, a.getClass());
		        System.arraycopy(elements, 0, a, 0, elements.length);
		        if (a.length > elements.length) a[elements.length] = null;
		        return a;
			}

			@Override
			public boolean add(E e) {
				throw new UnsupportedOperationException("Immutable Collection!");
			}

			@Override
			public boolean remove(Object o) {
				throw new UnsupportedOperationException("Immutable Collection!");
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				for (Object o : c) {
					if (!contains(o)) return false;
				}
				return true;
			}

			@Override
			public boolean addAll(Collection<? extends E> c) {
				throw new UnsupportedOperationException("Immutable Collection!");
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				throw new UnsupportedOperationException("Immutable Collection!");
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				throw new UnsupportedOperationException("Immutable Collection!");
			}

			@Override
			public void clear() {
				throw new UnsupportedOperationException("Immutable Collection!");
			}
			
		};
	}

}
