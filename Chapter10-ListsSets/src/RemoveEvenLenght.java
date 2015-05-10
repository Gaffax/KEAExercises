import java.util.List;
/*
3. Write a method called removeEvenLength that takes an ArrayList of Strings as a parameter and removes all of
the Strings of even length from the list.
*/
public class RemoveEvenLenght {
	public void removeEvenLength(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() % 2 == 0) { //Current element divided by two = zero
				list.remove(i);//Remove that index
				i--;//Reduce i to prevent skipping one value
			}
		}
		System.out.println(list);
	}
}