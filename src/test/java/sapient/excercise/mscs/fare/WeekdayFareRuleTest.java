/**
 * 
 */
package sapient.excercise.mscs.fare;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author neha.vari
 *
 */
public class WeekdayFareRuleTest {
	
	private static WeekdayFareRule wfr;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		wfr = new WeekdayFareRule();
	}

	
	/**
	 * Test method for {@link sapient.excercise.mscs.fare.WeekdayFareRule#applyCharges(int)}.
	 */
	@Test
	public final void testApplyCharges() {
		assertEquals(42, wfr.applyCharges(6), 0.0 );		
	}
	
	@Test
	public final void testApplyCharges1() {
		assertEquals(35, wfr.applyCharges(5), 0.0 );		
	}

}
