


import static org.junit.Assert.*;

import org.junit.Test;

public class DiceRollerTest {
	
	
	
	
	
	@Test
	public void testParseDiceSubstring() {
		DiceRoller DiceObject = new DiceRoller(5); //gotta make sure seed is the same at the start
		fail("Not yet implemented");
	}

	@Test
	public void testParseDiceString() {
		DiceRoller DiceObject = new DiceRoller(5);
		String diceString = "8d6+5+7+20d6"; //8d6+5+7+20d6
		int total = DiceObject.parseDiceString(diceString);
		System.out.println(total);
		assertEquals(113, total);
	}

	@Test
	public void testRollDice() {
		DiceRoller DiceObject = new DiceRoller(5);
		int[] xyz = {8, 6, 5};
		int result = DiceObject.rollDice(xyz);
		assertEquals(40, result);
	}
}
