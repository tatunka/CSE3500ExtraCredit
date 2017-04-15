package search;

public class SimpleShortest {
	
	public static Point[] simpleFind(Graph g, int number){
		System.out.print("For " + number + " points: ");
		long start = System.nanoTime();
		Point[] sPoints = new Point[2];
		Double shortest = 999999999999999999999999999999999999999.9;
		Point s1 = null;
		Point s2 = null;
		for(int i=0; i<number; i++){
			Point p1 = g.getPoint(i);
			for(Point p2 : g){
				if(p1.equals(p2))
					continue;
				double distance = g.distance(p1, p2);
				if(distance < shortest){
					shortest = distance;
					s1 = p1;
					s2 = p2;
				}
			}
		}
		sPoints[0] = s1;
		sPoints[1] = s2;
		long stop = System.nanoTime();
		long elapsed = stop - start;
		System.out.println(elapsed + " ns");
		return sPoints;
	}
}
