import static org.junit.Assert.*;

import org.junit.Test;

public class AttackActionTest {
	//test parameters
	int modifer = 10;
	String damage = "2d6+5";
	String critBefore = "2d8+5";
	String critAfter = "1d6";
	String missDamage = "9";
	
	DiceRoller dice = new DiceRoller(5); //set random seed for testing
	
	@Test
	public void testConstrutor() {
		AttackAction A = new AttackAction(dice, modifer, damage, critBefore, critAfter, missDamage);
		System.out.println("AttackAction Class Testing:");
		System.out.printf("%d, %s, %s, %s\n",A.getModifer(), A.getDamage(), A.getCritBefore(), A.getCritExtra());
		assertEquals(modifer, A.getModifer());
		assertEquals(damage, A.getDamage());
		assertEquals(critBefore, A.getCritBefore());
		assertEquals(critAfter, A.getCritExtra());		
	}

}
