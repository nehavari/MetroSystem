/**
 * 
 */
package sapient.excercise.mscs.fare;

import sapient.excercise.mscs.constants.MSCSConstants;
import sapient.excercise.mscs.exception.MSCSEXception;
import sapient.excercise.mscs.station.Station;

/**
 * @author neha.vari
 *
 */
public class FareCalcManager {
	
	private IFareRule rule ;
	
	private static FareCalcManager fareCalcManager;
	
	private FareCalcManager(String day) throws MSCSEXception{
		if(day.equalsIgnoreCase(MSCSConstants.WEEKDAY)){
			rule = new WeekdayFareRule();
		}else if(day.equalsIgnoreCase(MSCSConstants.WEEKEND)){
			rule = new WeekendFareRule();
		}else {
			throw new MSCSEXception(MSCSConstants.INVALID_INPUT);
		}
	}
	
	public static FareCalcManager getFareCalcManager(String day) throws MSCSEXception{
		if(fareCalcManager == null){
			fareCalcManager = new FareCalcManager(day);
		}
		return fareCalcManager;
	}
	
	/**
	 * 	
	 * @param swipeInStation
	 * @param swipeOutStation
	 * @return
	 */
	public float calculateFare(Station swipeInStation, Station swipeOutStation){
		float fare = 0.0f;
		int noOfstation = 0;
		if(swipeInStation.equals(swipeOutStation)){			
			return fare;
		}else{
			noOfstation = (Integer.valueOf(swipeOutStation.getStationId().substring(1)) - Integer.valueOf(swipeInStation.getStationId().substring(1)) );
		}
		if(noOfstation < 0 ){
			noOfstation = noOfstation * MSCSConstants.NEGATIVE_ONE;
		}
		fare = rule.applyCharges(noOfstation);
		return fare;
	}
}
