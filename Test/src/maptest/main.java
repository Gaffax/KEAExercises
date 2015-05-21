package maptest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// saleryTestOne();
		// saleryTestTwo();
		//saleryTestThree();
		wordCountTest();
	}

	public static void saleryTestOne() {
		Map<String, Double> salaryMap = new HashMap<String, Double>();

		salaryMap.put("Stuart Reges", 10000.00);
		salaryMap.put("Marty Stepp", 95500.00);
		salaryMap.put("Jenny", 5000.00);
		salaryMap.put("Hans", 5000.00);

		double jenSalery = salaryMap.get("Jenny");
		String jenny = "Jenny";

		System.out.printf("%s's salary is $%.2f\n", jenny, jenSalery);
	}

	public static void saleryTestTwo() {

		Map<String, Double> salaryMap = new HashMap<String, Double>();

		salaryMap.put("Stuart Reges", 10000.00);
		salaryMap.put("Marty Stepp", 95500.00);
		salaryMap.put("Jenny", 5000.00);
		salaryMap.put("Hans", 5000.00);

		Scanner console = new Scanner(System.in);
		System.out.print("Type a person's name: ");
		String name = console.nextLine();
		// search the map for the given name
		if (salaryMap.containsKey(name)) {
			double salary = salaryMap.get(name);
			System.out.printf("%s's salary is $%.2f\n", name, salary);
		} else {
			System.out.println("I don't have a record for " + name);
		}
	}

	public static void saleryTestThree() {

		Map<Integer, String> ssnMap = new HashMap<Integer, String>();
		ssnMap.put(867530912, "Jenny");
		ssnMap.put(239876305, "Stuart Reges");
		ssnMap.put(504386382, "Marty Stepp");

		// Notice that this code doesn’t declare a variable to store the key
		// set, but instead
		// calls keySet directly in the for-each loop.

		for (int ssn : ssnMap.keySet()) {
			String name = ssnMap.get(ssn);
			System.out.println(name + "'s SSN is " + ssn);
		}

	}

	public static void wordCountTest() throws FileNotFoundException {
		Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();
		Scanner in = new Scanner(new File("C:\\Users\\Gaffax\\studyExercises\\Test\\src\\mobydick.txt"));
		while (in.hasNext()) {
			String word = in.next().toLowerCase();
			if (wordCountMap.containsKey(word)) { // seen before
				int count = wordCountMap.get(word);
				wordCountMap.put(word, count + 1);
			} else { // never seen before
				wordCountMap.put(word, 1);
			}
		}

		for (String word : wordCountMap.keySet()) {
			int count = wordCountMap.get(word);
			if (count > 500) {
				System.out.println(word + " occurs " + count + " times.");
			}
		}
	}
}
