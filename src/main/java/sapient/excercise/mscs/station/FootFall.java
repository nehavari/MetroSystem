/**
 * 
 */
package sapient.excercise.mscs.station;

import java.util.HashMap;

import sapient.excercise.mscs.constants.MSCSConstants;

/**
 * @author neha.vari
 *
 */
public class FootFall {
	private static HashMap<Station, Integer> FOOT_FALL;

	public FootFall(){
		FOOT_FALL = new HashMap<Station, Integer>(MSCSConstants.MAX_STATION_NO);
	}

	public void addFootFall(Station station){
		if(FOOT_FALL.get(station) == null){
			FOOT_FALL.put(station, 1);
		}else{
			int fall = FOOT_FALL.get(station);			
			FOOT_FALL.put(station, ++fall);
		}
	}

	public int getFootFall(Station station){
		if(FOOT_FALL!= null){
			if(FOOT_FALL.get(station) != null){
				return FOOT_FALL.get(station);
			}
		}
		return 0;
	}
}
