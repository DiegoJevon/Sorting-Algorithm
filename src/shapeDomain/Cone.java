package shapeDomain;

import java.util.Comparator;

public class Cone extends Shape implements Comparator <Shape>  {

	private double radius;
	
	
	public Cone() {
		super();
	}
	
	/**
	 * Constructs a new Cone object
	 * 
	 * Precondition: valid height and radius supplied
	 * Postcondition: a new Cone object created with supplied height and radius
	 * 
	 * @param height Height of cone
	 * @param radius Radius of cone
	 */
	public Cone (double height, double radius) {
		super(height);
		this.setRadius(radius);
	}
	
	/**
	* Sets radius of a Cone object
	*
	* @param radius Value of the radius to be set in Cone object
	*
	*/
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	* Retrieves radius of a Cone object
	*
	* @return Returns radius of Cone object
	*
	*/
	public double getRadius() {
		return this.radius;
	}
	
	@Override
	public double calcVolume() {
		return (1.0/3) * this.calcBaseArea() * super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * Math.pow(this.radius,2);
	}

	@Override
	public String toString() {
		return String.format("%-20s H: %-10.2f R: %-10.2f V: %-25.2f BA: %-16.2f","Cone",super.getHeight(), this.getRadius(), this.calcVolume(), this.calcBaseArea());
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
