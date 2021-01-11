package Question5;
import static java.lang.System.out;

import java.io.*;
import java.util.*;

import Question4.Bag;

public class Main {

	public static void main(String[] args) {
		String txtfile = "data/data.txt";
		try {
			//get txtfile from ScoreApp class
			ScoreApp scoreapp = new ScoreApp(txtfile);
			scoreapp.printall(); //print out all the data from txtfile
			System.out.println();
			out.printf("Lowest score: %.2f\n", scoreapp.getMinScore()); //get minimum score
			out.printf("Top student ID: %s\n", scoreapp.getTopStudentID()); //get top student's id
			out.printf("Scores between 50-80: %d\n", scoreapp.countScoreRange());//get number of scores which between 50-80
			double total = recursiveTotalScore(scoreapp.getStudents(), 0); //define total that gets data from recursiveTotalScore method
			out.printf("Total scores: %.2f\n", total);
		}catch(IOException ioe) {//catch file input output exception
			out.printf("Perhaps missing text file: %s/%s? \nn", new Main().getClass().getPackage().getName(),txtfile);
		}
		
	}//end of main method
	
	public static double recursiveTotalScore(List<Student> list, double accum) {
		if(list != null && list.size() > 0) { //if list is not empty
			accum += list.get(0).getScore();//get accum to add scores from list
			List<Student> sublist = list.subList(1, list.size()); //get sublist to have list's lefted element
			return recursiveTotalScore(sublist, accum); //return sublist and accum
		}
		else //if list is empty 
			return accum; 
		
		
	}

}//end of class main
