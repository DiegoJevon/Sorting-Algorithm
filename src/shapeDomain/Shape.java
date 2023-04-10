package shapeDomain;

public abstract class Shape implements Comparable <Shape> {
	
	//Attributes
	protected double height;
	
	
	public Shape() {
	}
	
	/**
	 * Constructs a new shape object and assigns its height attribute
	 * 
	 * @param height The value of the height of the 2 dimensional shape
	 */
	public Shape(double height) {
		this.setHeight(height);
	}
	
	/**
	 * Retrieves the value of the shape object's height
	 * 
	 * Precondition: A valid shape object has been created
	 * Postcondition: The value of the shape's height is returned
	 * 
	 * @return the value of the height of the shape
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * Sets the value of a Shape object's height attribute
	 * 
	 * Precondition: A valid shape object has been created
	 * Postcondition: The shape object's height is set to supplied value
	 * 
	 * @param height set shape's height
	 */
	public  void setHeight(double height) {
		this.height = height;
	}
	
		
	/**
	 * Calculates the volume of the shape
	 * 
	 * Precondition: A valid 3 dimensional shape
	 * Postcondition: The volume of the specific 3 dimensional shape
	 * 
	 * @return the volume of the 3 dimensional shape
	 */
	public abstract double calcVolume();
	
	/**
	 * Calculates the base surface area of the 2 dimensional shape
	 * 
	 * Precondition: A valid 3 dimensional shape
	 * Postcondition: The surface area of the base of the 3 dimensional shape
	 * 
	 * @return the surface area of the base of the 3 dimensional shape
	 */
	public abstract double calcBaseArea();
	
	/**
	 * Compares the height of the current shape with another shape returning the comparison
	 * 
	 * Precondition: A valid Shape object is supplied to compare to current valid Shape object
	 * Postcondition: An integer is returned with the result of the comparison of the current Shape and the other shape
	 * 
	 * @param s A valid Shape object
	 * 
	 * @return Returns 1 if current shape is greater than the other shape, 0 if equal, -1 if smaller than
	 */
	@Override
	public int compareTo(Shape s) {
		if (this.getHeight() > s.getHeight()) 
			return 1;
		else if (this.getHeight() < s.getHeight())
			return -1;
		else
			return 0;
	}
	
	
	@Override
	/**
	 * Method to print Strings considering all class variables. 
	 * This method will be defined by child class.
	 * @return Returns a String formatted as per implementation of child class
	 */
	public abstract String toString();
		
	
}
