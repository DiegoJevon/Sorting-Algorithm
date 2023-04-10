package shapeDomain;

import java.util.Comparator;

public abstract class Prism extends Shape implements Comparator <Shape> {
	
	//attributes
	private double side;

	public Prism() {
		super.height = 0;
		this.side = 0;
	}
	
	/**
	 * Constructs a new Prism object
	 * 
	 * 
	 * @param height Height of the Prism
	 * @param side Side length of the Prism object
	 */
	public Prism(double height, double side) {
		super.setHeight(height);
		this.setSide(side);
	}
	
	/**
	* Sets side length of a Prism object
	*
	* @param side Value of the side length to be set in Prism object
	*
	*/
	public void setSide(double side) {
		this.side = side;
	}
	
	/**
	* Retrieves side length of a Prism object
	*
	* @return Returns side length of Prism object
	*
	*/
	public double getSide() {
		return this.side;
	}
	
	public abstract double calcVolume();
	
	public abstract double calcBaseArea();
}
