package main;

import educational.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum();
	}
	
public static void sum(){
	// 1. Write a method called sum that returns the sum of the data values stored 
	// in the tree.

	IntTree run = new IntTree(5);
	//run.printSideways();
	//run.printPreorder();
	//run.printInorder();
	//run.printPostorder();
	System.out.println(run.sum());
}
	

//	2. Write a method called countLeftNodes that returns the number of left children in the tree. A left child is a node
//	that appears as the root of the left-hand subtree of another node. For example, reference tree #1 has 3 left children
//	(the nodes storing the values 5, 1, and 4).
//	3. Write a method called countEmpty that returns the number of empty branches in a tree. An empty tree is considered to
//	have one empty branch (the tree itself). For nonempty trees, your methods should count the total number of
//	empty branches among the nodes of the tree. A leaf node has two empty branches, a node with one nonempty child
//	has one empty branch, and a node with two nonempty children has no empty branches. For example, reference tree
//	#1 has 7 empty branches (two under the value 1, one under 5, and two under each of 4 and 6.)
//	4. Write a method called depthSum that returns the sum of the values stored in a binary tree of integers weighted by
//	the depth of each value. The method should return the value at the root, plus 2 times the values stored at the next
//	level of the tree, plus 3 times the values stored at the next level of the tree, and so on. For example, the depth sum of
//	reference tree #1 would be computed as (1 * 3) + (2 * (5 + 2)) + (3 * (1 + 4 + 6)) = 50.
//	5. Write a method called countEvenBranches that returns the number of branch nodes in a binary tree that contain
//	even numbers. A branch node has one or two children (i.e., it is not a leaf). For example, if a variable t refers to
//	reference tree #2, then the call t.countEvenBranches() should return 3 because there are three branch nodes
//	with even values (2, 8, and 6). Notice that leaf nodes with even values are not included (the nodes storing 0 and 4).
//	6. Write a method called printLevel that accepts an integer parameter n and prints the values at level n from
//	left to right, one per line. We will use the convention that the overall root is at level 1, its children are at level 2,
//	and so on. If there are no values at the level, your method should produce no output. Your method should throw an
//	IllegalArgumentException if it is passed a value for a level that is less than 1. For example, if a variable t
//	refers to reference tree #2, then the call of t.printLevel(3); would produce the following output:
//	0
//	7
//	6
//	7. Write a method called printLeaves that prints to System.out the leaves of a binary tree from right to
//	left. More specifically, the leaves should be printed in the reverse order that they would be printed using any
//	of the standard traversals. If the tree is empty, your method should produce the output "no leaves". For example,
//	if a variable t refers to reference tree #2, the call of t.printLeaves(); should produce the
//	following output:
//	leaves: 0 4 9
//	8. Write a method called isFull that returns true if a binary tree is full and false if it is not. A full binary tree is
//	one in which every node has 0 or 2 children. For example, reference trees #1 and #2 are not full, but #3 is full. By
//	definition, the empty tree is considered full.
//	9. Write a toString method for a binary tree of integers. The method should return "empty" for an empty tree. For a
//	leaf node, it should return the data in the node as a string. For a branch node, it should return a parenthesized
//	String that has three elements separated by commas: the data at the root, a string representation of the left subtree,
//	and then a string representation of the right subtree. For example, if a variable t refers to reference tree #2, then the
//	call t.toString() should return the following String (without the surrounding quotes):
//	"(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))"
//	Exercises 1031
//	10. Write a method called equals that accepts another binary tree of integers as a parameter and compares the two trees
//	to see whether they are equal to each other. For example, if variables of type IntTree called t1 and t2 have been
//	initialized, then t1.equals(t2) will return true if the trees are equal and false otherwise. Two empty trees are
//	considered to be equal to each other.
}
