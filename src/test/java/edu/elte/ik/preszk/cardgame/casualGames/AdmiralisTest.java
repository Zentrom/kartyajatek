package edu.elte.ik.preszk.cardgame.casualGames;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class AdmiralisTest  {

	/**
	 * @param name
	 */

	@InjectMocks
	Admiralis admiralis;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testConstructor() {
		//GIVEN
		//WHEN
		//THEN
		admiralis.game();
	}
	
}

	