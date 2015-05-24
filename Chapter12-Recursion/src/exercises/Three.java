package exercises;

public class Three {
	// 3. Write a method called writeSequence that accepts an integer n
	// as a parameter and prints to the console a symmetric
	// sequence of n numbers composed of descending integers that ends in 1,
	// followed by a sequence of ascending
	// integers that begins with 1. The following table indicates the output
	// that
	// should be produced for various values of n:
	// Method call Output produced
	// -----------------------------------------
	// writeSequence(1); 1
	// writeSequence(2); 1 1
	// writeSequence(3); 2 1 2
	// writeSequence(4); 2 1 1 2
	// writeSequence(5); 3 2 1 2 3
	// writeSequence(6); 3 2 1 1 2 3
	// writeSequence(7); 4 3 2 1 2 3 4
	// writeSequence(8); 4 3 2 1 1 2 3 4
	// writeSequence(9); 5 4 3 2 1 2 3 4 5
	// writeSequence(10); 5 4 3 2 1 1 2 3 4 5
	// Notice that when n is odd the sequence has a single 1 in the middle,
	// while for even values it has two 1s in the
	// middle. Your method should throw an IllegalArgumentException if it
	// is passed a value less than 1.

	public String writeSequence(int n) {

		if (n < 0)
			throw new IllegalArgumentException();

		else if (n == 1) // Base case
			return "1 ";

		else if (n == 2)
			return "1 1 ";	// Without this, the second recursive call will 
							// fail, due to the IllegalArgumentExeption. 
							// Because n is going to be less than 0.
		else {
			int j = (n + 1) / 2;		//Recursive step
			String sequence = j + " ";

			sequence += writeSequence(n - 2);
			sequence += j + " ";
			return sequence;
		}
	}
}
