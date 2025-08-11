/**
 * 
 */
package kjavac.bytecode.constantpool;

import java.util.ArrayList;

import kjavac.ast.Identifier;
import kjavac.ast.type.DefinedType;

/**
 * 
 * @author kpzip
 * 
 */
public class ConstantPool {

	private ArrayList<String> strings;
	private ArrayList<DefinedType> class_references;
	private ArrayList<FieldReference> field_reference;
	private ArrayList<MethodReference> method_references;
	private ArrayList<MethodReference> interface_method_references;
	private ArrayList<TypedName> name_and_type_descriptors;
	private ArrayList<MethodHandle> method_handles;
	private ArrayList<MethodType> method_types;
	private ArrayList<Dynamic> dynamics; // ???
	private ArrayList<InvokeDynamic> invoke_dynamics;
	private ArrayList<Module> modules;
	private ArrayList<Package> packages;
	private ArrayList<Integer> ints;
	private ArrayList<Long> longs;
	private ArrayList<Float> floats;
	private ArrayList<Double> doubles;
	
	
	/**
	 * 
	 */
	public ConstantPool() {
		this.strings = new ArrayList<String>();
		this.class_references = new ArrayList<DefinedType>();
		this.field_reference = new ArrayList<FieldReference>();
		this.method_references = new ArrayList<MethodReference>();
		this.interface_method_references = new ArrayList<MethodReference>();
		this.name_and_type_descriptors = new ArrayList<TypedName>();
		this.method_handles = new ArrayList<MethodHandle>();
		this.method_types = new ArrayList<MethodType>();
		this.dynamics = new ArrayList<Dynamic>();
		this.invoke_dynamics = new ArrayList<InvokeDynamic>();
		this.modules = new ArrayList<Module>();
		this.packages = new ArrayList<Package>();
		this.ints = new ArrayList<Integer>();
		this.longs = new ArrayList<Long>();
		this.floats = new ArrayList<Float>();
		this.doubles = new ArrayList<Double>();
	}
	
	public void addClassRef(DefinedType t) {
		this.class_references.add(t);
	}

}
