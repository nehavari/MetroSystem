/**
 * 
 */
package sapient.excercise.mscs.fare;

/**
 * @author neha.vari
 *
 */
public class WeekdayFareRule implements IFareRule {
	
	private static final float FARE = 7;

	/* (non-Javadoc)
	 * @see com.sap.mscs.rule.IFareRule#applyCharges(int)
	 */
	public float applyCharges(int noStationTravelled) {
		return (float)noStationTravelled * FARE; 
			
	}

}
