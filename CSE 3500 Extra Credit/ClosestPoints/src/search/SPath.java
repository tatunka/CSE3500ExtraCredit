package search;

import java.util.ArrayList;
import java.util.Arrays;

public class SPath {
	
	/**
	 * Finds the shortest path between two points of a graph by looping through every
	 * possible pairing
	 * @param g		Graph
	 * @return		Points with shortest distance
	 */
	public static Point[] simpleFind(Graph g){
		Point[] sPoints = new Point[2];
		Double shortest = 999999999999999999999999999999999999999.9;	//keep track of shortest distance
		Point s1 = null;
		Point s2 = null;
		for(int i=0; i<g.length(); i++){			//for every point in g
			Point p1 = g.getPoint(i);
			for(Point p2 : g){						//for every other point in g
				if(p1.equals(p2))					//skip if node is itself
					continue;
				double distance = Graph.distance(p1, p2);		//distance between these points
				if(distance < shortest){						
					shortest = distance;						//new shortest distance if found
					s1 = p1;
					s2 = p2;
				}
			}
		}
		sPoints[0] = s1;
		sPoints[1] = s2;
		return sPoints;
	}
	
	/**
	 * Finds the minimum distance between two points in a set of Points
	 * @param p		set of Points
	 * @param n		how many points to try
	 * @return		Points with shortest distance
	 */
	private static Point[] minPoints(Point[] p, int n){
		Point[] sPoints = new Point[2];
		Double shortest = 999999999999999999999999999999999999999.9;	//keep track of shortest distance
		Point s1 = null;
		Point s2 = null;
		for(int i=0; i<p.length; i++){									//for every point in g
			for(int j=0; j<n; j++){										//for every other point in g
				if(p[i].equals(p[j]))
					continue;
				double distance = Graph.distance(p[i], p[j]);			//find distance
				if(distance < shortest){
					shortest = distance;								//new distance if found
					s1 = p[i];
					s2 = p[j];
				}
			}
		}
		sPoints[0] = s1;
		sPoints[1] = s2;
		return sPoints;
	}
	
	/**
	 * Finds minimum distance between two points in a set of Points
	 * @param p		set of Points
	 * @return		Points with minimum distance
	 */
	private static Point[] minPoints(Point[] p){
		return minPoints(p, p.length);
	}
	
	/**
	 * Recursively finds the closest Points on a graph using divide and conquer
	 * @param g			Graph
	 * @return			Points with shortest distance
	 */
	public static Point[] msClosest(Graph g){
		Point[] p = new Point[g.length()];
		p = g._graph.toArray(p);
		PxComp x = new PxComp();
		PyComp y = new PyComp();
		Point[] px = new Point[p.length];
		Point[] py = new Point[p.length];
		px = g.sort(x).toArray(px);
		py = g.sort(y).toArray(py);
		return recClosest(px, py);
	}
	
	/**
	 * Called by msClosest to divide and conquer to find two points
	 * @param px		set of Points sorted by x coordinate value
	 * @param py		set of Points sorted by y coordinate value
	 * @return			Points with shortest distance
	 */
	private static Point[] recClosest(Point[] px, Point[] py){
		PyComp y = new PyComp();
	//if |P| <= 3 then
		if(px.length <= 3 || py.length <= 3)
	//find closest pair by measuring all pairwise distances
			return minPoints(px);
	//Construct Qx, Qy, Rx, Ry	
		Point[] qx = Arrays.copyOfRange(px, 0, px.length/2);
		Point[] qy = Arrays.copyOfRange(py, 0, py.length/2);
		Point[] rx = Arrays.copyOfRange(px, px.length/2, px.length);
		Point[] ry = Arrays.copyOfRange(py, py.length/2, py.length);
	//(q*0,q*1) = Closest-Pair-Rec(Qx, Qy)
		Point[] qMin = recClosest(qx, qy);
	//(r*0,r*1) = Closest-Pair-Rec(Rx, Ry)
		Point[] rMin = recClosest(rx, ry);
	
	//d = min(d(q*0,q*1), d(r*0,r*1))
		double d = Math.min(distance(qMin), distance(rMin));
	//x* = maximum x-coordinate of a point in set Q
		double xMax = qx[qx.length-1].getX();
	//S = points in P within distance d of L
		ArrayList<Point> S = new ArrayList<Point>();
		for(Point p : px){
			if(xMax - d < p.getX())
				S.add(p);
		}
	//Construct Sy
		S.sort(y);
		Point[] sy = new Point[S.size()];
		sy = S.toArray(sy);
		
		
	//For each point s in Sy, compute distance from s to each of next 15 points in Sy
		Point[] minS = new Point[2];
		if(sy.length < 15)
			minS = minPoints(sy);
		else
			minS = minPoints(sy, 15);
		
		if(distance(minS) < d)
			return minS;
		else if(distance(qMin) < distance(rMin))
			return qMin;
		else
			return rMin;
			
	}
	
	/**
	 * Distance between two points in set of 2 minimal distance points
	 * @param p		set with two points of minimal distance
	 * @return		distance
	 */
	public static double distance(Point[] p){return Graph.distance(p[0], p[1]);}
}
