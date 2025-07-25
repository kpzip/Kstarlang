/**
 * 
 */
package kjavac.bytecode.constantpool;

import com.google.common.base.Charsets;

/**
 * 
 * @author kpzip
 * 
 */
public class UTF8String implements ConstantPoolElement {
	
	public static final byte TAG_BYTE = 1;
	
	private String inner;

	/**
	 * 
	 */
	public UTF8String(String element) {
		this.inner = element;
	}
	
	public byte[] serialize() {
		byte[] str_bytes = this.inner.getBytes(Charsets.UTF_8);
		byte[] ret = new byte[str_bytes.length + 3];
		for (int i = 0; i < str_bytes.length; i++) {
			ret[i + 3] = str_bytes[i];
		}
		ret[0] = TAG_BYTE;
		ret[1] = (byte) (str_bytes.length >> 8);
		ret[2] = (byte) str_bytes.length;
		return ret;
	}

}
