import static org.junit.Assert.*;

import org.junit.Test;

public class CombatantTest {
	//test parameters
	int modifer = 10;
	String damage = "2d6+5";
	String critBefore = "2d8+5";
	String critAfter = "1d6";
	String missDamage = "9";

	DiceRoller dice = new DiceRoller(5); //set random seed for testing
	
	@Test
	public void testMakeAttack() {
		AttackAction A = new AttackAction(dice, modifer, damage, critBefore, critAfter, missDamage);
		
		//(int armorClass, int hitPoints, Action actionOne, Action actionTwo, Action actionThree);
		Combatant exampleTarget = new Combatant(18, 100, A, A, A);
		A.makeAttack(exampleTarget);
		System.out.println(exampleTarget.getHitPoints()); //temp to know what to set assert to
		assertEquals(80, exampleTarget.getHitPoints());

	}

}
