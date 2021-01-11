/*
 Student name: Chanhui Choi   Student ID: 18465057
 I pledge by honour that this program is solely my own work.
 */
package assignment;
import java.util.*;
import static java.lang.System.out;
import java.util.concurrent.*;

public class Assignment {
	
	static Scanner userIn = new Scanner(System.in);

	public static void main(String[] args) {
		q1();
		q2();
		q3();
		q4();		
		q5();
		q6();
		q7();
		userIn.close();
	}
	public static void q1() {
		out.println("Question1");
		String tableformat = "%-20s%-30s\n"; //format of table 20 length of string and 30 length of another string
		out.printf(tableformat,"Escape sequence","Description"); //output of first row
		String spaceline=String.format("%40s",""); //set 40 lengths of space
		String dashline = spaceline.replace(" ", "-");//replace space into "-"

		out.println(dashline);
		out.printf(tableformat, "\\","A single backslash"); //print single backslash with a format for the table
		out.printf(tableformat, "\\\\","A double backslashes"); // print double backslashes with a format for the table
		out.printf(tableformat, "''","A pair of single quote"); // print pair of single quote with a format for the table
		out.printf(tableformat, "\"\"","A pair of double quote"); // print pair of double quote with a format for the table
				
	}
	public static void q2() {
		out.print("\n");
		out.println("Question2");
	
		out.print("Enter a height:"); //ask user to input the height
		float height = Float.parseFloat(userIn.nextLine()); //get height from user input and use float.parsefloat to change string types into float type
		out.print("Enter a width:"); //ask user to input the width
		float width =Float.parseFloat(userIn.nextLine()); //get width from user input and use float.parsefloat
		//calculate height and width
		float area=height*width; 
		float perimeter=(height+width)*2;
		
		String stringFormat = "%-15s%-15s%-15s%-15s\n"; //create format for displaying the height, width, area, and parameter
		out.printf(stringFormat, "Height","Width","Area","Perimeter"); //print following variables
		String spaceline=String.format("%60s",""); //set 60 lengths of space
		String dashline = spaceline.replace(" ", "-"); // replace the space into dash line
		out.println(dashline); 
		
		String numberFormat ="%-15.2f%-15.2f%-15.2f%-15.2f\n"; // set format for the displaying number
		//print height,width,area,parameter as in formatted template
		out.printf(numberFormat, height,width,area,perimeter); 
			
	}
	
	public static void q3() {	
		out.print("\n");
		out.println("Question3");
		out.print("Enter anumber for month (1-12):"); //ask user to input month
		
		int month = Integer.parseInt(userIn.nextLine()); // get user input into integer type

		if(month==12 || month==1 || month==2 ) // if month is 12, 1, 2
		{
			out.println("Wonderful summer");
		}
		else if (month==3 || month==4 || month==5) // if month is 3, 4, 5
		{
			out.println("Colourful autumn");
		}
		else if (month==6 || month==7 || month==8) // if month is 6, 7, 8
		{
			out.println("Cold Winter");
		}
		else if (month==9 || month==10 || month==11) //if month is 9, 10, 11
		{
			out.println("Beautiful spring");
		}
		else
		{
			out.println(month+"is an invalid season number"); // if the number is not in between 1-12, display error message
		}
	}
	
	public static void q4() {
		
		out.print("\n");
		out.println("Question4");
		
		while(true) //use while loop to iterate the code
		{
			out.print("Enter card letter (j/q/k/a):"); //ask user to input letter
			String letter = userIn.nextLine(); //get the user input

			if(letter.equalsIgnoreCase("j")) //ignore the lower case or upper case of the letter
			{
				out.println("It's a Jack");
				break; //get out from the loop
			}
			else if(letter.equalsIgnoreCase("q"))
			{
				out.println("It's a Queen");
				break;
			}
			else if(letter.equalsIgnoreCase("k"))
			{
				out.println("It's a King");
				break;
			}
			else if(letter.equalsIgnoreCase("a"))
			{
				out.println("It's an Ace");
				break;
			}
			else // if user enters invalid letter print error message
			{
				out.println("Invalid, try again");
			}
		}
		
		
	}
	
