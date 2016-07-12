/**
 * 
 */
package sapient.excercise.mscs.exception;

import sapient.excercise.mscs.constants.MSCSConstants;

/**
 * @author neha.vari
 *
 */
public class CardStatusNOTValidException extends MSCSEXception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019965615073048408L;

	public CardStatusNOTValidException() {
		super(MSCSConstants.CARD_STATUS_NOT_VALID);
		// TODO Auto-generated constructor stub
	}

}
