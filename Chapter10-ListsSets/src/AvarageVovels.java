import java.util.List;
/*
1. Write a method called averageVowels that takes an ArrayList of Strings as a parameter and returns the average
number of vowel characters (a, e, i, o, u) in all Strings in the list. If your method is passed an empty ArrayList, it
should return 0.0.
*/
public class AvarageVovels {
	public double avarageVovels(List<String> input){
		
		double vowels = 0;
		double letters = 0;
		
		if(input.isEmpty()) //The input list is empty
				return 0.0;
		
		for (String subInput : input){//For every string in the array
			String modifiedSubInput = subInput.toLowerCase().replaceAll("\\W", ""); //Sets everything to lowercase and removes all whitespace and symbols.

			for (int i = 0; i < modifiedSubInput.length(); i++) //For each letter in the string
			{
			    char current = modifiedSubInput.charAt(i); //Take the value in the string, and put it into a char datatype
			    if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') //Test the current char to figure out if it is a vovel
			    {
				vowels++;//Update values
				letters++;
			    } else
			    {
			    	letters++;
			    }
			}
			
		}
		
		return ((vowels / letters));
	}
}
