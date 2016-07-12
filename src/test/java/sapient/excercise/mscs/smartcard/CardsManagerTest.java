/**
 * 
 */
package sapient.excercise.mscs.smartcard;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import sapient.excercise.mscs.constants.CardStatus;
import sapient.excercise.mscs.exception.BelowMinBalException;
import sapient.excercise.mscs.exception.MSCSEXception;
import sapient.excercise.mscs.exception.StationNotFoundException;
import sapient.excercise.mscs.fare.FareCalcManager;
import sapient.excercise.mscs.station.Station;

/**
 * @author neha.vari
 *
 */
public class CardsManagerTest {
	
	private static FareCalcManager fcm;
	private static CardsManager cm;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fcm = FareCalcManager.getFareCalcManager("weekday");
		cm = CardsManager.getSmartCardManager(fcm);
		testRegisterNewCard();
	}	

	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.CardsManager#getFootfall()}.
	 * @throws StationNotFoundException 
	 */
	@Test
	public final void testGetFootfall() throws StationNotFoundException {
		Station station = new Station("A1");
		assertEquals(0,cm.getFootfall().getFootFall(station));
		
	}

	

	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.CardsManager#swipeIn(sapient.excercise.mscs.smartcard.SmartCard, sapient.excercise.mscs.station.Station)}.
	 * @throws MSCSEXception 
	 */
	@Test
	public final void testSwipeIn() throws MSCSEXception {
		SmartCard sc = new SmartCard("345");
		Station station = new Station("A1");
		cm.swipeIn(sc, station);
		assertEquals(CardStatus.IN,cm.getCardsAttributes(sc).getStatus());	
	}
	
	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.CardsManager#swipeOut(sapient.excercise.mscs.smartcard.SmartCard, sapient.excercise.mscs.station.Station)}.
	 * @throws MSCSEXception 
	 */
	@Test
	public final void testSwipeOut() throws MSCSEXception {
		SmartCard sc = new SmartCard("345");
		Station station = new Station("A3");
		cm.swipeIn(sc, station);
		Station station1 = new Station("A1");
		cm.swipeOut(sc, station);
		cm.getCardsAttributes(sc);
		assertEquals(CardStatus.OUT,cm.getCardsAttributes(sc).getStatus());
	}

	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.CardsManager#registerNewCard(java.lang.String, float)}.
	 * @throws BelowMinBalException 
	 */
	
	public static final void testRegisterNewCard() throws BelowMinBalException {
		cm.registerNewCard("345", 80);
	}

}
