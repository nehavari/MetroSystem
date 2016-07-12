/**
 * 
 */
package sapient.excercise.mscs.fare;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sapient.excercise.mscs.station.Station;


/**
 * @author neha.vari
 *
 */
public class FareCalcManagerTestWeekday {
	
	private static FareCalcManager fcm;	
	private Station s1;
	private Station s2;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String s = "weekday";
		fcm = FareCalcManager.getFareCalcManager(s);		
	}

	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {		
		s1 = new Station("A1");
		s2 = new Station("A8");		
	}


	/**
	 * Test method for {@link sapient.excercise.mscs.fare.FareCalcManager#calculateFare(sapient.excercise.mscs.station.Station, sapient.excercise.mscs.station.Station)}.
	 */	
	@Test
	public final void testCalculateFare() {
		assertEquals(49, fcm.calculateFare(s1, s2), 0.0);		
	}

}
