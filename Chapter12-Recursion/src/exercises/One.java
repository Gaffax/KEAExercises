package exercises;

public class One {
	// 1. Write a recursive method called starString that
	// accepts an integer as a parameter and prints to the
	// console a string
	// of stars (asterisks) that is 2n (i.e., 2 to the nth power)
	// long. For example,
	// • starString(0) should print * (because 20 == 1)
	// • starString(1) should print ** (because 21 == 2)
	// • starString(2) should print **** (because 22 == 4)
	// • starString(3) should print ******** (because 23 == 8)
	// • starString(4) should print **************** (because 24 == 16)
	// The method should throw an IllegalArgumentException if passed
	// a value less than 0.

	public String starString(int input) {

		String tempValue = "";
		if (input < 0)
			throw new IllegalArgumentException();

		else if (input == 0)
			tempValue += "*"; // Base case

		else if (input >= 1)
			tempValue += starString(input - 1) + starString(input - 1); // Recursive
																		// step

		return tempValue;

	}

}
