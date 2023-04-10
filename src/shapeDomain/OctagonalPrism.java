package shapeDomain;

import java.util.*;

public class OctagonalPrism extends Prism implements Comparator<Shape> {

	private double side;

	public OctagonalPrism() {
		super();
	}
	
	/**
	 * Constructs a new Octagonal Prism object
	 * 
	 * Precondition: valid height and side length supplied
	 * Postcondition: a new Octagonal Prism object created with supplied height and side length
	 * 
	 * @param height Height of the Octagonal Prism
	 * @param side Length of the side of the Octagonal Prism
	 */
	public OctagonalPrism(double height, double side) {
		super.setHeight(height);
		this.setSide(side);
	}
	
	/**
	* Sets side length of a Octagonal Prism object
	*
	* @param side Value of the side length to be set in Octagonal Prism object
	*
	*/
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	* Retrieves side length of a Octagonal Prism object
	*
	* @return Returns side length of Octagonal Prism object
	*
	*/
	public double getSide() {
		return this.side;
	}

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(this.side, 2);
	}

	@Override
	public String toString() {
		return String.format("%-20s H: %-10.2f R: %-10.2f V: %-25.2f BA: %-16.2f","Octagonal Prism",super.getHeight(), this.getSide(), this.calcVolume(), this.calcBaseArea());
	}

	@Override
	public int compare(Shape o1, Shape o2) {

		if (o1.calcVolume() > o2.calcVolume())
			return 1;
		else if (o1.calcVolume() < o2.calcVolume())
			return -1;
		else
			return 0;
	}
}
