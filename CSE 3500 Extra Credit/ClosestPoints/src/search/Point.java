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
	public double getX(){return _x;}				//return x coordinate
	public double getY(){return _y;}				//return y coordinate
	
	public String toString(){return _x.toString() + ",   " + _y.toString();}		//toString method
	
	/**
	 * Finds if this Point is equal to another Point or itself
	 * @param p			Point
	 * @return			if Points are equal
	 */
	public boolean equals(Point p){
		if(_x != p.getX())
			return false;
		if(_y != p.getY())
			return false;
		return true;
	}
}
