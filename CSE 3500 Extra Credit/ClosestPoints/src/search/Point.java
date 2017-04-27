package search;

public class Point {
	
	Double _x;							//x coordinate
	Double _y;							//y coordinate
	
	//class constructor
	public Point(double x, double y){			
		_x = x;
		_y = y;
	}
	
	//getters
	public double getX(){return _x;}
	public double getY(){return _y;}
	
	public String toString(){
		return _x.toString() + ",   " + _y.toString();
	}
	
	public boolean equals(Point p){
		if(_x != p.getX())
			return false;
		if(_y != p.getY())
			return false;
		return true;
	}
}
