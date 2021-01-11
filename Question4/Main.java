package Question4;
import java.util.*;
import static java.lang.System.out;
public class Main {

	public static void main(String[] args) {
		//create list of Bag and add data
		List<Bag> bags = new LinkedList<>();
		bags.add(new Bag("blue",4.30));
		bags.add(new Bag("white",4.30));
		bags.add(new Bag("yellow",4.30));
		
		
		BagApp bgapp = new BagApp(); //create a variable for BagApp class
		double totalVolume = bgapp.calcTotalVolume(bags, 0); //get value from calcTotalVolume method 
		
		out.printf("Total number of bags: %d\n",bags.size());
		out.printf("Total volume: %.2f\n",totalVolume);

	}
}//end of class main

