/**
 * 
 */
package sapient.excercise.mscs.station;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sapient.excercise.mscs.constants.MSCSConstants;
import sapient.excercise.mscs.exception.StationNotFoundException;

/**
 * @author neha.vari
 * Immutable class, will be used as hash map key 
 */
public class Station {
	private String stationId;

	public Station(String stationId) throws StationNotFoundException {
		validateID(stationId);
		this.stationId = stationId;
	}
	/**
	 * @return the id
	 */
	public String getStationId() {
		return stationId;
	}	
	/**
	 * validates id
	 * @param id
	 * @throws StationNotFoundException
	 */
	private void validateID(String id) throws StationNotFoundException {		
		Pattern pattern = Pattern.compile(MSCSConstants.PATTERN);
		Matcher matcher = pattern.matcher(id);
		if(!matcher.matches()){
			throw new StationNotFoundException(id);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj){
		Station smartCard = null;
		if (obj instanceof Station){
			smartCard = (Station) obj;
		}
		if(this.stationId.equalsIgnoreCase(smartCard.getStationId())){
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode(){
		char[] tokens = stationId.toCharArray();
		int hashCode=0;
		for(int i =0; i<tokens.length; i++){
			hashCode += tokens[i]*i;
		}
		return hashCode;
	}
	
}
