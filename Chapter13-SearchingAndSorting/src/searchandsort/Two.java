package searchandsort;

import java.util.List;

//2. To which complexity class does each of the following algorithms belong? Consider N to be the length or size of the
//array or collection passed to the method.

public class Two {

	// a.
	public static int[] mystery1(int[] list) {
		int[] result = new int[2 * list.length];
		for (int i = 0; i < list.length; i++) {
			result[2 * i] = list[i] / 2 + list[i] % 2;
			result[2 * i + 1] = list[i] / 2;
		}
		return result;
	}

	// b.
	public static void mystery2(int[] list) {
		for (int i = 0; i < list.length / 2; i++) {
			int j = list.length - 1 - i;
			int temp = list[i];
			list[i] = list[j];
			list[j] = temp;
		}
	}

	// c.
	public static void mystery3(List<String> list) {
		for (int i = 0; i < list.size() - 1; i += 2) {
			String first = list.remove(i);
			list.add(i + 1, first);
		}
	}

	// d.
	public static void mystery4(List<String> list) {
		for (int i = 0; i < list.size() - 1; i += 2) {
			String first = list.get(i);
			list.set(i, list.get(i + 1));
			list.set(i + 1, first);
		}
	}
}
