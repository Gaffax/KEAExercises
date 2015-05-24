import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Question13_isUnique {
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();

	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();

		map.put("Nicholas", "Hansen");
		map.put("Samual", "Dandarovsky");
		map.put("Peter", "MuffinTop");
		map.put("Gregory", "Hansen");

		System.out.println(isUnique(map));
	}

	/**
	 * Check to see if a value is repeated in the map. In this case value is
	 * last name. If people share last names that means a value is repeated and
	 * they aren't the special snow flakes they thought they where.
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isUnique(Map<String, String> map) {
		for (String lastName : map.values()) {
			addToMap(lastName);
		}

		for (Integer lastName : hm.values()) {
			if (lastName >= 2) // checks to see if any last names have been
								// repeated.
			{
				return false;
			}
		}
		return true;
	}

	private static void addToMap(String word) {
		if (hm.containsKey(word)) {
			hm.put(word, hm.get(word) + 1);
		} else {
			hm.put(word, 1);
		}

	}

}
