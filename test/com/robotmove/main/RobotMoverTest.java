/**
 * 
 */
package com.robotmove.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author finch
 *
 */
public class RobotMoverTest {

	private RobotMover robotMover = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		robotMover = new RobotMover();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		robotMover = null;
	}

	/**
	 * Test method for {@link com.robotmove.main.RobotMover#moveRobot()}.
	 */
	@Test
	public void testMoveRobot() {
		robotMover.moveRobot();
	}

}
