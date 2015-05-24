package exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExSix {
//	6. Write a method countUnique that accepts a list of integers as
//	a parameter and returns the number of unique integer
//	values in the list. Use a set as auxiliary storage to help you 
//	solve this problem. For example, if a list contains the values
//	(3, 7, 3, –1, 2, 3, 7, 2, 15, 15), your method should return 5. 
//	The empty list contains 0 unique values.

	public static void countUnique(int[] arrayOfInts){
		
		Set hashSet = new HashSet<Integer>();
		
		int number;
		
		for (Integer numbersInList : arrayOfInts) {
			hashSet.add(numbersInList);
		}
		
		System.out.println(hashSet.size());
		
		
		
	}

}
