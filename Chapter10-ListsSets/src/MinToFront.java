import java.util.ArrayList;
import java.util.List;


public class MinToFront {
	/*
	6. Write a method called minToFront that takes an ArrayList of integers as a parameter and moves the minimum
	value in the list to the front, otherwise preserving the order of the elements. For example, if a variable called list
	stores (3, 8, 92, 4, 2, 17, 9), the value 2 is the minimum, so your method should modify the list to store the values
	(2, 3, 8, 92, 4, 17, 9).
	*/
	public void minToFront(List<Integer> input){

		List<Integer> output = new ArrayList<Integer>();
		
		
		Integer minimumValue = 2;
		int highestValue = 1;
		
		for(Integer subInput: input){
			if(subInput > highestValue){
				highestValue = subInput;
			}
		}
		
		for(int i = 0; i <= highestValue; i++){
			for(Integer subInput : input){
				if(minimumValue == subInput){
					output.add(subInput);
				}
			}
			minimumValue++;
		}
		System.out.println(output);
	}
}
