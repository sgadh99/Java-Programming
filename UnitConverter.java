/* Sathya Gadhiraju
   This program first converts yards to inches. Then, it converts ounces to pounds.*/
   
import java.util.Scanner; // import libraries
public class UnitConverter{ //class header
 public static void main (String [] args){//main method header
  //converting yards to inches
  int yards = -5; // make int yards variable
  double inches = -2.0; // double inches variable
  Scanner readMe = new Scanner(System.in); // make Scanner instance
  System.out.println("Type number of yards as an integer"); // prompt for yards
  yards = readMe.nextInt();// read yards
  inches = yards*36.0; // processing: inches= yards*36
  System.out.println(yards + " yards is equal to " + Format.left (inches, 5, 2) + " inches."); //output (print) yards as equalling inches
  
  //converting ounces to pounds
  int ounces = -3; //make int ounces variable
  double pounds = -4.0; //double pounds variable
  System.out.println("Type number of ounces (as a weight) as an integer"); // prompt for ounces (as a weight)
  ounces = readMe.nextInt();//read ounces
  pounds = ounces/16.0; // processing: pounds= ounces/16
  System.out.println(ounces + " ounces is equal to " + Format.left (pounds, 5, 2) + " pounds."); //output (print) ounces as equalling pounds
  
 }
}
