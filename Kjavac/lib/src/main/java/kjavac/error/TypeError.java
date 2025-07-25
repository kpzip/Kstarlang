/**
 * 
 */
package kjavac.error;

/**
 * 
 * @author kpzip
 * 
 */
public class TypeError extends CompilerError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6856741603098078847L;

	/**
	 * 
	 * @param source_file_path
	 * @param line_number
	 * @param first_char
	 * @param last_char
	 */
	public TypeError(String source_file_path, int line_number, int first_char, int last_char) {
		super(source_file_path, line_number, first_char, last_char);
	}

	

}
