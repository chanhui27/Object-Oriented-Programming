package Question5;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import static java.lang.System.out;
public class ScoreApp {
	
	//private field
	private List<Student> students;
	
	//build constructor
	public ScoreApp(List<Student> students)	{
		this.setStudents(students);
	}
	
	//getter and setter for List students
	public void setStudents(List<Student> students)	{
		this.students = students;
	}
	public List<Student> getStudents() {
		return students;
	}	
	
	public ScoreApp(String filename) throws IOException {
		students=new LinkedList<>();
		readData(filename);
	}
	
	public void readData(String filename) throws IOException {
		Path path = new File(filename).toPath(); //get path for filename
		List<String> content = Files.readAllLines(path);//put files to the content list from path variable 
		
		for(String line: content) {
			String[] items = line.split(","); //split each line into two items and store into items array
			Student s = new Student(items[0],Double.valueOf(items[1])); //get s to have items variable which split into id and score
			students.add(s); //add to students list
		}
	}
	
	public void printall() {
		
		if(students == null || students.size()==0) {
			out.println("nothing");
			return;
		}
		
		//formatting template
		String tableformat = "%-20s%-30s\n"; //format of table 20 length of string and 30 length of another string
		out.printf(tableformat,"ID","Score"); //output of first row
		String spaceline=String.format("%35s",""); //set 40 lengths of space
		String dashline = spaceline.replace(" ", "-");//replace space into "-"
		out.println(dashline);
		
		//get information from displayStudent()
		for(Student s: students) {
			s.displayStudent();
		}
	}
	public double getMinScore() { 
		//get minimum score from student class
		Student min = students.get(0); //get first element from student class
		
		if(students == null || students.size() == 0 ) {
			out.println("nothing");
			return 0;
		}
		for(Student s: students) {
			if(s.getScore() < min.getScore()) //compare which has minimum score
				min = s;//get minimum score to the min variable
		}
		
		return min.getScore(); //return minimum score
	}
	
	public int countScoreRange() {
		int count =0;
		
		if (students == null || students.size() == 0) {
			out.println("nothing");
			return 0;
		}
		for(Student s : students) { //use for-each loop to check if price is between 50 and 80
			if(s.getScore()>=50 && s.getScore() <=80 )
				count++; //count up
		}
		return count;
	}
	
	public String getTopStudentID()	{
		//check whether students is empty 
		if(students == null || students.size() == 0)
			return "No data ";
		
		Student maxs = students.get(0);//define maxs variable
		for(Student s:  students) {
			if(s.getScore() > maxs.getScore()) //check whether maxs is higher than s.getScore
				maxs = s; //get highest score to the maxs variable	
		}
		
		return maxs.getId(); //get id which has the highest score 
	}
}//End of class ScoreApp

