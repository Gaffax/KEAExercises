package exercises;

import java.util.Iterator;
import java.util.Set;

public class Teen {
	// 10. Write a method removeEvenLength that accepts a set of strings
	// as a parameter and that removes all of the strings of even length
	// from the set.

	public void removeEvenLength(Set<String> setOfStrings) {

		Iterator<String> itr = setOfStrings.iterator();

		while (itr.hasNext()) {
			String string = (String) itr.next();

			if (string.length() % 2 == 0) {
				itr.remove();
				setOfStrings.remove(itr);
			}
		}

		// Made another iterator to prove that i actually removed 
		// the even strings from the string set
		Iterator<String> itr2 = setOfStrings.iterator();

		while (itr2.hasNext()) 
			System.out.println((String) itr2.next());
	}
}
