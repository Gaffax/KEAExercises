import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProcessAlice {

	private Map<Character, Integer> numberOfLetters;

	// Constructor sets up and analyzes data when you pass a file path.
	// So whenever you make an object, all the data is crushed, and
	// You just need to specify what you want to do with the data.
	public ProcessAlice(String path) throws FileNotFoundException {
		this.numberOfLetters = new HashMap<Character, Integer>();
		File alice = new File(path);
		setUpAlphabet();
		analyseText(alice);
	}

	public void printNumberOfLetters() {
		System.out
				.println("The count of each letter in the analyzed text document is as follows:");
		for (char i = 'a'; i <= 'z'; i++) {

			System.out.println(i + ": " + numberOfLetters.get(i));
		}
	}

	public void showLetterPercentageDistribution() {

		int totalLetterCounter = 0;
		double percentageOfThisLetter;
		DecimalFormat decimalFormat = new DecimalFormat("0.##"); // Limits
																	// digits

		System.out
				.println("The percentage distribution of the letters in the analyzed text document is as follows:");

		for (char i = 'a'; i <= 'z'; i++) {
			totalLetterCounter += this.numberOfLetters.get(i);
		}

		for (char i = 'a'; i <= 'z'; i++) {
			// Math is applied! Magic happens!
			percentageOfThisLetter = (double) 100 * numberOfLetters.get(i)
					/ totalLetterCounter;

			String formatetPercentage = decimalFormat
					.format(percentageOfThisLetter);

			System.out.println(i + ": " + formatetPercentage);
		}
	}

	// Used for initializing the hashMap
	private void setUpAlphabet() {
		for (char i = 'a'; i <= 'z'; i++) {
			this.numberOfLetters.put(i, 0);
		}
	}

	// Analyzes word for word the letter composition of that word,
	// and updates the count of the total found letters.
	private void analyseText(File alice) throws FileNotFoundException {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(alice);
		char[] anArray;

		while (input.hasNext()) {
			anArray = input.next().toLowerCase().replaceAll("[^a-z]", "") // Everything
																			// is
																			// set
																			// to
																			// lower
																			// case,
																			// and
																			// we
																			// remove
																			// symbols.
					.toCharArray(); // I am aware, that toLowerCase and replace
									// all is called
									// The individual word, and not the entire
									// document. Which
			for (char letter : anArray) { // for most words aren't necessary.
											// This part of the code
				int currentNumber = (int) numberOfLetters.get(letter); // Could
																		// be
																		// rewritten
																		// to
																		// optimize
																		// speed
																		// and
																		// resources
																		// used.
				numberOfLetters.put(letter, currentNumber + 1);
			}
		}
	}
}
