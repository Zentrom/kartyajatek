package edu.elte.ik.preszk.cardgame.casualGames;

import org.junit.Test;

import junit.framework.Assert;

public class AdmiralisTest  {

	/**
	 * @param name
	 */
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
	}
	
	@Test
	public void testConstructor() {
		//GIVEN
		//WHEN
		Admiralis admiralis = new Admiralis();
		//THEN
		Assert.assertNotNull(admiralis);
	}
	
}

	