package exercises;

public class Two {
	// 2. Write a method called writeNums that takes an integer n 4
	// as a parameter and prints to the console the first n integers
	// starting with 1 in sequential order, separated by commas. For
	// example, consider the following calls:
	// writeNums(5);
	// System.out.println(); // to complete the line of output
	// writeNums(12);
	// System.out.println(); // to complete the line of output
	// These calls should produce the following output:
	// 1, 2, 3, 4, 5
	// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
	// Your method should throw an IllegalArgumentException if passed
	// a value less than 1.

	public void writeNums(int input) {

		if (input < 0)
			throw new IllegalArgumentException(); // NO! You cannot! I wont do
													// it!

		else
			System.out.println(writeNum(input, 1)); // OVERLOAD THAT METHOD
													// BABY!

	}

	/*
	 * input starts at X = 5 i starts at Y = 1
	 * 
	 * X represents the number of times that the method needs to be called
	 * recusively.
	 * 
	 * Y represents the current number that needs to be printed.
	 * 
	 * each recursive call decrement X and incement Y
	 * 
	 * 
	 * Everything is build to a string, and then returned when the entire string
	 * is build.
	 */
	private String writeNum(int input, int i) {
		if (input == 1)
			return i + ""; // Convert int to String trick

			return i + ", " + writeNum(input - 1, i + 1);

	}

}
