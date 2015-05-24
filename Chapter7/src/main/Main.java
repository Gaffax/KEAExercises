package main;

import exercises.One;

public class Main {

	public static void main(String[] args) {
		One stack = new One();

		stack.push(new Integer(4));
//		stack.push(new Integer(5));
//		stack.push(new Integer(6));
//		stack.push(new Integer(7));
//		stack.push(new Integer(8));
//		stack.push(new Integer(9));
//		stack.push(new Integer(10));
//		stack.push(new Integer(12));
//		stack.push(new Integer(3));

		while (!stack.isEmpty())
			System.out.println((Integer) (stack.pop()));
		

	}
	
	//	7.1
	/*
	 * What is the order of each of the following tasks in the worst case?
	 * a. Computing sum of the first half of an array of n items
	 * b. Initializing each element on an array items to 1
	 * c. Display every other integer in a linked list of n nodes
	 * d. Displaying the third element in a linked list
	 * f. Displaying the last integer in a linked list of n nodes
	 * g. Searching an array of n integers for a particular value by using a binary search
	 * h. Sorting an array of n integers into ascending order by using a merge sort
	 */
	

	
	
	// 7.13
	/*
	 * Trace the bubble sort as it sorts the following array into ascending order
	 * 10 12 23 34 5
	 * 
	 * 10 12 23 5 34
	 * 
	 * 10 12 5 23 34
	 * 
	 * 10 5 12 23 34
	 * 
	 * 5 10 12 23 34
	 */
}
