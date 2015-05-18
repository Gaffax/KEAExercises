package searchandsort;

import java.util.Arrays;

//1. Suppose the following array has been declared:
//	// index 0 1 2 3 4 5 6 7 8 9
//	int[] list = {–2, 8, 13, 22, 25, 25, 38, 42, 51, 103};
//	What indexes will be examined as the middle element by a binary search for each of the following target values?
//	What value will be returned?
//	a. 103
//	b. 30
//	c. 8
//	d. –1

public class One {
	public void binarySearch(int... values){
		
		int[] list = {-2, 8, 13, 22, 25, 25, 38, 42, 51, 103};
		int letter = 65;
		for(int i : values){
			System.out.println("Question " + (char)letter + ": " + Arrays.binarySearch(list, i));
			letter++;
		}
	}
}
