package Question3;

public class Container {//super class
	
	private String colour;

	//build constructor
	public Container (String colour) {
		this.setColour(colour);
	}
	
	//returns message that "I'm a container"
	public String getContainerType() {
		
		return "I'm a Container.";
	}
	
	//getter and setter from colour variable
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	

}
