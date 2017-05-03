package tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tdd.training.session1.MarsRover;

public class MarsRoverTest {
	private MarsRover planet;

	@Before
	public void setUp() {
		planet = new MarsRover(3, 3, "?(1,1)?");
	}

	@Test
	public void roverMovesForwardFromNorth() {
		assertEquals(planet.executeCommand("f"), "(0,1,N)");
	}

	@Test
	public void roverMovesBackwardFromNorth() {
		planet.executeCommand("f");
		assertEquals(planet.executeCommand("b"), "(0,0,N)");
	}

	@Test
	public void roverMovesClockwiseFromNorth() {
		assertEquals(planet.executeCommand("r"), "(0,0,E)");
	}

	@Test
	public void roverMovesCounterclockwiseFromNorth() {
		assertEquals(planet.executeCommand("l"), "(0,0,W)");
	}

	@Test
	public void roverMovesClockwiseFromEast() {
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("r"), "(0,0,S)");
	}

	@Test
	public void roverMovesClockwiseFromSouth() {
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("r"), "(0,0,W)");
	}

	@Test
	public void roverMovesClockswiseFromWest() {
		planet.executeCommand("r");
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("r"), "(0,0,N)");
	}

	@Test
	public void roverMovesCounterclockwiseFromEast() {
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("l"), "(0,0,N)");
	}

	@Test
	public void roverMovesCounterclockwiseFromSouth() {
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("l"), "(0,0,E)");
	}

	@Test
	public void roverMovesCounterclockwiseFromWest() {
		planet.executeCommand("l");
		assertEquals(planet.executeCommand("l"), "(0,0,S)");
	}

	@Test
	public void roverMovesForwardFromEast() {
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("f"), "(1,0,E)");
	}

	@Test
	public void roverMovesForwardFromSouth() {
		planet.executeCommand("f");
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("f"), "(0,0,S)");
	}

	@Test
	public void roverMovesForwardFromWest() {
		planet.executeCommand("r");
		planet.executeCommand("f");
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("f"), "(0,0,W)");
	}

	@Test
	public void roverMovesForwardToSouthLimit() {
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("f"), "(0,2,S)");
	}

	@Test
	public void roverMovesForwardToWestLimit() {
		planet.executeCommand("l");
		assertEquals(planet.executeCommand("f"), "(2,0,W)");
	}

	@Test
	public void roverMovesForwardToNorthLimit() {
		planet.executeCommand("f");
		planet.executeCommand("f");
		assertEquals(planet.executeCommand("f"), "(0,0,N)");
	}

	@Test
	public void roverMovesForwardToEastLimit() {
		planet.executeCommand("r");
		planet.executeCommand("f");
		planet.executeCommand("f");
		assertEquals(planet.executeCommand("f"), "(0,0,E)");
	}

	@Test
	public void roverMovesBackwardFromSouth() {
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("b"), "(0,1,S)");
	}

	@Test
	public void roverMovesBackwardFromWest() {
		planet.executeCommand("l");
		assertEquals(planet.executeCommand("b"), "(1,0,W)");
	}

	@Test
	public void roverMovesBackwardFromEast() {
		planet.executeCommand("r");
		planet.executeCommand("f");
		assertEquals(planet.executeCommand("b"), "(0,0,E)");
	}

	@Test
	public void roverMovesBackwardToSouthLimit() {
		assertEquals(planet.executeCommand("b"), "(0,2,N)");
	}

	@Test
	public void roverMovesBackwardToWestLimit() {
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("b"), "(2,0,E)");
	}

	@Test
	public void roverMovesBackwardToNorthLimit() {
		planet.executeCommand("f");
		planet.executeCommand("f");
		planet.executeCommand("r");
		planet.executeCommand("r");
		assertEquals(planet.executeCommand("b"), "(0,0,S)");
	}

	@Test
	public void roverMovesBackwardToEastLimit() {
		planet.executeCommand("l");
		planet.executeCommand("f");
		assertEquals(planet.executeCommand("b"), "(0,0,W)");
	}

	@Test
	public void multipleCommands() {
		assertEquals(planet.executeCommand("ff"), "(0,2,N)");
	}

	@Test
	public void roverMeetAnObstacle() {
		assertEquals(planet.executeCommand("frflf"), "(0,2,N)(1,1)");
	}
}
