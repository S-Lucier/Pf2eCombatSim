/*
 * Does basic attacks, typical strikes without any fancy riders
 */
public class BasicAttack {
	
	/*
	 * final version of this function should take in a character to 
	 * reference, pull it's AC, roll attack and deduct HP
	 * 
	 *@param target The target of the attack
	 *@param attack The attack being used against the target
	 *@throws IllegalArgumentException 
	 */
	public int makeAttack(Combatant target, AttackAction attack) throws Exception {
		int attackDamage = 0;

		switch (Pf2eDegreeRoll.rollCheck(attack.getModifer(), target.getArmorClass())) {
		case CRITSUCCESS:
			//portion of critical hit that is doubled after roll
			attackDamage = 2 * DiceRoller.parseDiceString(attack.getCritBefore());
			//portion that isn't
			attackDamage =+ DiceRoller.parseDiceString(attack.getCritExtra());
			break;
		case SUCCESS:
			attackDamage = DiceRoller.parseDiceString(attack.getDamage());
			break;
		case FAIL:
			attackDamage = DiceRoller.parseDiceString(attack.getMissDamage());
			break;
		case CRITFAIL:
			break; //nothing ever happens
		default:
			throw new IllegalArgumentException("Combatant.makeAttack could not find a degree of success");
		}
		return attackDamage;
		
	}
}
