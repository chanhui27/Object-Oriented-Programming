package Question5;
import static java.lang.System.out;
public class Student {
	//private fields
	private String Id;
	private double score;
	
	//build constructor
	public Student(String Id, double score) {
		this.setId(Id);
		this.setScore(score);
	}	
	
	//display id and score 
	public void displayStudent() {
		out.printf("%-20s%-30.2f\n", Id, score);
	}
	
	//getter and setter for id and score	
	public String getId() {
		return Id;
	}	
	public void setId(String id) {
		Id = id;
	}	
	public double getScore() {
		return score;
	}	
	public void setScore(double score) {
		this.score = score;
	}

}//end of class student
