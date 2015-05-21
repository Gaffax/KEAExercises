package bookExamples;

import java.awt.Point;
import java.util.Comparator;
//It’s important to understand that we are creating a separate class as our comparator;
//we are not modifying the Point class itself. This is one of the main benefits of comparators:
//you don’t need to modify the class being ordered.

public class PointComparator implements Comparator<Point> {
	public int compare(Point p1, Point p2) {
		int dx = p1.x - p2.x;
		if (dx == 0) {
			int dy = p1.y - p2.y;
			return dy;
		} else {
			return dx;
		}
	}
}