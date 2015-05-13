import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exercises.*;



public class Run {

	public static void main(String[] args) {

//		Read me.
//		To run the exercise. Uncomment the exercise you want to run.
//		The statics in the main, are used for setting up informations
//		that are passed to the class. The classes contain the actual
//		exercise solution.

		
		
		//runExTwo(); //sysout one merged list.
		//runExThree();
		//runExFour(2);//Comes in two solutions solution 1 does not allow duplicates and solution 2 allows duplicates.
		//runExFive();
		//runExSix();
		runExSeven();
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
	
	public static void runExFour(int runSolution){
//		4. Write a method called partition that accepts a list of integers and an integer value E as its parameter, and rearranges
//		(partitions) the list so that all the elements with values less than E occur before all elements with values greater than E.
//		The exact order of the elements is unimportant, so long as all elements less than E appear before all elements greater than
//		E. For example, for the linked list (15, 1, 6, 12, –3, 4, 8, 21, 2, 30, –1, 9), one acceptable ordering of
//		the list after a call of partition(list, 5) would be (–1, 1, 2, 4, –3, 12, 8, 21, 6, 30, 15, 9). You
//		may assume that the list contains no duplicates and does not contain the element value E.

		int[] arrayOfInts = {15, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9, 1, 6, 12, -3, 4, 8, 21, 2, 30, -1, 9};
		int valueE = 5;
		
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < arrayOfInts.length; i++){
			list.add(arrayOfInts[i]);
		}
		
		ExFour partition = new ExFour();
		
		if(runSolution == 1){
		partition.partitionSetSolution(list, valueE);//Does not allow duplicates
		} else if (runSolution == 2){
		partition.partitionLinkedListSolution(list, valueE); //Allows duplicates
		} else {
			System.out.println("Hey dude. \n You need to pass either 1 or 2 into the static method. \n Not that hard.");
		}
	}
	
	public static void runExFive (){
//		5. Write a method called sortAndRemoveDuplicates that 
//		accepts a list of integers as its parameter and rearranges
//		the list’s elements into sorted ascending order, as well as 
//		removing all duplicate values from the list. For example,
//		the list (7, 4, –9, 4, 15, 8, 27, 7, 11, –5, 32, –9, –9) would 
//		become (–9, –5, 4, 7, 8, 11,
//		15, 27, 32) after a call to your method. Use a Set as part of 
//		your solution.
		
		int[] arrayOfInts = {7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9};
		
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < arrayOfInts.length; i++){
			list.add(arrayOfInts[i]);
		}
		
		ExFive run = new ExFive();
		
		run.sortAndRemoveDublicates(list);
	}
	
	public static void runExSix(){
//		6. Write a method countUnique that accepts a list of integers as
//		a parameter and returns the number of unique integer
//		values in the list. Use a set as auxiliary storage to help you 
//		solve this problem. For example, if a list contains the values
//		(3, 7, 3, –1, 2, 3, 7, 2, 15, 15), your method should return 5. 
//		The empty list contains 0 unique values.
		
		int[] arrayOfInts = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
		
		ExSix run = new ExSix();
		
		run.countUnique(arrayOfInts);
		
	}
	
	public static void runExSeven(){
//		7. Write a method countCommon that accepts two lists 
//		of integers as parameters and returns the number of 
//		unique integers
//		that occur in both lists. Use one or more sets as 
//		storage to help you solve this problem. For example, 
//		if one list contains the values 
//		(3, 7, 3, –1, 2, 3, 7, 2, 15, 15) and the 
//		other list contains the values
//		(–5, 15, 2, –1, 7, 15, 36), your method should return 
//		4 because the elements –1, 2, 7, and 15 occur in both lists.

		int[] arrayOfIntsOne = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
		int[] arrayOfIntsTwo = {-5, 15, 2, -1, 7, 15, 36};
		
		ExSeven run = new ExSeven();
		
		run.countCommon(arrayOfIntsOne, arrayOfIntsTwo);
	
	}
	
}
