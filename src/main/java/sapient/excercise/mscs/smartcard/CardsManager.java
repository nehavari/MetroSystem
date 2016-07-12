/**
 * 
 */
package sapient.excercise.mscs.smartcard;

import java.util.HashMap;
import java.util.Map;

import sapient.excercise.mscs.constants.CardStatus;
import sapient.excercise.mscs.constants.MSCSConstants;
import sapient.excercise.mscs.exception.BelowMinBalException;
import sapient.excercise.mscs.exception.CardStatusNOTValidException;
import sapient.excercise.mscs.exception.MSCSEXception;
import sapient.excercise.mscs.fare.FareCalcManager;
import sapient.excercise.mscs.station.FootFall;
import sapient.excercise.mscs.station.Station;

/**
 * @author neha.vari
 *
 */
public class CardsManager {
	private Map<SmartCard, SmartCardAttributes> cardsMapping;


	private static CardsManager cardsManager;
	private FareCalcManager fareCalcManager;
	private FootFall footfall;

	/**
	 * @return the footfall
	 */
	public FootFall getFootfall() {
		return footfall;
	}

	private CardsManager(FareCalcManager fareCalcManager){
		this.cardsMapping = new HashMap<SmartCard, SmartCardAttributes>();
		this.fareCalcManager = fareCalcManager;
		this.footfall = new FootFall();

	}

	public static CardsManager getSmartCardManager(FareCalcManager fareCalcManager){
		if(cardsManager == null){
			cardsManager = new CardsManager(fareCalcManager);
		}
		return cardsManager;
	}
	/**
	 * 
	 * @param card
	 * @param station
	 * @throws MSCSEXception 
	 */
	public void swipeOut(SmartCard card, Station station) throws MSCSEXception{
		if(cardsMapping.get(card) != null){
			SmartCardAttributes scAttr = cardsMapping.get(card);
			if(scAttr.getStatus() != CardStatus.IN){
				throw new CardStatusNOTValidException(); 
			}
			scAttr.setDestination_station(station);	
			scAttr.setStatus(CardStatus.OUT);	
			scAttr.setFare(fareCalcManager.calculateFare(scAttr.getSource_station(), scAttr.getDestination_station()));
			scAttr.setBalance(scAttr.getBalance() - scAttr.getFare());			
			footfall.addFootFall(station);		
		}else{
			throw new MSCSEXception(MSCSConstants.CARD_NOT_REGISTERED);
		}
	}
	/**
	 * 
	 * @param card
	 * @param station
	 * @throws MSCSEXception 
	 */
	public void swipeIn(SmartCard card, Station station) throws MSCSEXception{	
		if(cardsMapping.get(card) != null){
			SmartCardAttributes scAttr = cardsMapping.get(card);
			if(scAttr.getBalance() < MSCSConstants.MIN_BALANCE){
				throw new BelowMinBalException(MSCSConstants.MIN_BALANCE+" ");
			}
			scAttr.setSource_station(station);
			scAttr.setStatus(CardStatus.IN);	
			footfall.addFootFall(station);	
		}else{
			throw new MSCSEXception(MSCSConstants.CARD_NOT_REGISTERED);
		}
	}
	/**
	 * 
	 * @param id
	 * @param balance
	 * @return
	 * @throws BelowMinBalException
	 */
	public String registerNewCard(String id, float balance) throws BelowMinBalException{
		SmartCard sCard = new SmartCard(id);
		if(cardsMapping.get(sCard) == null){		
			cardsMapping.put(sCard, intitalAttributes(balance));
			return MSCSConstants.CARD_REGISTERED_MSG;
		}else 
			return MSCSConstants.CARD_EXIST_MSG;
	}
	/**
	 * 
	 * @param balance
	 * @return
	 * @throws BelowMinBalException
	 */
	private SmartCardAttributes intitalAttributes(float balance) throws BelowMinBalException{
		SmartCardAttributes sAttr = new SmartCardAttributes();
		if(balance < MSCSConstants.MIN_BALANCE){
			throw new BelowMinBalException(MSCSConstants.MIN_BALANCE+" ");
		}
		sAttr.setBalance(balance);
		sAttr.setStatus(CardStatus.VOID);
		return sAttr;

	}

	/**
	 * @return the cardsMapping
	 * @throws MSCSEXception 
	 */
	public SmartCardAttributes getCardsAttributes(SmartCard card) throws MSCSEXception {
		if( cardsMapping.get(card) ==null){
			throw new MSCSEXception(MSCSConstants.CARD_NOT_REGISTERED); 
		}else{
			return cardsMapping.get(card);
		}
	}
}
