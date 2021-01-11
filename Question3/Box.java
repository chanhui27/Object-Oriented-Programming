package Question3;

public class Box extends Container {//inherits from Container class
	
	private double length, height, width;

	//build constructor with super class
	public Box (String colour, double length, double height, double width) {
		super(colour); //get colour from Container(super) class
		this.setHeight(height);
		this.setLength(length);
		this.setWidth(width);
	}
	
	//calculates the box volume
	public double getVolume() {
		double volume = length * height * width;
		return volume;
	}
	
	//override method that returns "I'm a Box"
	@Override public String getContainerType() {
		return "I'm a Box.";
	}
	
	//getter and setter from length, height, width
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
}
