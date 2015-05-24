package playground;

public class TowersOfHanoi {

	public static int counter = 0;

	public static void main(String[] args) {
		int nDisks = 1;
		doTowers(nDisks, 'A', 'B', 'C'); // The char represents the pillars.
		System.out.println("The puzzle was done in " + counter + " moves.");
	}

	public static void doTowers(int topN, char from, char inter, char to) {
		counter++;

		if (topN < 0)
			throw new IllegalArgumentException();
		else if (topN == 1)
			System.out.println("Disk 1 from " + from + " to " + to);
		else {
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to);
		}
	}
}
