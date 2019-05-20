/* Sathya Gadhiraju
   Converts inches to feet.*/
   
import java.util.Scanner; // import libraries
public class InchesToFeet{ //class header
	public static void main (String [] args){//main method header
		int inches = -2; // make int inches variable
		double feet= -1.0; // double feet variable
		Scanner readMe= new Scanner(System.in); // make Scanner instance
		System.out.println("Type number of inches as an integer"); // prompt for inches
		inches = readMe.nextInt();// read inches
		feet = inches/12.0; // processing: feet= inches/12
		System.out.println(inches + "inches is equal to"+ Format.left (feet, 5, 2) + " feet."); //output (print) inches as equalling feet
	}
}
