package kjavac.syntax.type;

public enum BuiltinType implements Type {
	CHAR(1, "char"),
	BOOLEAN(1, "boolean"),
	BYTE(1, "byte"),
	SHORT(2, "short"),
	INT(4, "int"),
	LONG(8, "long"),
	LONG_LONG(16, "longlong"),
	FLOAT(4, "float"),
	DOUBLE(8, "double"),
	U8(1, "u8"),
	U16(2, "u16"),
	U32(4, "u32"),
	U64(8, "u64"),
	U128(16, "u128"),
	I8(1, "i8"),
	I16(2, "i16"),
	I32(4, "i32"),
	I64(8, "i64"),
	I128(16, "i128"),
	F32(4, "f32"),
	F64(8, "f64"),
	VOID_STAR(Type.PointerSize, "&void"),
	RAW_PTR(Type.PointerSize, "raw_pointer"),
	VOID(0, "void");
	
	
	int size;
	String name;
	
	BuiltinType(int size, String name) {
		this.size = size;
		this.name = name;
	}
	
	@Override
	public int sizeof() {
		return size;
	}
	
	public static BuiltinType byName(String name) {
		for (BuiltinType t : BuiltinType.values()) {
			if (t.name.equals(name)) return t;
		}
		return null;
	}

	@Override
	public boolean equals(Type t) {
		return t instanceof BuiltinType b && (this == b /* TODO alias types*/);
	}
	
}
