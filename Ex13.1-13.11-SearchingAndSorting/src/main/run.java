package main;

import java.util.List;
import java.util.Scanner;

import searchandsort.*;

public class run {

	public static void main(String[] args) {

		//binarySearch();
		differenceBetweenTwoWords();
	}

	public static void binarySearch() {
		// 1. Suppose the following array has been declared:
		// // index 0 1 2 3 4 5 6 7 8 9
		// int[] list = {–2, 8, 13, 22, 25, 25, 38, 42, 51, 103};
		// What indexes will be examined as the middle element by a binary
		// search
		// for each of the following target values?
		// What value will be returned?
		// a. 103
		// b. 30
		// c. 8
		// d. –1

		One solve = new One();
		solve.binarySearch(103, 30, 8, -1);
	}

	// public static void complexityClass(){

	/*
	 * I deffinetly havent understood this chapter. I need some more education
	 * on this one to grasp the concept.
	 */

	// 2. To which complexity class does each of the following algorithms
	// belong? Consider N to be the length or size of the
	// array or collection passed to the method.
	// a.
	public static int[] mystery1(int[] list) {
		int[] result = new int[2 * list.length]; // Three steps - Create list,
													// assign and mulitplication
		for (int i = 0; i < list.length; i++) {
			result[2 * i] = list[i] / 2 + list[i] % 2; // Eight steps
			result[2 * i + 1] = list[i] / 2; // Four
		}
		return result;
	}

	// Answer: O(N Log N)

	// b.

	public static void mystery2(int[] list) {
		for (int i = 0; i < list.length / 2; i++) {
			int j = list.length - 1 - i;
			int temp = list[i];
			list[i] = list[j];
			list[j] = temp;
		}
	}

	// Answer: Linear, or O(N)

	// c.
	public static void mystery3(List<String> list) {
		for (int i = 0; i < list.size() - 1; i += 2) {
			String first = list.remove(i);
			list.add(i + 1, first);
		}
	}

	// Answer: Linear, or O(N)
	// The class runtime is directly proportional with the inputed data.
	// In the block that is executed the most times, we take some data and
	// and inset it into a list and removes the initial data one iteration at a
	// time..

	// d.
	public static void mystery4(List<String> list) {
		for (int i = 0; i < list.size() - 1; i += 2) {
			String first = list.get(i);
			list.set(i, list.get(i + 1));
			list.set(i + 1, first);
		}
	}
	// Answer: Linear, or O(N)
	// The class runtime is directly proportional with the inputed data.
	// In the block that is executed the most times, we take some data and
	// and inset it into a set and removes the initial data one iteration at a
	// time..

