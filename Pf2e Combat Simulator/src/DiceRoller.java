import java.util.Random;

/**
 * Parses and rolls Dice inputs in the form xdx+xdx+...+(static number), outputting total
 * Since this will be used for a pathfinder simulation the lowest any damage total can be is 1,
 * you can't deal 0 or negative damage, not from your attack anyways
 */
public class DiceRoller {

	static Random ran; //random object for class so we can keep a random object instead of remaking it
	//should be fine as a static because we only need to make the DiceRoller object once
	//and it's just going down a list of random numbers based off seed



	//constructor that lets user put in a fixed seed for random module
	public DiceRoller(int seed) {
		DiceRoller.ran = new Random(seed); //using DiceRoller instead of
		//this.ran because ran is static, only one copy exists.
	}

	//constructor that does a seed based off system clock
	public DiceRoller() {
		//create random object (java weirdness), it uses system clock to get psuedorandom seed.
		DiceRoller.ran = new Random();	
	}

	/*
	 * Takes dice string, chops into substrings for each die, feeds to parseDiceSubstring, 
	 * feeds to rollDice, totals up the dice rolls.
	 * 
	 * @param input The dice string to read
	 * @return total The sum of all the dice/bonuses in the dice string, rolled.
	 */
	public static int parseDiceString(String input) {
		int lower = 0; //lower stop, "take fragment from lower to i"
		int i = 0; //needed outside for loop for last fragment
		boolean positive = true; //whether to add or subtract the parsed dice fragment from the total
		int total = 0; //total of dice roll string
		boolean multiPart = false; //if multiple dice are in string

		String substring = ""; //substring of input string to send to substring parser
		for (i = 0; i < input.length(); i++) {
			if ((input.charAt(i) == '+')|| (input.charAt(i) == '-') /*|| (i == input.length() - 1)*/ ) {
				if (input.charAt(i) == '-' ) {
					positive = false; //makes parsed dice fragment subtract from total
				}
				multiPart = true;

				//special case for first fragment
				if (lower == 0) {
					substring = input.substring(lower, i); //special case for first fragment
				}
				//special case for last fragment
				else if (i == input.length() - 1) {
					substring = input.substring(lower + 1, i + 1);
				}
				//make substring
				else {
					substring = input.substring(lower + 1, i); //excludes + or - from substring
				}


				int[] tripleIntFormat = parseDiceSubstring(substring);
				//test dice conversion to xyz triple int format
				System.out.println(String.valueOf(tripleIntFormat[0]) + "d" + String.valueOf(tripleIntFormat[1])+ " + " + String.valueOf(tripleIntFormat[2]));

				if (positive == false) {
					total -= rollDice(tripleIntFormat);
				}
				else {
					total += rollDice(tripleIntFormat);
				}


				lower = i; //move lower stop
			}
		}
		if (!multiPart) {
			total = rollDice(parseDiceSubstring(input));
			System.out.println(total);
		}
		//special case for last fragment
		else {
			substring = input.substring(lower + 1, i);	
			total += rollDice(parseDiceSubstring(substring));

		}
		return total;
	}

	/*
	 * Takes string for a specific die, converts it into xdy format where x and y are integers
	 * If there's no dice in (numbers)(d character)(numbers) it can take a flat number input.
	 * Returns: x (number of dice), y (size of die), z (flat number if it's a flat number)
	 */
	public static int[] parseDiceSubstring(String substring) {
		int x = 0, y = 0, z = 0;
		boolean flatNumFlag = true; //dice vs flat value
		for (int i = 0; i < substring.length(); ++i) {
			if (substring.charAt(i) == 'd' || substring.charAt(i) == 'D') {
				x = Integer.parseInt(substring.substring(0, i)); //left side excluding d character
				y = Integer.parseInt(substring.substring(i + 1, substring.length())); //right side
				flatNumFlag = false;
			}
		}

		if (flatNumFlag == true) {
			z = Integer.parseInt(substring);
		}
		return new int[]{x, y, z}; //returns number die, amount die, flat number
	}

	/*
	 * Rolls dice given in xdy + z array format. die[0] = amount to roll, die[1] = size of die
	 * die[2] = flat bonus to add to dice total, this can be negative though this program doesn't
	 * make use of that functionality, handling negatives outside this function
	 */
	public static int rollDice(int[] die) { //input of xdy, roll x many of dice type y
		int diceValue = 0; //total amount rolled

		if (!(die[0] == 0) && !(die[1] == 0)) { //check if there are even die to roll
			for (int i = 0; i < die[0]; ++i) { //for loop to roll a die x times
				//ran.nextInt goes from 0 to non-inclusive max size, so offset by adding one for a die.
				diceValue += 1 + ran.nextInt(die[1]); //adds die roll to value once per for loop
			}
		}
		diceValue += die[2]; //adds flat bonus if it exists, this is often just 0
		System.out.println("DiceRoller.rollDice value test " + diceValue); //test
		return diceValue;
	}
}



