import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question12_RepeatStringThree {

	public static void main(String[] args) {
		List<String> fruits = new ArrayList<String>();
		fruits.add("Raspberry");
		fruits.add("Strawberry");
		fruits.add("BlueBerry");
		fruits.add("Halle Berry");
		fruits.add("BlackBerry");
		fruits.add("Indigo Munchkin");
		fruits.add("BlackBerry");
		fruits.add("BlackBerry");

		System.out.println(contains3(fruits));
	}

	public static boolean contains3(List<String> list) {
		// put the code for adding items to the map from the list in another
		// method.
		HashMap<String, Integer> hm = new HashMap<String, Integer>(
				addToMap(list));

		for (String word : hm.keySet()) {
			int count = hm.get(word);
			if (count >= 3) {
				return true;
			}
		}
		return false;

	}

	private static HashMap<String, Integer> addToMap(List<String> list) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (String item : list) {
			if (hm.containsKey(item)) {
				hm.put(item, hm.get(item) + 1);
			} else {
				hm.put(item, 1);
			}
		}
		return hm;
	}

}
