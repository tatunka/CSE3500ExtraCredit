package main;

import java.io.File;
import java.io.FileNotFoundException;
import search.Graph;
import search.Point;
import search.SPath;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("src/xy.csv");
		Graph g = new Graph();
		g.createGraph(file);										//create new graph from file
		Graph g1000 = g.copyRangeOf(1000);							//first 1,000 points
		Graph g10000 = g.copyRangeOf(10000);						//first 10,000 points
		
		System.out.print("For 1,000 points with loops: ");
		long start = System.nanoTime();
		Point[] shortest = SPath.simpleFind(g1000);
		long stop = System.nanoTime();
		long elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println("Node 1: (" + shortest[0].toString() + ")");
		System.out.println("Node 2: (" + shortest[1].toString() + ")");
		System.out.println("Distance: " + SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 1,000 points with Recursion: ");
		start = System.nanoTime();
		shortest = SPath.msClosest(g1000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println("Node 1: (" + shortest[0].toString() + ")");
		System.out.println("Node 2: (" + shortest[1].toString() + ")");
		System.out.println("Distance: " + SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 10,000 points with loops: ");
		start = System.nanoTime();
		shortest = SPath.simpleFind(g10000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println("Node 1: (" + shortest[0].toString() + ")");
		System.out.println("Node 2: (" + shortest[1].toString() + ")");
		System.out.println("Distance: " + SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 10,000 points with recursion: ");
		start = System.nanoTime();
		shortest = SPath.msClosest(g10000);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println("Node 1: (" + shortest[0].toString() + ")");
		System.out.println("Node 2: (" + shortest[1].toString() + ")");
		System.out.println("Distance: " + SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 100,000 points with loops: ");
		start = System.nanoTime();
		shortest = SPath.simpleFind(g);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println("Node 1: (" + shortest[0].toString() + ")");
		System.out.println("Node 2: (" + shortest[1].toString() + ")");
		System.out.println("Distance: " + SPath.distance(shortest));
		System.out.println();
		
		System.out.print("For 100,000 points with recursion: ");
		start = System.nanoTime();
		shortest = SPath.msClosest(g);
		stop = System.nanoTime();
		elapsed = stop - start;
		System.out.println(elapsed + " ns");
		System.out.println("Node 1: (" + shortest[0].toString() + ")");
		System.out.println("Node 2: (" + shortest[1].toString() + ")");
		System.out.println("Distance: " + SPath.distance(shortest));
		System.out.println();
		
	}

}
