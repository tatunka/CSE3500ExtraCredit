package test;

import search.Graph;
import search.Point;

public class DistanceTest {
	public static void main(String[] arg){
		Graph g = new Graph();
		Point p1 = new Point(0.0, 0.0);
		Point p2 = new Point(3.0, 0.0);
		Point p3 = new Point(4.0, 4.0);
		Point p4 = new Point(16.0, 16.0);
		
		System.out.println(Graph.distance(p1, p2));
		System.out.println(Graph.distance(p1, p3));
		System.out.println(Graph.distance(p1, p4));
		System.out.println(Graph.distance(p2, p3));
		
	}
}
