package search;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Graph implements Iterable<Point>{
	
	public ArrayList<Point> _graph;								//Graph as a list of points
	
	public Graph(){_graph = new ArrayList<Point>();}			//class constructor
	public Graph(ArrayList<Point> g){_graph = (ArrayList<Point>) g;}
	
	
	public void clear(){_graph.clear();}	//clear graph
	public Point getPoint(int i){return _graph.get(i);}			//gets Point at index i
	public int length(){return _graph.size();}
	
	public Graph copyRangeOf(int i){
		ArrayList<Point> graph = new ArrayList<>();
		for(int j=0; j<i; j++)
			graph.add(_graph.get(j));
		return  new Graph(graph);
		}
	
	public ArrayList<Point> sort(Comparator<Point> c){
		_graph.sort(c);
		return _graph;}
	
	/**
	 * Adds a new point to the graph
	 * @param p		point to add
	 * @return		added point
	 */
	public Point addPoint(Point p){
		_graph.add(p);
		return p;
		}
	
	/**
	 * Finds distance between two points on 2-D Cartesian graph.
	 * @param p1	Fist point
	 * @param p2	Second point
	 * @return		distance between points
	 */
	public static double distance(Point p1, Point p2){
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		
		double height = Math.abs(y1-y2);
		double width = Math.abs(x1-x2);
		
		return Math.sqrt(Math.pow(height, 2.0) + Math.pow(width, 2.0));
	}
	
	/**
	 * Creates a new graph from input file. Graph is represented as a list of points
	 * @throws FileNotFoundException
	 */
	public void createGraph(File file) throws FileNotFoundException{
		Scanner scan = new Scanner(file);
		scan.next();
		while(scan.hasNext()){
			Scanner scanner = new Scanner(scan.next());
			Scanner pScan = scanner.useDelimiter(",");
			while(pScan.hasNext()){
				String x = pScan.next();
				String y = pScan.next();
				Point p = new Point(Float.valueOf(x), Float.valueOf(y));
				this.addPoint(p);
			}
			scanner.close();
			pScan.close();
		}
		scan.close();
	}

	/**
	 * Iterator for points on Graph
	 */
	@Override
	public Iterator<Point> iterator() {return _graph.iterator();}
}
