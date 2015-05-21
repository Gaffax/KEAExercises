import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] someValues = { "Test1", "Tests1", "Test1", "Tests1", "Test1",
				"Tests1", "Test1", "Test1s", "Test1", "Tests1" };
		List linkedList = new LinkedList<String>();
		for (String value : someValues) {
			linkedList.add(value);
		}

		System.out.println(removeEvenLength(linkedList));
	}

	// removes all strings of even length from the given linked list
	public static List removeEvenLength(List<String> list) {
		
		Iterator<String> i = list.iterator();//Take the list, and "apply" an iterator.
		while (i.hasNext()) {
			String element = i.next();
			if (element.length() % 2 == 0) {
				i.remove();
			}
		}
		return list;
	}
}
