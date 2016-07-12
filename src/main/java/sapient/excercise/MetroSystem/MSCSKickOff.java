/**
 * 
 */
package sapient.excercise.MetroSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sapient.excercise.mscs.exception.BelowMinBalException;
import sapient.excercise.mscs.exception.MSCSEXception;
import sapient.excercise.mscs.exception.StationNotFoundException;
import sapient.excercise.mscs.fare.FareCalcManager;
import sapient.excercise.mscs.smartcard.CardsManager;
import sapient.excercise.mscs.smartcard.SmartCard;
import sapient.excercise.mscs.smartcard.SmartCardAttributes;
import sapient.excercise.mscs.station.Station;

/**
 * @author neha.vari
 *
 */
public class MSCSKickOff {

	private static FareCalcManager fcm;
	private static CardsManager cm;

	private static void intialize() throws MSCSEXception, IOException{
		System.out.println("\t\t-----------------------------Welcome to MSCS-------------------------\n");	
		System.out.println("\t\t Intitate application with weekday/weekend. Enter \"weekday\" or \"weekend\"  ==");	
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String s = bufferRead.readLine();	
		fcm = FareCalcManager.getFareCalcManager(s);
		cm = CardsManager.getSmartCardManager(fcm);
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MSCSEXception 
	 */
	public static void main(String[] args) throws IOException  {
		try {
			intialize();
		} catch (MSCSEXception e1) {
			System.out.println(" Unable to intialize the Metro Smart Card System ");
		}
		menuBuildingAndServing();
	}

	/**
	 * @throws IOException
	 */
	private static void menuBuildingAndServing() throws IOException  {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));		
		while(true){
			System.out.println("\n\t\t How can we Serve You? Please enter 1 or 2 or 3 or 4 or 5.");		
			System.out.println("\n1. Register new Smart Card");		
			System.out.println("\n2. Swipe IN ");	
			System.out.println("\n3. Swipe OUT ");	
			System.out.println("\n4. Get Foot Fall  ");	
			System.out.println("\n5. Per Card Report ");
			Integer i = null;
			try{
				i = Integer.valueOf(bufferRead.readLine());
			}catch(NumberFormatException e){
				System.out.println(" Invalid Input , Please Re-enter");
			}
			switch(i){
			case 1:
			{				
				try {
					registerNewCard(bufferRead);
				} catch (NumberFormatException e1) {
					System.out.println("Balance entered is in wrong format (correct == float or int)");
					break;
				} catch (BelowMinBalException e1) {
					System.out.println(e1.getMessage());
					break;
				}
				break;
			}
			case 2:
			{
				try {
					swipeIN(bufferRead);
				} catch (MSCSEXception e) {
					System.out.println(e.getMessage());					
				}
				break;
			}
			case 3:
			{						
				try {
					swipeOUT(bufferRead);
				} catch (MSCSEXception e) {
					System.out.println(e.getMessage());					
				}
				break;
			}
			case 4:
				try {
					generateFootFall(bufferRead);
				} catch (StationNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}

				break;
			case 5:
			{				
				try {
					generateCardReport(bufferRead);
				} catch (MSCSEXception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			default:
				System.out.println("Wrong Entry, Please Re-Enter.");
			}
		}
	}

	/**
	 * @param bufferRead
	 * @throws IOException
	 * @throws StationNotFoundException
	 * @throws MSCSEXception
	 */
	private static void swipeOUT(BufferedReader bufferRead) throws IOException,
	StationNotFoundException, MSCSEXception {
		String s;
		System.out.println(" You are swipping OUT");
		System.out.println("Enter Smart Card ID == ");
		s = bufferRead.readLine();			
		SmartCard sc = new SmartCard(s);

		System.out.println("Enter Station (A1,A2,A3,A4,A5,A6,A7,A8,A9,A10)== ");
		s = bufferRead.readLine();		
		Station station = new Station(s);	
		cm.swipeOut(sc, station);
	}

	/**
	 * @param bufferRead
	 * @throws IOException
	 * @throws StationNotFoundException
	 * @throws MSCSEXception
	 */
	private static void swipeIN(BufferedReader bufferRead) throws IOException,
	StationNotFoundException, MSCSEXception {
		String s;
		System.out.println(" You are swipping IN");
		System.out.println("Enter Smart Card ID == ");
		s = bufferRead.readLine();	
		SmartCard sc = new SmartCard(s);
		System.out.println("Enter Station  (A1,A2,A3,A4,A5,A6,A7,A8,A9,A10)== ");
		s = bufferRead.readLine();		
		Station station = new Station(s);				
		cm.swipeIn(sc, station);
	}

	/**
	 * @param bufferRead
	 * @throws IOException
	 * @throws MSCSEXception
	 */
	private static void generateCardReport(BufferedReader bufferRead)
			throws IOException, MSCSEXception {
		String s;
		System.out.println("\n***** Card Report ******");	
		System.out.println("Enter Smart Card ID == ");
		s = bufferRead.readLine();	
		SmartCard sc = new SmartCard(s);
		SmartCardAttributes sca = cm.getCardsAttributes(sc);
		/*Card <number> used to travel from station <source_station> to station
<destination_station>. Fare is Rs <x> and balance on the card is <Rs x>*/
		if( sca.getSource_station() != null && sca.getDestination_station() != null){
			System.out.println("\t\t Card " +sc.getSmartId()+ " used to travel from station " + sca.getSource_station().getStationId()+
					" to station "+ sca.getDestination_station().getStationId() +" ." + " Fare is Rs " + sca.getFare() + " and balance on the card is Rs. " + sca.getBalance());
		}else{
			System.out.println(" No source or destination station for Smart Card " + sc.getSmartId());
		}
	}

	/**
	 * @param bufferRead
	 * @throws IOException
	 * @throws StationNotFoundException
	 */
	private static void generateFootFall(BufferedReader bufferRead)
			throws IOException, StationNotFoundException {
		String s;
		System.out.println("\n***** Foot Fall  ******");	
		System.out.println("Stations List == A1, A2, A3, A4, A5, A6, A7, A8, A9, A10" );	
		System.out.println("Enter Station ID == ");
		s = bufferRead.readLine();	
		Station station = new Station(s);
		System.out.println("Foot Fall for station " + station.getStationId() + " is " +cm.getFootfall().getFootFall(station));
	}

	/**
	 * @param bufferRead
	 * @throws IOException
	 * @throws BelowMinBalException
	 */
	private static void registerNewCard(BufferedReader bufferRead)
			throws IOException, BelowMinBalException {
		String s;
		System.out.println(" You have choosen to register new card ");
		System.out.println("Enter Smart Card ID == ");
		s = bufferRead.readLine();	
		System.out.println("Enter Intial Balance == ");
		String balance = bufferRead.readLine();	
		cm.registerNewCard(s,Float.valueOf(balance));
	}

}
