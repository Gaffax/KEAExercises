package exercises;

import java.util.Iterator;
import java.util.Set;

public class ExNine {
	// 9. Write a method hasOdd that accepts a set of integers
	// as a parameter and returns true if the set contains at
	// least one odd integer and false otherwise. If passed
	// the empty set, your method should return false.

	public boolean hasOdd(Set<Integer> someStrings) {

		int number;

		Iterator itr = someStrings.iterator();

		while (itr.hasNext()) {
			number = (int) itr.next();
			if (number % 2 == 1) {
				return true;
			} else {
			}
		}

		return false;
	}
}
