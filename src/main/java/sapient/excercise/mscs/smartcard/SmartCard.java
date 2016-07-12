/**
 * 
 */
package sapient.excercise.mscs.smartcard;

/**
 * @author neha.vari
 * This is immutable class , meant to be used as key of hashmap
 * More attributes can be added to this class like city , type of card 
 */
public class SmartCard {

	private String smartId;	

	public SmartCard(String smartId){
		this.smartId = smartId;
	}
	
	/**
	 * @param smartId the smartId to set
	 */
	public String getSmartId() {
		return this.smartId;		
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj){	
		if (obj!= null && obj instanceof SmartCard){	
			if(this.smartId.equals(((SmartCard)obj).getSmartId())){
				return true;
			}
		}		
		return false;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode(){
		char[] tokens = smartId.toCharArray();
		int hashCode=0;
		for(int i =0; i<tokens.length; i++){
			hashCode += tokens[i]*(i+1);
		}
		return hashCode;
	}
}
