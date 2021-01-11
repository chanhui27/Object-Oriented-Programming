package Question2;
import static java.lang.System.out;
public class Card {
	
	//private fields
	private String suit;
	private int faceValue;
	
	//define constructor
	public Card(String suit, int faceValue) {
		this.setFaceValue(faceValue);
		this.setSuit(suit);
	}
	
	//display the card message
	public void displayCard() {
		out.printf("The card is %s %d\n", suit, faceValue);
	}
	
	//getter and setter for suite and faceValue
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	
}
