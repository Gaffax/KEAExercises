package exercises;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ExFour {
	// 4. Write a method called partition that accepts a list of integers
	// and an integer value E as its parameter, and rearranges
	// (partitions) the list so that all the elements with values less than
	// E occur before all elements with values greater than E.
	// The exact order of the elements is unimportant, so long as all elements
	// less
	// than E appear before all elements greater than
	// E. For example, for the linked list (15, 1, 6, 12, –3, 4, 8, 21, 2, 30,
	// –1, 9),
	// one acceptable ordering of
	// the list after a call of partition(list, 5) would be (–1, 1, 2, 4, –3,
	// 12, 8, 21,
	// 6, 30, 15, 9). You
	// may assume that the list contains no duplicates and does not contain the
	// element value E.

	public void partitionLinkedListSolution(List<Integer> list, int ValueE) {

		Iterator<Integer> itr = list.iterator();
		List<Integer> tempList = new LinkedList<Integer>();
		int number;

		while (itr.hasNext()) {

			number = itr.next();

			if (number < ValueE) {
				System.out.println(number);
				itr.remove();
			} else {
				tempList.add(number);
			}
		}

		for (Integer remainingNumbers : tempList) {
			System.out.println(remainingNumbers);
		}

	}

	public void partitionSetSolution(List<Integer> list, int valueE) {

		Set hashSet = new HashSet<Integer>();
		Set<Integer> tempSet = new HashSet<Integer>();
		Iterator<Integer> itr = hashSet.iterator();		
		
		for (Integer numbersInList : list) {
			hashSet.add(numbersInList);
		}
		

		while(itr.hasNext()){
			int number = itr.next();
			if(number < valueE){
				System.out.println(number);
				itr.remove();
			}else{
				tempSet.add(number);
			}
		}
		for(Integer remainingNumbers : tempSet){
			System.out.println(remainingNumbers);
		}
	}
}
