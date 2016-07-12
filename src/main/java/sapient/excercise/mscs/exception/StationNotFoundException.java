/**
 * 
 */
package sapient.excercise.mscs.exception;

/**
 * @author neha.vari
 *
 */
public class StationNotFoundException extends MSCSEXception {

	public StationNotFoundException(String stationName) {
		super("Entered station name \"" + stationName + "\" not found");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3953411311923004357L;

}
