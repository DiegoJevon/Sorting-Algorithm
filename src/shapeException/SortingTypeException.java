package shapeException;

public class SortingTypeException extends Exception {
	
	/**Exception must be thrown when the sort type is not part of the predefined list.
	 * @version June 09, 2022
	 */
	private static final long serialVersionUID = 1L;
	
	/**Constructor must be called to thrown the exception.
	 * 
	 * @param message Error message must  be presented.
	 */
	public SortingTypeException (String message) {
		System.err.println(message);
		System.exit(0);
	}
}
