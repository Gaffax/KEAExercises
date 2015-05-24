import java.util.ArrayList;
import java.util.List;

/*
5. Write a method called scaleByK that takes an ArrayList of integers as a parameter and replaces every integer of
value K with K copies of itself. For example, if the list stores the values (4, 1, 2, 0, 3) before the method is called, it
should store the values (4, 4, 4, 4, 1, 2, 2, 3, 3, 3) after the method finishes executing. Zeroes and negative numbers
should be removed from the list by this method.
*/

public class ScaleByK {

	public void scaleByK(List<Integer> input){
		List<Integer> newArray = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++)
		{
		    int number = input.get(i);
		    for(int j = 0; j<number; j++)
		    {
			newArray.add(number);
		    }
		}
		System.out.println(newArray);
	    }
	}
	
	
	/*
	 // Dead end approach. Abondon ship.
	 // Thing is, I try to manipulate with data inside an array that is being looped through
	 // It was somewhat possible to circumvent it in the "if" conditionizeren with an iterator.
	 // But I encounter the same problem in the else conditionizeren.
	 // I am convinced that it is indeed possible to do it like this, but after having seen Nichs code
	 // I became conviced that this approach is simply to much trouble.

	public void scaleByK(List<Integer> input){
		
		int i = 0;
		int repeat = 0;
		for (Iterator<Integer> iterator = input.iterator(); iterator.hasNext();)
		{
			Integer currentValue = iterator.next();
			if (currentValue == 0) 
			{
				iterator.remove();
				i--;
			} 
			else {
				
				repeat = input.get(i);
				for(int j = 1; j < repeat; j++){
					input.add(i, currentValue);;
				}

			}
			System.out.println(input);
		}
		System.out.println(input);
	}
	 */
