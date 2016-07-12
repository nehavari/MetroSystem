/**
 * 
 */
package sapient.excercise.mscs.smartcard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author neha.vari
 *
 */
public class SmartCardTest  {



	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.SmartCard#hashCode()}.
	 */
	public final void testHashCode() {
		SmartCard sc1 = new SmartCard("456");
		SmartCard sc2 = new SmartCard("456");
		assertTrue(	sc1.hashCode() == sc2.hashCode());
	
		
	}

	
	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.SmartCard#getSmartId()}.
	 */
	@Test
	public final void testGetSmartId() {
		SmartCard sc = new SmartCard("456");
		assertEquals("456" ,sc.getSmartId());
	}

	/**
	 * Test method for {@link sapient.excercise.mscs.smartcard.SmartCard#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		SmartCard sc1 = new SmartCard("456");
		SmartCard sc2 = new SmartCard("456");
		assertTrue(sc1.equals(sc2));
	}

}
