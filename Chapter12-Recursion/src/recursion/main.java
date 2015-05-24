package recursion;

import exercises.*;

public class main {

	public static void main(String[] args) {

		// Uncomment static methods to run exercise solution.
		
		//one();
		//two();
		//three();
		four();
		
		//System.out.println(Math.abs(2.5));
	}
	
	
	private static void one(){
//		1. Write a recursive method called starString that 
//		accepts an integer as a parameter and prints to the 
//		console a string
//		of stars (asterisks) that is 2n (i.e., 2 to the nth power) 
//		long. For example,
//		• starString(0) should print * (because 20 == 1)
//		• starString(1) should print ** (because 21 == 2)
//		• starString(2) should print **** (because 22 == 4)
//		• starString(3) should print ******** (because 23 == 8)
//		• starString(4) should print **************** (because 24 == 16)
//		The method should throw an IllegalArgumentException if passed 
//		a value less than 0.
		
		
		//Set up answer one.
		String result;

		One one = new One();
		result = one.starString(0);
		System.out.println(result);
		
		result = one.starString(1);
		System.out.println(result);
		
		result = one.starString(2);
		System.out.println(result);
		
		result = one.starString(3);
		System.out.println(result);
		
		result = one.starString(4);
		System.out.println(result);		
	}
	
	
	private static void two(){
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
		
		Two two = new Two();
		
		two.writeNums(5);
		two.writeNums(12);
	}
	
	public static void three(){
//		3. Write a method called writeSequence that accepts an integer n 
//		as a parameter and prints to the console a symmetric
//		sequence of n numbers composed of descending integers that ends in 1, 
//		followed by a sequence of ascending
//		integers that begins with 1. The following table indicates the output that 
//		should be produced for various values of n:
//		Method call Output produced
//		-----------------------------------------
//		writeSequence(1); 1
//		writeSequence(2); 1 1
//		writeSequence(3); 2 1 2
//		writeSequence(4); 2 1 1 2
//		writeSequence(5); 3 2 1 2 3
//		writeSequence(6); 3 2 1 1 2 3
//		writeSequence(7); 4 3 2 1 2 3 4
//		writeSequence(8); 4 3 2 1 1 2 3 4
//		writeSequence(9); 5 4 3 2 1 2 3 4 5
//		writeSequence(10); 5 4 3 2 1 1 2 3 4 5
//		Notice that when n is odd the sequence has a single 1 in the middle, 
//		while for even values it has two 1s in the
//		middle. Your method should throw an IllegalArgumentException if it 
//		is passed a value less than 1.

		Three run = new Three();
		System.out.println(run.writeSequence(1));
		System.out.println(run.writeSequence(2));
		System.out.println(run.writeSequence(3));
		System.out.println(run.writeSequence(4));
		System.out.println(run.writeSequence(5));
		System.out.println(run.writeSequence(6));
		System.out.println(run.writeSequence(7));
		System.out.println(run.writeSequence(8));
		System.out.println(run.writeSequence(9));
		System.out.println(run.writeSequence(10));
	}
	
	public static void four(){
		// 4. Write a recursive method called doubleDigits that
		// accepts an integer n as a parameter and returns the integer
		// obtained by replacing every digit of n with two of that digit.
		// For example, doubleDigits(348) should return
		// 334488. The call doubleDigits(0) should return 0. Calling doubleDigits
		// on a negative number should return
		// the negation of calling doubleDigits on the corresponding positive
		// number; for example, doubleDigits(–789)
		// should return –778899.
		
		Four run = new Four();
		System.out.println(run.doubleDigits(123456789));
	}
}
