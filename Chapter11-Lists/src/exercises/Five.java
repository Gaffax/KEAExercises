package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Five {
//	5. Write a method called sortAndRemoveDuplicates that 
//	accepts a list of integers as its parameter and rearranges
//	the list’s elements into sorted ascending order, as well as 
//	removing all duplicate values from the list. For example,
//	the list (7, 4, –9, 4, 15, 8, 27, 7, 11, –5, 32, –9, –9) would 
//	become (–9, –5, 4, 7, 8, 11,
//	15, 27, 32) after a call to your method. Use a Set as part of 
//	your solution.
	
	public void sortAndRemoveDublicates(List<Integer> list){
		
		Set hashSet = new HashSet<Integer>();

		List<Integer> orderedList = new ArrayList<Integer>();
		
		int number;
		
		for (Integer numbersInList : list) {
			hashSet.add(numbersInList);
		}
		
		Iterator<Integer> itr = hashSet.iterator();
		
		while(itr.hasNext()){
			number = itr.next();
			
			orderedList.add(number);
		}

		Collections.sort(orderedList);//From the static collections. It's fucking awesome!
		
		for(Integer allNumbers : orderedList){
			System.out.println(allNumbers);
		}

	}
	
}
