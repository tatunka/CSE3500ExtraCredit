package search;

import java.util.Comparator;

public class PxComp implements Comparator<Point>{

	/**
	 * Comapres two points by x coordinate value
	 */
	@Override
	public int compare(Point p1, Point p2){
		double x1 = p1.getX();
		double x2 = p2.getX();
		if(x1 < x2) return 1;
		else if(x1 > x2) return -1;
		else return 0;
	}

}