	// }

	
	public static void question3(){
		
	// 3. Suppose the following arrays have been declared:
	// int[] numbers1 = {63, 9, 45, 72, 27, 18, 54, 36};
	// int[] numbers2 = {37, 29, 19, 48, 23, 55, 74, 12};
	// int[] numbers3 = {8, 5, –9, 14, 0, –1, –7, 3};
	// int[] numbers4 = {15, 56, 24, 5, 39, –4, 27, 10};

	// a. Write the state of the elements of each array after each pass of the
	// outermost loop of the selection sort algorithm
	// has occurred (after each element is selected and moved into place).

	// b. Trace the complete execution of the merge sort algorithm when called
	// on each array. Show the subarrays that are
	// created by the algorithm and show the merging of subarrays into larger
	// sorted arrays.
	
	/*
	 * 		//    63, 9, 45, 72, 27, 18, 54, 36}
		
		//Selection Sort
		//a.) 9,              		 63, 45, 72, 27, 18, 54, 36
		//a.) 9, 18,          		 45, 72, 27, 63, 54, 36
		//a.) 9, 18, 27,       		 72, 45, 63, 54, 36
		//a.) 9, 18, 27, 36,  		 45, 63. 54, 72
		//a.) 9,18,27,36,45   		 63, 54, 72
		//a.) 9,18,27,36,45,54       63, 72
		//a.) 9,18,27,36,45,54,63,   72
		//A.) 9,18,27,36,45,54,63,72
		
		//Merge Sort
		//b.) 9,63		45,72    18,27,  36,54
		//b.) 9,45,63,72  18,27,36,54
		//b.) 9,18,27,36,45,54,63,72
		
		
		//37, 29, 19, 48, 23, 55, 74, 12
		
		//SelectionSort
		//a.) 12,					 29,19,48,23,55,74,37
		//a.) 12,19 				 29,48,23,55,74,37
		//a.) 12,19,23,				 48,29,55,74,37
		//a.) 12,19,23,29			 48,55,74,37
		//a.) 12,19,23,29,37		 55,74,48
		//a.) 12,19,23,29,37,48   	 74,55
		//a.) 12,19,23,29,37,48,55   74
		//a.) 12,19,23,29,37,48,55,74
		
		//Merge Sort
		//29,37		19,48,  23,55   12,74
		//19,29,37,48		12,23,55,74
		//12,19,23,29,37,48,55,74
		
		
		//8, 5, –9, 14, 0, –1, –7, 3
		//SelectionSort
		//a.) -9,  					 5,8,14,0,-1,-7,3
		//a.) -9,-7,				 8,14,0,-1,5,3
		//a.) -9,-7,-1 				 14,0,8,5,3
		//a.) -9,-7,-1,0             14,8,5,3
		//a.) -9,-7,-1 ,0,3          8,5,14
		//a.) -9,-7,-1,0,3,5		 8,14
		//a.) -9,-7,-1,0,3,5,8       14
		//a.) -9,-7,-1,0,3,5,8,14
		
		//Merge Sort
		//5,8   -9,14,  -1, 0    -7,3
		//-9,5,8,14      -7,-1,0,3
		//-9,-7,-1,0,3,5,8,14
		
		
		
		//15, 56, 24, 5, 39, –4, 27, 10
		//a.)-4, 					56, 24, 5, 39, 15, 27, 10
		//a.)-4,5					24,56,39,15,27,10
		//a.)-4,5,10				56,39,15,27,24
		//a.)-4,5,10,15,			39,56,27,24
		//a.)-4,5,10,15,24			56,27,39
		//a.)-4,5,10,15,24,27		56,39
		//a.)-4,5,10,15,24,27,39	56
		//a.)-4,5,10,15,24,27,39,56
		
		//Merge Sort
		//15,56  5,24   -4,39    10,27
		//5,15,24,56	-4,10,27,39
		//-4,5,10,15,24,27,39,56
	 */
	
	}

public static void differenceBetweenTwoWords(){
	// 4. Write code to read a dictionary from a file, then prompt the user for
	// two words and tell the user how many words in
	// the dictionary fall between those two words. Here is a sample run of the
	// program:
	// Type two words: goodbye hello
	// There are 4418 words between goodbye and hello
	// Use the binary search algorithm in your solution.

	String startingWord;
	String endingWord;
	Four run = new Four();
	
	
	
	@SuppressWarnings("resource")
	Scanner userInput = new Scanner(System.in);
	System.out.println("Please input first word: ");
	startingWord = userInput.next();
	System.out.println("Please input last word: ");
	endingWord = userInput.next();
	
	
	run.howManyWordsBetween(startingWord, endingWord);
	
}
	
	// 5. Write a Comparator that compares Point objects by their distance from
	// the origin of (0, 0). Points that are closer
	// to the origin are considered to come before those which are further from
	// the origin.

	// 6. Write a Comparator that compares String objects by the number of words
	// they contain. Consider any nonwhitespace
	// string of characters to be a word. For example, “hello” comes before “I
	// see”, which comes before “You can do it”.

	// 7. Write a Comparator that compares String objects of a particular
	// format. Each string is of a form such as "123456
	// Seattle, WA", beginning with a numeric token that is followed by
	// additional text tokens. Your job is to treat the
	// first tokens as integers and compare them in numerical order. You cannot
	// simply compare them by using the strings’
	// compareTo method, since it would treat the numbers as text and not as
	// integers. For example, "276453 Helena,
	// MT" is greater than "9847 New York, NY". Use a Scanner to tokenize the
	// strings while comparing them.

	// 8. Write a modified version of the selection sort algorithm that selects
	// the largest element each time and moves it to the
	// end of the array, rather than selecting the smallest element and moving
	// it to the beginning. Will this algorithm be
	// faster than the standard selection sort? What will its complexity class
	// (big-Oh) be?

	// 9. Write a modified “dual” version of the selection sort algorithm that
	// selects both the largest and smallest elements on
	// each pass and moves each of them to the appropriate end of the array.
	// Will this algorithm be faster than the standard
	// selection sort? What predictions world you make about its performance
	// relative to the merge sort algorithm? What
	// will its complexity class (big-Oh) be?

	// 10. Implement an algorithm to shuffle an array of numbers or objects. The
	// algorithm for shuffling should be the following:
	// for (each index i) {
	// choose a random index j where j >= i.
	// swap the elements at indexes i and j.
	// }
	// (The constraint about j being greater than or equal to i is actually
	// quite important, if you want your shuffling algorithm
	// to shuffle fairly. Why?)

	// 11. Implement a “bogus” sorting algorithm called bogo sort that uses your
	// shuffling algorithm from the previous exercise
	// to sort an array of numbers. The bogo sort algorithm is the following:
	// while (array is not sorted) {
	// shuffle array.
	// }
	// Obviously, this is not a very efficient sorting algorithm, but it
	// eventually does shuffle the array into order if you let it
	// run long enough. Try running it on a very small array, such as 8 or 10
	// elements, to examine its runtime. What is your
	// best guess about the complexity class (big-Oh) of this silly algorithm?
}
