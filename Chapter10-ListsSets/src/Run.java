import java.util.ArrayList;
import java.util.List;






public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ex10_1_avarageVovels();
		//ex10_2_swapPairs();
		//ex10_3_removeEvenLenght();
		//ex10_4_doubleList();
		//ex10_5_scaleByK();
		ex10_6_minToFront();
	}

	public static void ex10_1_avarageVovels(){
		/*
		1. Write a method called averageVowels that takes an ArrayList of Strings as a parameter and returns the average
		number of vowel characters (a, e, i, o, u) in all Strings in the list. If your method is passed an empty ArrayList, it
		should return 0.0.
		*/
		
		AvarageVovels run = new AvarageVovels();
		List<String> input = new ArrayList<String>();
		
		input.add("This is a test");
		input.add("We sing during this test");
		input.add("AAAAALL hail Britania!");
		input.add("Britania rules the waves!");
		
		System.out.print(run.avarageVovels(input));
		
	}
	
	public static void ex10_2_swapPairs(){
		/*
		2. Write a method called swapPairs that switches the order of values in an ArrayList of Strings in a pairwise
		fashion. Your method should switch the order of the first two values, then switch the order of the next two, then the
		next two, and so on. If the number of values in the list is odd, the method should not move the final element. For
		example, if the list initially stores (“to”, “be”, “or”, “not”, “to”, “be”, “hamlet”), your method should change the
		list’s contents to (“be”, “to”, “not”, “or”, “be”, “to”, “hamlet”).
		*/
		
		SwapPairs run = new SwapPairs();
		List<String> input = new ArrayList<String>();
		
		
		input.add("to");
		input.add("be");
		input.add("or");
		input.add("not");
		input.add("to");
		input.add("be");
		input.add("hamlet");
		
		run.swapPairs(input);
		
	}
	
	public static void ex10_3_removeEvenLenght(){
		/*
		3. Write a method called removeEvenLength that takes an ArrayList of Strings as a parameter and removes all of
		the Strings of even length from the list.
		*/
		
		RemoveEvenLenght run = new RemoveEvenLenght();
		List<String> input = new ArrayList<String>();
		
		
		input.add("one");
		input.add("two");
		input.add("three");
		input.add("four");
		input.add("five");
		input.add("six");
		input.add("seven");
		input.add("eight");
		input.add("nine");
		
		run.removeEvenLength(input);
	}
	
	public static void ex10_4_doubleList(){
		/*
		4. Write a method called doubleList that takes an ArrayList of Strings as a parameter and replaces every String
		with two of that same String. For example, if the list stores the values (“how”, “are”, “you?”) before the method is
		called, it should store the values (“how”, “how”, “are”, “are”, “you?”, “you?”) after the method finishes executing.
		*/
		
		DoubleList run = new DoubleList();
		List<String> input = new ArrayList<String>();
		
		
		input.add("how");
		input.add("are");
		input.add("you");
		
		run.doubleList(input);
	}
	
	public static void ex10_5_scaleByK(){
	/*
	5. Write a method called scaleByK that takes an ArrayList of integers as a parameter and replaces every integer of
	value K with K copies of itself. For example, if the list stores the values (4, 1, 2, 0, 3) before the method is called, it
	should store the values (4, 4, 4, 4, 1, 2, 2, 3, 3, 3) after the method finishes executing. Zeroes and negative numbers
	should be removed from the list by this method.
	*/

	ScaleByK run = new ScaleByK();
	
	List<Integer> input = new ArrayList<>();
	
	//input.add(0); 
	input.add(4);
	input.add(1);
	//input.add(0);
	input.add(2);
	input.add(0);
	input.add(3);
	input.add(0);
	
	run.scaleByK(input);
	
	
	
	}
	
	public static void ex10_6_minToFront(){
	/*
	6. Write a method called minToFront that takes an ArrayList of integers as a parameter and moves the minimum
	value in the list to the front, otherwise preserving the order of the elements. For example, if a variable called list
	stores (3, 8, 92, 4, 2, 17, 9), the value 2 is the minimum, so your method should modify the list to store the values
	(2, 3, 8, 92, 4, 17, 9).
	*/
	
		MinToFront run = new MinToFront();
		
		List<Integer> input = new ArrayList<Integer>();
		
		input.add(3);
		input.add(8);
		input.add(92);
		input.add(4);
		input.add(2);
		input.add(17);
		input.add(9);

		run.minToFront(input);
		
	}
}
