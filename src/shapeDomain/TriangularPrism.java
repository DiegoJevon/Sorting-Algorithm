package shapeDomain;

import java.util.Comparator;

public class TriangularPrism extends Prism implements Comparator <Shape> {

	private double side;
	
	public TriangularPrism() {
		super();
	}
	
	/**
	 * Constructs a new Equilateral Triangular Prism object
	 * 
	 * 
	 * @param height Height of the Equilateral Triangular Prism
	 * @param side Length of the side of the Equilateral Triangular Prism
	 */
	public TriangularPrism (double height, double side) {
		super.setHeight(height);
		this.setSide(side);
	}
	
	/**
	* Sets side length of a Equilateral Triangular Prism object
	*
	* @param side Value of the side length to be set in Equilateral Triangular Prism object
	*
	*/
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	* Retrieves side length of a Equilateral Triangular Prism object
	*
	* @return Returns side length of Equilateral Triangular Prism object
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
		return (Math.pow(this.side,2) * Math.sqrt(3)) / 4;
	}

	@Override
	public String toString() {
		return String.format("%-20s H: %-10.2f R: %-10.2f V: %-25.2f BA: %-16.2f","Triangular Prism",super.getHeight(), this.getSide(), this.calcVolume(), this.calcBaseArea());
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
