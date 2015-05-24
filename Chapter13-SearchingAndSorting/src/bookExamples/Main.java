package bookExamples;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		// pointComparatorTest();
		// pointComparatorReverseTest();
		CompareLengths();
	}

	public static void pointComparatorTest() {
		Point[] points = { new Point(4, -2), new Point(3, 9),
				new Point(-1, 15), new Point(3, 7) };
		// It’s important to understand that we are creating a separate class as
		// our comparator;
		// we are not modifying the Point class itself. This is one of the main
		// benefits of comparators:
		// you don’t need to modify the class being ordered.
		Arrays.sort(points, new PointComparator());

		for (Point point : points) {
			System.out.println(point);
		}
	}

	public static void pointComparatorReverseTest() {
		Point[] points = { new Point(4, -2), new Point(3, 9),
				new Point(-1, 15), new Point(3, 7) };

		Arrays.sort(points, Collections.reverseOrder(new PointComparator()));

		for (Point point : points) {
			System.out.println(point);
		}
	}

	// compares String objects by length
	public static void CompareLengths() {

		// sort Strings using case-insensitive Comparator
		String[] strings = { "Foxtrot", "alpha", "echo", "golf", "bravo",
				"hotel", "Charlie", "DELTA" };

		Arrays.sort(strings, new LengthComparator());
		System.out.println(Arrays.toString(strings));
	}
}
