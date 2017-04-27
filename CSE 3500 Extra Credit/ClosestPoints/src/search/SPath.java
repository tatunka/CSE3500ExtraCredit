package search;

import java.util.ArrayList;
import java.util.Arrays;

public class SPath {
	
	public static Point[] simpleFind(Graph g, int number){
		Point[] sPoints = new Point[2];
		Double shortest = 999999999999999999999999999999999999999.9;
		Point s1 = null;
		Point s2 = null;
		for(int i=0; i<number; i++){
			Point p1 = g.getPoint(i);
			for(Point p2 : g){
				if(p1.equals(p2))
					continue;
				double distance = Graph.distance(p1, p2);
				if(distance < shortest){
					shortest = distance;
					s1 = p1;
					s2 = p2;
				}
			}
		}
		sPoints[0] = s1;
		sPoints[1] = s2;
		return sPoints;
	}
	
	private static Point[] minPoints(Point[] p, int n){
		Point[] sPoints = new Point[2];
		Double shortest = 999999999999999999999999999999999999999.9;
		Point s1 = null;
		Point s2 = null;
		for(int i=0; i<p.length; i++){
			for(int j=0; j<n; j++){
				if(p[i].equals(p[j]))
					continue;
				double distance = Graph.distance(p[i], p[j]);
				if(distance < shortest){
					shortest = distance;
					s1 = p[i];
					s2 = p[j];
				}
			}
		}
		sPoints[0] = s1;
		sPoints[1] = s2;
		return sPoints;
	}
	
	private static Point[] minPoints(Point[] p){
		return minPoints(p, p.length);
	}
	
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
	
	public static double distance(Point[] p){return Graph.distance(p[0], p[1]);}
}
