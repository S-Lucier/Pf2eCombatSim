import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Contains combatant data
 */
public class Combatant {

	//declare variables
	int armorClass;
	int hitPoints;
	Action actionOne;
	Action actionTwo;
	Action actionThree;

	//Constructor
	public Combatant(int armorClass, int hitPoints, Action actionOne, Action actionTwo, Action actionThree) {

		//assign parameters to class variables
		this.armorClass = armorClass;
		this.hitPoints = hitPoints;
		this.actionOne = actionOne;
		this.actionTwo = actionTwo;
		this.actionThree = actionThree;
	}

	/*
	 * final version of this function should take in a character to 
	 * reference, pull it's AC, roll attack and deduct HP
	 * 
	 *@param target The target of the attack
	 *@param attack The attack being used against the target
	 *@throws IllegalArgumentException 
	 */
	
	//does not depend on the combatant class at *all*, move to seperate class
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
			attackDamage =+ DiceRoller.parseDiceString(attack.getDamage());
			break;
		case FAIL:
			attackDamage =+ DiceRoller.parseDiceString(attack.getMissDamage());
			break;
		case CRITFAIL:
			break; //nothing ever happens
		default:
			throw new IllegalArgumentException("Combatant.makeAttack could not find a degree of success");
		}
		return attackDamage;
		
	}

	//getters and setters for class variables
	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int newAC) {
		armorClass = newAC;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int newHP) {
		hitPoints = newHP;
	}
	public Action getActionOne() {
		return actionOne;
	}
	public void setActionOne(Action newAction) {
		actionOne = newAction;
	}
	public Action getActionTwo() {
		return actionOne;
	}
	public void setActionTwo(Action newAction) {
		actionTwo = newAction;
	}
	public Action getActionThree() {
		return actionOne;
	}
	public void setActionThree(Action newAction) {
		actionThree = newAction;
	}
}
