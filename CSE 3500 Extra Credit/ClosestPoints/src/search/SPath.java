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
	
	private static Point[] simpleFind(Point[] p){
		Point[] sPoints = new Point[2];
		Double shortest = 999999999999999999999999999999999999999.9;
		Point s1 = null;
		Point s2 = null;
		for(int i=0; i<p.length; i++){
			for(int j=0; j<15; j++){
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
	
	public static Point[] msClosest(Graph g){
		PxComp x = new PxComp();
		PyComp y = new PyComp();
		Point[] px = new Point[g.length()];
		Point[] py = new Point[g.length()];
		px = g.sort(x).toArray(px);
		py = g.sort(y).toArray(py);
		return recClosest(g, px, py);
	}
	
	private static Point[] recClosest(Graph g, Point[] px, Point[] py){
		PyComp y = new PyComp();
		if(g.length() <= 3)
			simpleFind(g, g.length());
		
		Point[] qx = Arrays.copyOfRange(px, 0, px.length/2-1);
		Point[] qy = Arrays.copyOfRange(py, 0, py.length/2-1);
		Point[] rx = Arrays.copyOfRange(px, px.length/2, px.length);
		Point[] ry = Arrays.copyOfRange(py, py.length/2, py.length);
		
		Point[] qMin = recClosest(g, qx, qy);
		Point[] rMin = recClosest(g, rx, ry);
		
		double d = Math.min(distance(qMin), distance(rMin));
		double xMax = qx[qx.length-1].getX();
		ArrayList<Point> S = new ArrayList<Point>();
		
		for(Point p : px){
			if(disFromL(p, xMax) > xMax)
				break;
			else if(disFromL(p, xMax) <= xMax)
				S.add(p);
		}
		
		S.sort(y);
		Point[] sy = new Point[S.size()];
		sy = S.toArray(sy);
		
		Point[] minS = simpleFind(sy);
		
		if(distance(minS) < d)
			return minS;
		else if(distance(qMin) < distance(rMin))
			return qMin;
		else
			return rMin;
			
	}
	
	private static double disFromL(Point p, double l){return Math.abs(p.getX()-l);}
	
	public static double distance(Point[] p){return Graph.distance(p[0], p[1]);}
}
