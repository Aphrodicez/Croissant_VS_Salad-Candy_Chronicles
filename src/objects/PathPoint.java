package objects;


 /**
 * The class Path point
 */ 
public class PathPoint {
	
	/**
	 * x (index) of coordinates
	 */
	private int xIndex;
	/**
	 * y (index) of cooredinates
	 */
	private int yIndex;
	/**
	 * Initialize fields
	 */
	public PathPoint(int xIndex, int yIndex) { 

		this.xIndex = xIndex;
		this.yIndex = yIndex;
	}
	/**
	 * Get x (index)
	 */
	public int getxIndex() { 

		return xIndex;
	}
	/**
	 * Get y (indedx)
	 */
	public int getyIndex() { 

		return yIndex;
	}
}
