package search;

import java.util.Comparator;

public class PyComp implements Comparator<Point>{

	/**
	 * compares two points by y coordinate value
	 */
	@Override
	public int compare(Point p1, Point p2) {
		double y1 = p1.getY();
		double y2 = p2.getY();
		if(y1 < y2) return 1;
		else if(y2 < y1) return -1;
		else return 0;
	}

}
