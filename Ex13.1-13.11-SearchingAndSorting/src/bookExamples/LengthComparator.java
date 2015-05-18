package bookExamples;

import java.util.*;

// compares String objects by length
public class LengthComparator implements Comparator<String> {
	//The comparator gives two variables, that I must use in such a way, that I
	//Return either positive, negative or zero, depending on how the comparator
	//needs to sort that value.
	public int compare(String s1, String s2) {
		
		//Be aware, I just need to return an int for the comparator 
		//to get what is supposed to happen with the current value
return s1.length() - s2.length();
}
}