package shapeSupport;

import java.util.Comparator;

import shapeDomain.Shape;

/**
 * Base Area Comparator class
 * @author Diego Maia, Dakota Chatt, Matthew Jacyk, Kevin Ung
 *
 */
public class BaseAreaCompare implements Comparator<Shape> {

	/**
	 * Compares two shapes based on their base areas, uses Comparator
	 *
	 * @param o1 1st Shape object
	 * @param o2 2nd Shape object
	 * @return int returns positive if 1st shape is bigger than 2nd, 
	 * negative if 1st shape is smaller than 2nd,
	 * 0 if both shapes are equal
	 */
	@Override
	public int compare(Shape o1, Shape o2) {
		
		
		if (o1.calcBaseArea() > o2.calcBaseArea())
			return 1;
		else if (o1.calcBaseArea() < o2.calcBaseArea())
			return -1;
		else
			return 0;
	}

}
