package kjavac.syntax.variables;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class LocalVariableTable implements Iterable<LocalVariableTable.Variable> {

	private TreeSet<Variable> lvt;
	
	public LocalVariableTable() {
		lvt = new TreeSet<Variable>();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public Variable get(String name) {
		for (Variable v : lvt) {
			if (v.equals(name)) return v;
		}
		return null;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean contains(String name) {
		return lvt.contains(name);
	}
	
	public void add(String name, int size) {
		int offset = lvt.last().offset + size;
		lvt.add(new Variable(name, size, offset));
	}
	
	public final record Variable(String name, int size, int offset) implements Comparable<Variable> {

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (obj instanceof String s)
				return s.equals(name);
			if (getClass() != obj.getClass())
				return false;
			Variable other = (Variable) obj;
			return Objects.equals(name, other.name);
		}

		@Override
		public int compareTo(Variable o) {
			return this.offset - o.offset;
		}

	}

	@Override
	public Iterator<LocalVariableTable.Variable> iterator() {
		return lvt.iterator();
	}

}
