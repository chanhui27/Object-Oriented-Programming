package Question2;
import static java.lang.System.out;
public class Main {

	public static void main(String[] args) {
		//insert data into hand variable
		Card[] hand = {
				new Card("Spade", 3),
				new Card("Club", 10),
				new Card("Diamond", 11),
				new Card("Heart", 9),
				new Card("Diamond", 13),
				
		};		
		
		processHand(hand);
		
	}
	
	public static void processHand(Card[] cards) {

		int total =0;
	
		if (cards == null || cards.length == 0)
			return;
		
		for(int i=0;i<cards.length;i++) {		
			cards[i].displayCard();//invoke the displayCard()
			total += cards[i].getFaceValue();//get faceValue from Card
		}
	
		out.printf("Total face value of hand: %d points.", total);
	}

}
