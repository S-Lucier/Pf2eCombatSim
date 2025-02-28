/*
 * Enum class for pathfinder's four degrees of success
 */
public enum DegreeOfSuccess{
	CRITSUCCESS(3), 
	SUCCESS(2),
	FAIL(1),
	CRITFAIL(0);
	private final int value; //final because once each enum instance is made it doesn't change
	
	//
	//constructs each enum instance in the class and assigns a int value
	DegreeOfSuccess(int value) {
		this.value = value;
	}
	
	/*
	 * Takes the corresponding int for each enum
	 * 
	 * @param value The value corresponding with the desired enum instance
	 * @throws IllegalArgumentException if int values outside 0-3 are given
	 */
	public static DegreeOfSuccess fromInt(int value) {
		for (DegreeOfSuccess degree : DegreeOfSuccess.values()) {
			if (degree.getValue() == value) {
				return degree;
			}
		}
		throw new IllegalArgumentException("Invalid degree of sucess number: " + value);
		
	}	
	
	//overrides the default enum toString to append the associated value
	@Override
	public String toString() {
		//name() is the function to get the string for a enum entry, i.e. "FAIL"
		return name() + " (" + value + ")";
	}
	
	public int getValue() {
		return value;
	}
}
