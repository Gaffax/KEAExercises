package exercises;
import java.util.ArrayList;
import java.util.List;


public class Two_AlternateList {

	/*
	2. Write a method called alternate that accepts two Lists as its parameters and returns a new List containing alternating
	elements from the two lists, in the following order:
	• First element from first list
	• First element from second list
	• Second element from first list
	• Second element from second list
	• Third element from first list
	• Third element from second list
	• . . .
	If the lists do not contain the same number of elements, the remaining elements from the longer list should be placed
	consecutively at the end. For example, for a first list of (1, 2, 3, 4, 5) and a second list of (6, 7, 8, 9,
	10, 11, 12), a call of alternate(list1, list2) should return a list containing (1, 6, 2, 7, 3, 8, 4, 9,
	5, 10, 11, 12).
	 */

	public List<Integer> spliceLists(List<Integer> firstList, List<Integer> secondList){
		//Initiating variables
		List<Integer> splicedList = new ArrayList<Integer>();
		int largestList;
		int firstListSize = firstList.size();
		int secondListSize = secondList.size();

		//Compare list sizes and set iterator counter to the largest list
		if(firstListSize >= secondListSize){
			largestList = firstListSize;
		}else{
			largestList = secondListSize;
		}


		//Splice the two lists
		for(int i = 0; i < largestList; i++){

			if(i < firstListSize){
				splicedList.add(firstList.get(i));			
			} else{
			}
			if(i < secondListSize){
				splicedList.add(secondList.get(i));
			}	else{
			}
		}


		return splicedList;
	}
}
