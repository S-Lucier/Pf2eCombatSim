import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AttackAction extends Action {

	//declares
	final int[] d20 = {1, 20, 0}; //xdy + z dice format for a straight d20
	int modifer;
	private String damage; //standard attack damage
	private String critBefore; //the portion of crit damage that will be doubled after rolling dice
	private String critExtra; //the portion of crit damage that won't
	private String missDamage; //damage that happens on a miss

	//constructor
	public AttackAction(DiceRoller dice, int modifer, String damage, String critBefore, String critExtra, String missDamage)  {
		super(); //check if actually need to call empty superclass at some point, idk maybe best practice anyways
		//assign parameters to class variables
		this.modifer = modifer;
		this.damage = damage;
		this.critBefore = critBefore;
		this.critExtra = critExtra;
		this.missDamage = missDamage;
	}

	//getters and setters (could use attack.(variable) directly but getters are Best Practice)
	public int getModifer() {
		return modifer;
	}
	public void setModifier(int newMod) {
		modifer = newMod;
	}
	public String getDamage() {
		return damage;
	}
	public void setDamage(String newDamage) {
		damage = newDamage;
	}
	public String getCritBefore() {
		return critBefore;
	}
	public void setCritBefore(String newCritBefore) {
		critBefore = newCritBefore;
	}
	public String getCritExtra() {
		return critExtra;
	}
	public void setCritExtra(String newCritExtra) {
		critExtra = newCritExtra;
	}
	public String getMissDamage() {
		return missDamage;
	}
	public void setMissDamage(String newMissDamage) {
		missDamage = newMissDamage;
	}
}
