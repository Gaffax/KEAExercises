package exercises;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExSeven {
	// 7. Write a method countCommon that accepts two lists
	// of integers as parameters and returns the number of
	// unique integers
	// that occur in both lists. Use one or more sets as
	// storage to help you solve this problem. For example,
	// if one list contains the values
	// (3, 7, 3, –1, 2, 3, 7, 2, 15, 15) and the
	// other list contains the values
	// (–5, 15, 2, –1, 7, 15, 36), your method should return
	// 4 because the elements –1, 2, 7, and 15 occur in both lists.

	public void countCommon(int[] arrayOfIntsOne, int[] arrayOfIntsTwo) {

		int numberOfUniqueValues = 0;

		//After playing around with List solutions, I choose an all set solution.
		//I realized, that I had no reason to access the information contained
		// in the tempSets, and realized, that in a scaled up version, the set
		//would keep the speed and efficiency.
		Set<Integer> tempSetOne = new HashSet<Integer>();
		Set<Integer> tempSetTwo = new HashSet<Integer>();
		Set<Integer> uniqueValues = new HashSet<Integer>();

		for (int value : arrayOfIntsOne) {
			tempSetOne.add(value);
			uniqueValues.add(value);
		}
		for (int value : arrayOfIntsTwo) {
			tempSetTwo.add(value);
			uniqueValues.add(value);
		}

		Iterator<Integer> itr = uniqueValues.iterator();

		while (itr.hasNext()) {
			int number = (int) itr.next();
			if (tempSetOne.contains(number) && tempSetTwo.contains(number)) { //Compares values in the two sets.
				numberOfUniqueValues++;
			}
		}

		System.out.println(numberOfUniqueValues);
	}
}
