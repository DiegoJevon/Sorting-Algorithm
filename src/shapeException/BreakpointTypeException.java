package shapeException;

public class BreakpointTypeException extends Exception {
	
	/**Exception must be thrown when the breakpoint is not part of the predefined list.
	 * @version June 09, 2022
	 */
	private static final long serialVersionUID = 1L;
	
	/**Constructor must be called to thrown the exception.
	 * 
	 * @param message Error message must  be presented.
	 */
	public BreakpointTypeException (String message) {
		System.err.print(message);
		System.exit(0);
	}
}
