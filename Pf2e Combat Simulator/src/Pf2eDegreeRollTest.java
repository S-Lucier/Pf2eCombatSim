import static org.junit.Assert.*;

import org.junit.Test;

public class Pf2eDegreeRollTest {

	@Test
	public void testRollCheck() {
		DiceRoller dice = new DiceRoller(5);
		Pf2eDegreeRoll pf2eRoll = new Pf2eDegreeRoll(dice);
		int modifier = 10;
		int difficultyClass = 18;
		int result1 =  pf2eRoll.rollCheck(modifier, difficultyClass);
		assertEquals(2, result1);
		
		
	}
}
