package main;

import java.io.File;
import java.io.FileNotFoundException;
import search.Graph;
import search.Point;
import search.PxComp;
import search.PyComp;
import search.SPath;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("src/xy.csv");
		Graph g = new Graph();
		g.createGraph(file);
		Graph g1000 = g.copyRangeOf(1000);
		Graph g10000 = g.copyRangeOf(10000);
		Graph g100000 = g.copyRangeOf(100000);
		
		System.out.print("For 1,000 points: ");
		long start = System.nanoTime();
		Point[] shortest = SPath.simpleFind(g, 1000);
		long stop = System.nanoTime();
		long elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 10,000 points: ");
		start = System.nanoTime();
		shortest = SPath.simpleFind(g, 10000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(SPath.distance(shortest));
		System.out.println();
		
		
		System.out.print("For 100,000 points: ");
		start = System.nanoTime();
		shortest = SPath.simpleFind(g, 100000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 1,000 points: ");
		start = System.nanoTime();
		shortest = SPath.msClosest(g1000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 10,000 points: ");
		start = System.nanoTime();
		shortest = SPath.msClosest(g10000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 100,000 points: ");
		start = System.nanoTime();
		shortest = SPath.msClosest(g100000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(SPath.distance(shortest));
		System.out.println();
		
	}

}
