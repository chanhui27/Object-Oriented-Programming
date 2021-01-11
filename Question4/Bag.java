package Question4;

public class Bag {
	//private fields
	private String colour;
	private double volume;
	
	//build constructor 
	public Bag(String colour, double volume) {
		this.setColour(colour);
		this.setVolume(volume);
	}
	
	//getter and setter for two private fields 
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}

	
	
}
