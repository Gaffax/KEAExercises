package main;

import java.util.HashSet;
import java.util.Set;

import chapter17trees.IntTreeNode;

public class IntTree
{

	private static IntTreeNode overallRoot;
	private Set<IntTreeNode> set = new HashSet<IntTreeNode>();

	public static void main(String[] args)
	{
		IntTree tree = new IntTree(5);

		 //Question 1
		 System.out.println(tree.sum());
		// Question 2
		 System.out.println(tree.countLeftNodes());
		// Question 3
		 System.out.println(tree.countEmpty());
		 //Question 4
		 System.out.println(tree.depthSum());

		//System.out.println(tree.getLevel());
		//System.out.println(tree.getLevel(overallRoot));

		// tree.printSideways();

	}

	/*
	 * Question 1. Helper Method. As far as I understand its sole purpose is to
	 * simplify the public method to prevent them from having to input
	 * unnecessary parameters into the method. so sum(); instead of
	 * sum(overallroot);
	 */
	public int sum()
	{
		return sum(overallRoot);
	}

	/*
	 * Question 1. If there is no root, then tree is empty and you can just
	 * return 0.
	 * 
	 * If however there is a root we want to return data + the data in the left
	 * and right nodes. Or leaves. I guess the method itself keeps track of what
	 * the result of the calculation is.
	 */
	public int sum(IntTreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			return root.data + sum(root.left) + sum(root.right);
		}
	}

	/*
	 * Question 2 return number of left children in the tree.
	 */
	public int countLeftNodes()
	{
		return countLeftNodes(overallRoot);
	}

	private int countLeftNodes(IntTreeNode root)
	{
		int count = 0;

		if (root == null)
		{
			return 0;
		}
		if (root.left != null)
		{
			count += 1 + countLeftNodes(root.left);
		}
		if (root.right != null)
		{
			/*
			 * whats with the count += here? When calling the method it returns
			 * the previous count, adds it to the current count (of 0) Otherwise
			 * it would just override it meaning if the last node traveresed was
			 * left it would return 1 but if the last node traveresed was right
			 * it would return 0?
			 */
			count += countLeftNodes(root.right);
		}
		return count;

	}

	/*
	 * Question 3 return number of empty branches in a tree Stupid bastard of a
	 * method was visiting some branches multiple times. Had to add each root to
	 * a set and check to make sure I hadn't already counted that nodes
	 * branches.
	 */
	private int countEmpty()
	{
		return countEmpty(overallRoot);
	}

	private int countEmpty(IntTreeNode root)
	{
		int count = 0;

		if (root == null)
		{
			return 0;
		}
		// this node doesn't have any branches.
		if (root.right == null && root.left == null)
		{
			// want to make sure we don't count the node twice.
			if (!set.contains(root))
			{
				count += 2;
				set.add(root); // now that we've counted the root, we add it to
								// the set.
			}

		}
		// this node has a child on the left.
		if (root.right == null && root.left != null)
		{
			if (set.contains(root))
			{
				count += countEmpty(root.left);// we've already visited here but
												// still need to 
												// traverse the
												// tree
			}
			else
			{
				count += 1 + countEmpty(root.left);
				// we count this node and continue traversing.
				// we know there are no values on the right, so we don't have to
				// go there.
				set.add(root);
			}

		}
		if (root.left == null && root.right != null)
		{
			if (set.contains(root))
			{
				count += countEmpty(root.right);
			}
			else
			{
				count += 1 + countEmpty(root.right);
				set.add(root);
			}
		}
		// node has two children
		else
		{
			count += countEmpty(root.left); // first we traverse the left
			count += countEmpty(root.right); // then we traverse the right
		}

		return count;
	}

	// pre : max > 0
	// post: constructs a sequential tree with given number of
	// nodes
	public IntTree(int max)
	{
		if (max <= 0)
		{
			throw new IllegalArgumentException("max: " + max);
		}
		overallRoot = buildTree(1, max);
	}

	public IntTree()
	{

	}

	// post: returns a sequential tree with n as its root unless
	// n is greater than max, in which case it returns an
	// empty tree
	/*
	 * Question 4: Returns the sum of values stored in a binary tree of integers
	 * weighted by the depth of each value
	 */
	private int depthSum()
	{
		return depthSum(overallRoot, 1); //recursive method will deal with incrementing the level later. 
	}

	private int depthSum(IntTreeNode root, int someDepth)
	{

		if(root == null)
		{
			return 0;
		}
		else{
			
			return someDepth * root.data + 
				       depthSum(root.left, someDepth+1) +
				       depthSum(root.right, someDepth+1);
		}
			
		
	}

	@SuppressWarnings("unused")
	private int getLevel(IntTreeNode root)
	{
		return getLevel(overallRoot, root);
	}



	private int getLevel(IntTreeNode overallRoot, IntTreeNode root)
	{
		int level = 0;
		if(overallRoot == null)
		{
			return -1;
		}
		else if(overallRoot.data == root.data )
		{
			return level +1;
		}
		else if(overallRoot.data < root.data)
		{
			return 1 + getLevel(overallRoot.left, root);
		}
		else
		{
			return 1 + getLevel(overallRoot.right, root);
		}
		

	}

	private IntTreeNode buildTree(int n, int max)
	{
		if (n > max)
		{
			return null;
		}
		else
		{
			return new IntTreeNode(n, buildTree(2 * n, max), buildTree(
					2 * n + 1, max));
		}
	}

	// post: prints the tree contents using a preorder traversal
	public void printPreorder()
	{
		System.out.print("preorder:");
		printPreorder(overallRoot);
		System.out.println();
	}

	// 1000 Chapter 17 Binary Trees

	// post: prints in preorder the tree with given root
	private void printPreorder(IntTreeNode root)
	{
		if (root != null)
		{
			System.out.print(" " + root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	// post: prints the tree contents using an inorder traversal
	public void printInorder()
	{
		System.out.print("inorder:");
		printInorder(overallRoot);
		System.out.println();
	}

	// post: prints in inorder the tree with given root
	private void printInorder(IntTreeNode root)
	{
		if (root != null)
		{
			printInorder(root.left);
			System.out.print(" " + root.data);
			printInorder(root.right);
		}
	}

	// post: prints the tree contents using a postorder traversal
	public void printPostorder()
	{
		System.out.print("postorder:");
		printPostorder(overallRoot);
		System.out.println();
	}

	// post: prints in postorder the tree with given root
	private void printPostorder(IntTreeNode root)
	{
		if (root != null)
		{
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(" " + root.data);
		}
	}

	// post: prints the tree contents, one per line, following an
	// inorder traversal and using indentation to indicate
	// 17.3 Common Tree Operations 1001
	// node depth; prints right to left so that it looks
	// correct when the output is rotated.
	public void printSideways()
	{
		printSideways(overallRoot, 0);
	}

	// post: prints in reversed preorder the tree with given
	// root, indenting each line to the given level
	private void printSideways(IntTreeNode root, int level)
	{
		if (root != null)
		{
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++)
			{
				System.out.print(" ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}
}
