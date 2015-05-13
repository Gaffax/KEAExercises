package exercises;

import java.util.Iterator;
import java.util.Set;

public class Eight {
//	8. Write a method maxLength that accepts a set of 
//	strings as a parameter and that returns the length 
//	of the longest string in the list. If your method 
//	is passed an empty set, it should return 0.
	
	
	public void maxLenght(Set<String> someStrings){
	
		String string;
		int longestString = 0;
		int stringLenght;
		
		Iterator<String> itr = someStrings.iterator();
		
		
		while (itr.hasNext()) {
			string = (String) itr.next();
			stringLenght = string.length();

			if (stringLenght > longestString){
				longestString = string.length();
			}
		}
		System.out.println(longestString);
	}
}
