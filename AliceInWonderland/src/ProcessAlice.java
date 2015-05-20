import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProcessAlice {

	private Map<Character, Integer> numberOfLetters;

	public ProcessAlice(String path) throws FileNotFoundException {
		this.numberOfLetters = new HashMap<Character, Integer>();
		File alice = new File(path);
		setUpAlphabet();
		analyseText(alice);
	}

	public void printNumberOfLetters() {
		System.out.println("The count of each letter in the analyzed text document is as follows:");
		for (char i = 'a'; i <= 'z'; i++) {

			System.out.println(i + ": " + numberOfLetters.get(i));
		}
	}

	public void showLetterPercentageDistribution() {

		int totalLetterCounter = 0;
		double percentageOfThisLetter;
		DecimalFormat decimalFormat = new DecimalFormat("0.##");
		
		System.out.println("The percentage distribution of the letters in the analyzed text document is as follows:");
		
		for (char i = 'a'; i <= 'z'; i++) {
			totalLetterCounter += this.numberOfLetters.get(i);
		}

		for (char i = 'a'; i <= 'z'; i++) {
			
			percentageOfThisLetter = (double) 100*numberOfLetters.get(i)/totalLetterCounter;
			
			String formatetPercentage = decimalFormat.format(percentageOfThisLetter);
			
			System.out.println(i + ": " +  formatetPercentage);
		}
	}

	private void setUpAlphabet() {
		for (char i = 'a'; i <= 'z'; i++) {
			this.numberOfLetters.put(i, 0);
		}
	}

	private void analyseText(File alice) throws FileNotFoundException {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(alice);
		char[] anArray;

		while (input.hasNext()) {
			anArray = input.next().toLowerCase().replaceAll("[^a-z]", "")
					.toCharArray();

			for (char letter : anArray) {
				int currentNumber = (int) numberOfLetters.get(letter);
				numberOfLetters.put(letter, currentNumber + 1);
			}

		}
	}
}
