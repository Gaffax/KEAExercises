
import java.util.HashMap;
import java.util.Map;

public class Question14_intersect {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("Nicholas", 100);
		map1.put("Constanza", 0);
		map1.put("Louise", 50);

		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("Bubble", 8);
		map2.put("CheeseString", 2);
		map2.put("Louise", 50);

		for (String key : intersect(map1, map2).keySet()) {
			System.out.println("Key: " + key + " Value "
					+ intersect(map1, map2).get(key));
		}

	}

	public static Map<String, Integer> intersect(Map<String, Integer> map1,
			Map<String, Integer> map2) {
		Map<String, Integer> freshMap = new HashMap<String, Integer>();

		// loop through one map check
		for (String key : map1.keySet()) {
			int value = map1.get(key);

			if (map2.containsKey(key) && map2.containsValue(value)) {
				freshMap.put(key, value);
			}
		}

		return freshMap;
	}

}
