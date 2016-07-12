/**
 * 
 */
package sapient.excercise.mscs.smartcard;

import sapient.excercise.mscs.constants.CardStatus;
import sapient.excercise.mscs.station.Station;

/**
 * @author neha.vari
 *
 */
public class SmartCardAttributes {
	private float balance;
	private Station source_station;
	private Station destination_station;
	private CardStatus status;
	private float fare;
	/**
	 * @return the fare
	 */
	public float getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(float fare) {
		this.fare = fare;
	}
	/**
	 * @return the status
	 */
	public CardStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(CardStatus status) {
		this.status = status;
	}
	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}
	/**
	 * @param balance2 the balance to set
	 */
	public void setBalance(float balance2) {
		this.balance = balance2;
	}
	/**
	 * @return the source_station
	 */
	public Station getSource_station() {
		return source_station;
	}
	/**
	 * @param source_station the source_station to set
	 */
	public void setSource_station(Station source_station) {
		this.source_station = source_station;
	}
	/**
	 * @return the destination_station
	 */
	public Station getDestination_station() {
		return destination_station;
	}
	/**
	 * @param destination_station the destination_station to set
	 */
	public void setDestination_station(Station destination_station) {
		this.destination_station = destination_station;
	}	
	
}


