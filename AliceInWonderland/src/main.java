import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class main {

//	Make a java program that reads a file, aliceinwonderland.txt, and counts how many characters of each type there is. e.g. how many ‘a’, how many ‘b’, how many  ‘c’, and so on. Disregarding upper or lower case.
//	When you have a count of number of characters for each character in the alphabet, then you should calculate the percentage of each character, e.g. how many percent of all characters is the ‘a’, the ‘b’, and so on.
//	Only alphabetic characters, no special characters like ‘,’ or ‘.’ or ‘?’ …
	
	public static void main(String[] args) throws FileNotFoundException {

		
		String path = "src\\aliceinwonderland.txt";
		
		ProcessAlice run = new ProcessAlice(path);
		run.printNumberOfLetters();
		run.showLetterPercentageDistribution();
	}
}
