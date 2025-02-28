import java.util.Random;
public class TestingScratchPad {

	
	public static void main(String[] args) {
		
		/*
		//testing parseDiceSubString
		String substring = "9999";
		int[] result = DiceRoller.parseDiceSubstring(substring);
	
		System.out.println(String.valueOf(result[0]) + String.valueOf(result[1])+ String.valueOf(result[2]));
		//works properly
	
		*/
		//testing parseDiceString
		String inputString = "8d6 + 4d6 + 10";
		DiceRoller.parseDiceString(inputString);
		
		/*
		//brainstorming dice rolling algorithm for rollDice in DiceRoller class
		int[] exampleDie = {8, 6, 20}; //dice in xdy + Z format
		int value = 0;
		int amount = exampleDie[0]; //I'll just use the array directly in final but easier
		int size = exampleDie[1]; //to brainstorm with good names
		int flatBonus = exampleDie[2];
		
		
		//create random object (java weirdness), it uses system clock to get psuedorandom seed.
		Random ran = new Random();	
		
		 
		
		if (amount != 0 || size !=0) { //check if there are even die to roll
			for (int i = 0; i < amount; ++i) { //for loop to roll a die x times
				//ran.nextInt goes from 0 to non-inclusive max size, so offset by adding one for a die.
				value += 1 + ran.nextInt(size); //adds die roll to value once per for loop
			}
		}
		value += flatBonus; //adds flat bonus if it exists, this is often just 0
		
		System.out.println(value);
		
		//check if this random number generator is at least converging to average
		//using 100,000 d6 as example
		int testTotal = 0;
		for (int i = 0; i < 100000; ++i) {
			testTotal += 1 + ran.nextInt(6);
		}
		System.out.println("Expect testTotal as 3.5 * 100,000 = 350,000");
		System.out.println("Expiremental testTotal is " + testTotal);
		System.out.println("Which is " + testTotal / 350000.0 * 100 + "% of testTotal");
		//all tests show within 1% of average so I think this random number generator is fine
		//this isn't a great test but we don't need manipulation proof RNG here this isn't a
		//"speedrun proof" game or something
		
		//test final rollDice function
		//System.out.println(DiceRoller.rollDice(exampleDie)); //works!
		*/
	}
}
