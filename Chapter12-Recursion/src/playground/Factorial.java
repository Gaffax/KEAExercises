package playground;

public class Factorial {

	public static void main(String[] args) {
		Calculation obj_one = new Calculation();

		int a = obj_one.fact(4);
		System.out.println("The factorial of the number is : " + a);

	}
}

class Calculation {
	public int fact(int n) {
		int result;

		if (n == 1) // Base case
			return 1;

		result = fact(n - 1) * n; // Recursive step
		return result;
	}
}

class anotherFactorial {

	public int Factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * Factorial(n - 1);
	}
}