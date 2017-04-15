package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Clock;

import search.Graph;
import search.Point;
import search.SimpleShortest;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("src/xy.csv");
		Graph g = new Graph();
		
		g.createGraph(file);
		
		Point[] shortest = SimpleShortest.simpleFind(g, 1000);
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(g.distance(shortest[0], shortest[1]));
		System.out.println();
		
		shortest = SimpleShortest.simpleFind(g, 10000);
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(g.distance(shortest[0], shortest[1]));
		System.out.println();
		
		shortest = SimpleShortest.simpleFind(g, 100000);
		System.out.println(shortest[0].toString());
		System.out.println(shortest[1].toString());
		System.out.println(g.distance(shortest[0], shortest[1]));
		
		
		
	}

}
