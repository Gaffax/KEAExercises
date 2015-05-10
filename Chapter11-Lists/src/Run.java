import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exercises.ExFour;
import exercises.ExThree;
import exercises.ExTwo_AlternateList;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//runExTwo(); //sysout one merged list.
		//runExThree();
		
	}

	
	public static void runExTwo(){
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
		List<Integer> listOne = new ArrayList<Integer>();
		for(int i = 1; i <= 5; i++){
		listOne.add(i);
		}
		
		
		List<Integer> listTwo = new ArrayList<Integer>();
		for(int i = 6; i <= 12; i++){
		listTwo.add(i);
		}
		
		ExTwo_AlternateList splicedList = new ExTwo_AlternateList();
		
		System.out.print(splicedList.spliceLists(listOne, listTwo));
	}
	
	
	public static void runExThree(){
//		3. Write a method called removeInRange that accepts four parameters: a LinkedList, an element value, a starting
//		index, and an ending index. The method’s behavior is to remove all occurrences of the given element that appear in
//		the list between the starting index (inclusive) and the ending index (exclusive). Other values and occurrences of the
//		given value that appear outside the given index range are not affected.
//		For example, for the list (0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16), a call of
//		removeInRange(list, 0, 5, 13) should produce the list (0, 0, 2, 0, 4, 6, 8, 10, 12, 0, 14, 0, 16).
//		Notice that the zeros located at indexes between 5 inclusive and 13 exclusive in the original list (before any modifications
//		were made) have been removed.
		
		int[] arrayOfInts = {0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16};
		
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < arrayOfInts.length; i++){
			list.add(arrayOfInts[i]);
		}
		
		ExThree removeInRange = new ExThree();
		removeInRange.removeInRange(list, 0, 5, 13);
	}
	
	public static void runExFour(){
//		4. Write a method called partition that accepts a list of integers and an integer value E as its parameter, and rearranges
//		(partitions) the list so that all the elements with values less than E occur before all elements with values greater than E.
//		The exact order of the elements is unimportant, so long as all elements less than E appear before all elements greater than
//		E. For example, for the linked list (15, 1, 6, 12, –3, 4, 8, 21, 2, 30, –1, 9), one acceptable ordering of
//		the list after a call of partition(list, 5) would be (–1, 1, 2, 4, –3, 12, 8, 21, 6, 30, 15, 9). You
//		may assume that the list contains no duplicates and does not contain the element value E.

		int[] arrayOfInts = {15, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9};
		int valueE = 5;
		
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < arrayOfInts.length; i++){
			list.add(arrayOfInts[i]);
		}
		
		ExFour partition = new ExFour();
		partition.partition(list, valueE);
	

	}
}
