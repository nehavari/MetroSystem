/**
 * 
 */
package sapient.excercise.mscs.exception;

import sapient.excercise.mscs.constants.MSCSConstants;

/**
 * @author neha.vari
 *
 */
public class BelowMinBalException extends MSCSEXception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6459746078579944159L;

	public BelowMinBalException(String message) {
		super(" " +message + MSCSConstants.BALANCE_MINIMUM_MSG );
		// TODO Auto-generated constructor stub
	}

}
