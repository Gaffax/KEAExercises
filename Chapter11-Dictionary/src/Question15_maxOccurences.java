import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Question15_maxOccurences {

	public static void main(String[] args) {
		List<Integer> lotsaNumbers = new LinkedList<Integer>();
		lotsaNumbers.add(1);
		lotsaNumbers.add(2);
		lotsaNumbers.add(3);
		lotsaNumbers.add(4);
		lotsaNumbers.add(5);
		lotsaNumbers.add(6);
		lotsaNumbers.add(7);
		lotsaNumbers.add(3);
		lotsaNumbers.add(5);
		lotsaNumbers.add(5);
		lotsaNumbers.add(5);

		System.out.println(maxOccurences(lotsaNumbers));

	}

	private static int maxOccurences(List<Integer> lotsaNumbers) {
		if (lotsaNumbers.isEmpty()) {
			return 0;
		}

		HashMap<Integer, Integer> howManyOfEachNumberMap = new HashMap<Integer, Integer>(
				addToMap(lotsaNumbers));

		int max = 0;
		for (int number : howManyOfEachNumberMap.keySet()) {
			if (howManyOfEachNumberMap.get(number) > max) {
				max = howManyOfEachNumberMap.get(number);
			}

		}

		return max;
	}

	private static HashMap<Integer, Integer> addToMap(List<Integer> list) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int item : list) {
			if (hm.containsKey(item)) {
				hm.put(item, hm.get(item) + 1);
			} else {
				hm.put(item, 1);
			}
		}
		return hm;
	}

}
