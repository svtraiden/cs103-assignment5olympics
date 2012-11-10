/**
 * 
 */
package com.project5.tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project5.dataElements.CurlerPosition;
import com.project5.dataManager.CurlerTeam;

/**
 * @author Svetoslav Kostadinov
 *
 */
public class CurlerTeamTester {

	CurlerTeam team;	
	
	@Before
	/** This method is run before each individual test
	 *   Creates an object of CurlerTeam and adds three
	 *   CurlerPlayers to the CurlerTeam
	 */
	public void setUp() throws Exception {
		team = new CurlerTeam("Sweden");
		team.addPlayer("John", "Smith", CurlerPosition.THROWER);
		team.addPlayer("Bob", "Brown", CurlerPosition.SWEEPER);
		team.addPlayer("Harold", "Jones", CurlerPosition.SKIP);
	}
	
	/** This method is run after each individual test
	 *   It sets the team reference to null so the garbage
	 *   collector can reclaim the memory used for the
	 *   CurlerTeam object
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		team = null;
	}

	@Test
	public void testGetNumPlayers() {
		assertEquals(3,CurlerTeam.getNumPlayers());
		team.addPlayer("George", "Jungle", CurlerPosition.SWEEPER);
		assertEquals(4, CurlerTeam.getNumPlayers());
	}
	
	@Test
	public void testAddPlayer() {
		String result;
		result = team.addPlayer("Benny", "Jets", CurlerPosition.SKIP);
		assertEquals("There is already a skip on this team\nPlayer not added", result);
		result = team.addPlayer("Benny","Jets", CurlerPosition.THROWER);
		assertEquals("There is already a thrower on this team\nPlayer not added", result);
		result = team.addPlayer("Benny","Jets", CurlerPosition.SWEEPER);
		assertEquals(null, result);
		assertEquals(4,CurlerTeam.getNumPlayers());
	}
	
	@Test
	public void testPrintTeam() {
		String result = team.printTeam();
		Scanner team = new Scanner(result);
		assertEquals("Sweden",team.nextLine()); //Sweden
		//extract three team players
		team.nextLine();  //John Smith     Position guard
		team.nextLine();  //Bob Brown     Position forward
		assertEquals("Harold",team.next()); //Harold
	}

}
