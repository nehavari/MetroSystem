/**
 * 
 */
package sapient.excercise.mscs.fare;

/**
 * @author neha.vari
 *
 */
public class WeekendFareRule implements IFareRule {
	
	private static final float FARE =(float)5.5;

	/* (non-Javadoc)
	 * @see com.sap.mscs.rule.IFareRule#applyCharges(int)
	 */
	public float applyCharges(int noStationTravelled) {
		return (float)noStationTravelled * FARE; 
	}

}
