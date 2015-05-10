import java.util.List;

/*
2. Write a method called swapPairs that switches the order of values in an ArrayList of Strings in a pairwise
fashion. Your method should switch the order of the first two values, then switch the order of the next two, then the
next two, and so on. If the number of values in the list is odd, the method should not move the final element. For
example, if the list initially stores (“to”, “be”, “or”, “not”, “to”, “be”, “hamlet”), your method should change the
list’s contents to (“be”, “to”, “not”, “or”, “be”, “to”, “hamlet”).
*/

public class SwapPairs {

	public void swapPairs(List<String> input){

			for (int i = 0; i < input.size() -1 ; i+=2) {
				String temp = input.get(i);//Get current value
				input.set(i, input.get(i+1));//Get the next value
				input.set(i+1, temp);//Set current value into next index value
		}
		System.out.println(input);
	}
}
