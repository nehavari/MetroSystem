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
public class WeekendFareRuleTest {
	
	private static WeekendFareRule wfr;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		wfr = new WeekendFareRule();
	}

	/**
	 * Test method for {@link sapient.excercise.mscs.fare.WeekendFareRule#applyCharges(int)}.
	 */
	@Test
	public final void testApplyCharges() {
		assertEquals(27.5, wfr.applyCharges(5), 0.0);
	 
	}
	
	@Test
	public final void testApplyCharges1() {
		assertEquals(22, wfr.applyCharges(4), 0.0);
	 
	}

}