	public static void q5() {
		out.print("\n");
		out.println("Question5");

		out.print("Enter first line: "); // ask user to input the numbers
		String[] line1=userIn.nextLine().split(","); // get user to input first line of the number as an array which split with comma
		
		out.print("Enter second line: ");
		String[] line2=userIn.nextLine().split(",");
		
		int count=0; //set count 		
		
		double[] num1 = new double[line1.length]; //get lin1's length to the double type of array
		double[] num2 = new double[line2.length];
		
		for(int i=0; i <num1.length;i++) //use for loop to get double array to have line1 or 2's data
		{	num1[i] = Double.parseDouble(line1[i]); //change line1's data to double type and insert to the double type of array
			for(int j=0;j<num2.length;j++)
			{
				num2[j]=Double.parseDouble(line2[j]);
			}						
		}
		
	
		for(double n1 : num1) //get n1 as num1's double array elements
		{
			for(double n2 : num2)
			{
				if(n1==n2) //when the elements in n1(num1's elements) and n2(num2's elements) are equal count up
				{
					count++;
				}
			}
		}
		out.println("Number of overlapping values:"+count);

	}

	
	public static void q6() {
		
		out.print("\n");
		out.println("Question6");
		int num = ThreadLocalRandom.current().nextInt(1,10); //get random number from ThreadLocalRandom function from 1 to 10
	
		int count = 0; //set attempted count
		boolean win = false; // set flag
			
			out.print("Enter comma-separated numbers to guess my secret number (1-10):"); //ask user to input any number between 1 to 10
			String[] userNum=userIn.nextLine().split(","); //get user input as string type and split with comma
			int[] num1 = new int[userNum.length]; //create integer array to have userNum's length
			
		for(int i=0;i<num1.length;i++) //use for loop to get data from the userNum to num1
		{
			num1[i]=Integer.parseInt(userNum[i]); //change the data type
		}
		
		for(int j=0;j<num1.length;j++) // use for loop to check whether the random number is in num1's array
		{
			if(num == num1[j]) { // if the random number is equal to num1's element
				
				win=true; //change the flag as "true"			
				count = j+1; // get the attempt number and +1 means because it starts from 1, need to add it for that
			}	

		}	
		if(win == true) { //when the flag is true print the random number, display message which number is correct
			out.println("My secret number is "+num);
			out.println("You won");
			out.println("The "+count+"th attempt in your numbers is my secret number.");
		}
		else { //if not, display random number and message
			out.println("My secret number is "+num);
			out.print("You lost");
		}	
	
	}
		
	
	public static void q7() {
		out.println("\n");
		out.println("Question7");
		//set average, sum, and count 
		double avg=0;
		double sum=0;
		int count=0;
		
		out.println("--Collecting data--");
		
		out.print("How many stocks: "); //ask user to input number of stocks
		
		
		double[] stock_num = new double[Integer.parseInt(userIn.nextLine())]; // get stock_num size from the user input
		

		for(int i=1;i<=stock_num.length;i++) { // use for loop to enter the stock_num's data
			
			out.printf("Enter price for stock #%d:$",i); // ask user to input the price for the sock
			stock_num[i-1] = Double.parseDouble(userIn.nextLine()); // change whatever user typed into double type and save it into array

		}
		out.print("\n");
		out.println("--Display statistics--");
		
		double max=stock_num[0]; // set max data 
		
		for(int j=0;j<stock_num.length;j++) {
			sum +=stock_num[j]; //add each stock's price
			avg=sum/stock_num.length; //calculate the average
			
			if(stock_num[j]>max) { //if one of the stock_num's elements is bigger then max variable,
				max=stock_num[j]; //get that elements to the max 
			}
		}
		
		for(double num : stock_num) { //use for-each loop to check if price is between 1.5 and 5.5
			
			if(num>=1.5 && num <=5.5 )
			{
				count++; //count up
			}
		}
		//print average and maximum price
		out.printf("Average price:$%.2f\n",avg);
		out.println("Maximum price:$"+max);
			//print number of priced between 1.5 and 5.5
		out.println("Stocks priced between $1.5 and $5.5:"+count);
		out.print("\n");
		
		
	
		
		out.println("--Query stock price--");
		
		while(true) { //use while loop to check what stock does the user wants to see it
			
			out.printf("Enter stock number (1-%d):", stock_num.length); // ask user to input the stock number
			int number = Integer.parseInt(userIn.nextLine()); //change the data type into integer type
			if (number >=1 && number <= stock_num.length) { //if the number is between the stock_num's length
				//print the stock number and the price
				out.println("Price for stock#"+number+":"+"$"+stock_num[number-1]); 
				break;//get out from the loop
			}
			else //if not display the message
			{
				out.println("Stock doesn't exist. Enter again.");
			}
		}
		
	}


}



