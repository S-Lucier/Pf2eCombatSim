

public class Pf2eDegreeRoll {
	
	
	static DiceRoller dice;
	
	//constructor, lets you pass in a dice object to reference
	Pf2eDegreeRoll(DiceRoller dice) {
		this.dice = dice;
	}
	
	//if you want to instead make a new dice object
	Pf2eDegreeRoll() {
		this.dice = new DiceRoller();
	}
		
	/*
	 * Takes in a modifier and a target DC, rolls a d20 with that modifier vs that target DC,
	 * and determines the degree of success based off pathfinder 2e's four degree system
	 * Explanation of this system here: https://2e.aonprd.com/Rules.aspx?ID=2286
	 * 
	 * @return degree The degree of success, crit success, success, fail, or crit fail
	 * @param modifer The modifier of the character rolling the check, i.e. 1d20 + 5
	 * @param difficultyClass The number the character is trying to hit, how hard the task is. 
	 */	
	public static DegreeOfSuccess rollCheck(int modifier, int difficultyClass) {
		final int[] d20 = {1, 20, 0}; //xdy + z dice format for a straight d20
		int degreeNum = 0; //temp variable we'll later turn into an enum
		
		int rollResult = dice.rollDice(d20) + modifier;
		
		//determine degree of success based off result vs difficulty class
		if (rollResult - difficultyClass >= 10) {
			degreeNum = 3;
		}
		else if (rollResult - difficultyClass >= 0) {
			degreeNum = 2;
		}
		//in pf2e you crit miss if you roll 10 under inclusive, so it's actually above -9 instead of -10
		else if (rollResult - difficultyClass >= -9) { //pf2e you crit miss if you roll 10 under inclusive
			degreeNum = 1;
		}
		
		//pf2e shifts degree of success up/down by a step on a roll of 20 or 1, so we must account for that
		//but it can't shift up/down if already a crit
		if (rollResult - modifier == 20 && degreeNum != 3) {
			++degreeNum;
		}
		if (rollResult - modifier == 1 && degreeNum != 0 ) { //can't go below crit fail
			--degreeNum;
		}
		
		//create enum using calculated degree of success
		//needs logging
		try {
			DegreeOfSuccess degree = DegreeOfSuccess.fromInt(degreeNum);
			return degree;
		} catch(IllegalArgumentException e) {
			System.err.println(e);
			e.printStackTrace(System.out);
			
			//sets degree of success to a FAIL in case of out of bounds issue
			DegreeOfSuccess degree = DegreeOfSuccess.fromInt(1);
			return degree;
		}
		
	}
}
