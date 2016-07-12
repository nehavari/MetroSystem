/**
 * 
 */
package sapient.excercise.mscs.station;

import static org.junit.Assert.*;

import org.junit.Test;

import sapient.excercise.mscs.exception.StationNotFoundException;

/**
 * @author neha.vari
 *
 */
public class FootFallTest {

	
	/**
	 * Test method for {@link sapient.excercise.mscs.station.FootFall#getFootFall(sapient.excercise.mscs.station.Station)}.
	 * @throws StationNotFoundException 
	 */
	@Test
	public final void testGetFootFall() throws StationNotFoundException {
		Station station = new Station("A3");
		FootFall ff = new FootFall();
		//4 times
		ff.addFootFall(station);
		ff.addFootFall(station);
		ff.addFootFall(station);
		ff.addFootFall(station);
		assertEquals(4,ff.getFootFall(station));
	}
	
	@Test
	public final void testGetFootFallZERO() throws StationNotFoundException {
		Station station = new Station("A4");
		FootFall ff = new FootFall();
		// No foot fall
		assertEquals(0,ff.getFootFall(station));
	}

}
