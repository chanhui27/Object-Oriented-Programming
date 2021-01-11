package Question3;
import static java.lang.System.out;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		//create list which type is Container class and add data in to containers variable
		List<Container> containers = new LinkedList<>();
		containers.add(new Container("red"));
		containers.add(new Box("white", 4,3,2));
		containers.add(new Box("black", 5,13,8));
		containers.add(new Container("orange"));
		displayContainerTypes(containers); // produces output part 1
		
		//create array for boxArray1 and boxArray2 and add data
		Box[] boxArray1 = {
				new Box("white", 4,3,2),
				new Box("red", 9,5,6),
				new Box("purple", 3,6,12),
				new Box("orange", 15,10,4),
				new Box("black", 4,14,10),
				};
		Box[] boxArray2 = {
				new Box("pink", 3,4,2),
				new Box("red", 10,2,4),
				new Box("white", 8,5,7),
				new Box("blue", 14,4,10),
				new Box("bindle", 10,15,4),
				};
		
		countOverlapBoxes(boxArray1, boxArray2);//produces output part 2
		
	}
	public static void displayContainerTypes (List<Container> containers) {//method for output part1

		//check whether containers list is empty 
		if(containers == null || containers.size() == 0) 
			return; 
		
		for(Container c : containers) {
			out.println(c.getContainerType());//print out the container type 
		
		}
		
		
	}
	public static void countOverlapBoxes (Box[] group1, Box[] group2) {//method for output part2

		int countC =0; //count for overlapping colour
		int countV = 0; //count for overlapping volume

		
		for(Box test1: group1) {
			
			for(Box test2 : group2)
			{
				if (test1.getColour() == test2.getColour()) 
					countC +=1;//count up whether the colour is overlapping between test1 and test2
				if(test1.getVolume() == test2.getVolume())
					countV +=1; //count up whether the volume is overlapping between test1 and test2
			}
			
		}
		//display the outcomes
		out.printf("There are %d Box objects with overlapping colour between the two arrays.\n", countC);
		out.printf("There are %d Box objects with overlapping volume between the two arrays.\n", countV);
		
		
	}

}
