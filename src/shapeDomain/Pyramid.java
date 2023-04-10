package shapeDomain;

import java.util.Comparator;

public class Pyramid extends Shape implements Comparator <Shape> {

	private double side;
	
	public Pyramid() {
		super();
	}
	
	/**
	 * Constructs a new Pyramid object
	 * 
	 * Precondition: valid height and side length supplied
	 * Postcondition: a new Pyramid object created with supplied height and side length
	 * 
	 * @param height Height of the pyramid
	 * @param side Length of the side of the pyramid base
	 */
	public Pyramid (double height, double side) {
		super(height);
		this.setSide(side);
	}
	
	/**
	* Sets side length of a Pyramid object
	*
	* @param side Value of the side length to be set in Pyramid object
	*
	*/
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	* Retrieves side length of a Pyramid object
	*
	* @return Returns side length of Pyramid object
	*
	*/
	public double getSide() {
		return this.side;
	}
	
	@Override
	public double calcVolume() {
		return (1.0/3) * this.calcBaseArea() * super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.pow(this.side,2);
	}

	@Override
	public String toString() {
		return String.format("%-20s H: %-10.2f R: %-10.2f V: %-25.2f BA: %-16.2f","Pyramid",super.getHeight(), this.getSide(), this.calcVolume(), this.calcBaseArea());
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
