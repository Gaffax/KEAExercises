package searchandsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Four {

	public void howManyWordsBetween(String startingWord, String endingWord){
		
		try {
			Scanner dictionary = new Scanner(new File("C:\\Users\\Gaffax\\studyExercises\\Ex13.1-13.11-SearchingAndSorting\\src\\wordlist.txt"));//Found on http://getintopc.com/softwares/education/oxford-advanced-learners-dictionary-free-download/
	
			Set<String> words = new TreeSet<String>();
			
			while(dictionary.hasNext()){
			words.add(dictionary.next());
			}
			Object[] wordsArray = words.toArray();
			
			int firstIndex = Arrays.binarySearch(wordsArray, startingWord);
			int secondIndex = Arrays.binarySearch(wordsArray, endingWord);
			int spaceBetween = 0;
			
			if(firstIndex > secondIndex){
				spaceBetween = firstIndex-secondIndex;
			}else if (firstIndex < secondIndex){
				spaceBetween = secondIndex - firstIndex;
			}
			
			System.out.println(spaceBetween);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
}
