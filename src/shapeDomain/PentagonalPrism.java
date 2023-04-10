package shapeDomain;

import java.util.*;

public class PentagonalPrism extends Prism implements Comparator <Shape>{

	private double side;
	
	
	public PentagonalPrism() {
		super();
	}
	
	/**
	 * Constructs a new Pentagonal Prism object
	 * 
	 * 
	 * @param height Height of the Pentagonal Prism
	 * @param side Length of the side of the Pentagonal Prism
	 */
	public PentagonalPrism (double height, double side) {
		super.setHeight(height);
		this.setSide(side);
	}
	
	/**
	* Sets side length of a Pentagonal Prism object
	*
	* @param side Value of the side length to be set in Pentagonal Prism object
	*
	*/
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	* Retrieves side length of a Pentagonal Prism object
	*
	* @return Returns side length of Pentagonal Prism object
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
		return (5 * Math.pow(this.side,2) * Math.tan(Math.toRadians(54))) / 4;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s H: %-10.2f R: %-10.2f V: %-25.2f BA: %-16.2f","Pentagonal Prism",super.getHeight(), this.getSide(), this.calcVolume(), this.calcBaseArea());
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
