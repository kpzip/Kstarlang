/**
 * 
 */
package kjavac.error;

import kjavac.ast.ParsedFile;

/**
 * 
 * @author kpzip
 * 
 */
public abstract class CompilerError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8334511852130952663L;
	
	private String source_file_path;
	private int line_number;
	private int first_char;
	private int last_char;
	
	
	/**
	 * 
	 * @param source_file_path
	 * @param line_number
	 * @param first_char
	 * @param last_char
	 */
	public CompilerError(String source_file_path, int line_number, int first_char, int last_char) {
		super();
		this.source_file_path = source_file_path;
		this.line_number = line_number;
		this.first_char = first_char;
		this.last_char = last_char;
	}
	
	

}
