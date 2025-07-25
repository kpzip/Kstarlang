/**
 * 
 */
package kjavac.bytecode;

/**
 * 
 * @author kpzip
 * 
 */
public record AccessFlags(boolean is_public, boolean is_protected, boolean is_private, boolean is_static, boolean is_final, boolean is_open, boolean bridge_static_phase, boolean varargs_transient, boolean is_native, boolean has_super, boolean is_interface, boolean is_abstract, boolean is_strict, boolean is_synthetic, boolean is_annotation, boolean is_enum, boolean mandated_module) {
	
	public AccessFlags() {
		this(true, false, false, false, true, false, false, false, false, false, false, false, false, true, false, false, false);
	}
	
	public short serialize() {
		short ret = 0x0000;
		ret |= is_public ? 0x0001 : 0;
		ret |= is_private ? 0x0002 : 0;
		ret |= is_protected ? 0x0004 : 0;
		ret |= is_static ? 0x0008 : 0;
		ret |= is_final ? 0x0010 : 0;
		ret |= is_open ? 0x0020 : 0;
		ret |= bridge_static_phase ? 0x0040 : 0;
		ret |= varargs_transient ? 0x0080 : 0;
		ret |= is_native ? 0x0100 : 0;
		ret |= is_interface ? 0x0200 : 0;
		ret |= is_abstract ? 0x0400 : 0;
		ret |= is_strict ? 0x0800 : 0;
		ret |= is_synthetic ? 0x1000 : 0;
		ret |= is_annotation ? 0x2000 : 0;
		ret |= is_enum ? 0x4000 : 0;
		ret |= mandated_module ? 0x8000 : 0;
		return ret;
	}
	

}
