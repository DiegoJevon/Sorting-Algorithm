package shapeDomain;

import java.util.Comparator;

public class SquarePrism extends Prism implements Comparator <Shape> {

	private double side;
	
	public SquarePrism() {
		super();
	}
	
	/**
	 * Constructs a new Square Prism object
	 * 
	 * 
	 * @param height Height of the square prism
	 * @param side Length of the side of the square prism
	 */
	public SquarePrism (double height, double side) {
		super.setHeight(height);
		this.setSide(side);
	}
	
	/**
	* Sets side length of a Square Prism object
	*
	* @param side Value of the side length to be set in Square Prism object
	*
	*/
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	* Retrieves side length of a Square Prism object
	*
	* @return Returns side length of Square Prism object
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
		return Math.pow(this.side,2);
	}

	@Override
	public String toString() {
		return String.format("%-20s H: %-10.2f R: %-10.2f V: %-25.2f BA: %-16.2f","Square Prism",super.getHeight(), this.getSide(), this.calcVolume(), this.calcBaseArea());
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
