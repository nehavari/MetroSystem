/**
 * 
 */
package sapient.excercise.mscs.exception;

/**
 * @author neha.vari
 *
 */
public class NoFootFallException extends MSCSEXception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2369937337199391618L;

	public NoFootFallException(String stationName) {
		super("Foot Fall count not found for station \"" + stationName +"\"");	
	}

}
