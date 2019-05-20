/* Sathya Gadhiraju
   This program calculates the total dinner cost for two and prints details.*/
   
import java.util.Scanner; // import libraries
public class Date{ //class header
 public static void main (String [] args){//main method header
  String restaurantName = ""; // make restaurant name variable
  double averageEntreeCost = -2.4; // make average entree cost variable
  double averageBeverageCost = -3.4; // make average beverage cost variable
  double mealCostForOne = -9.3; // make meal cost for one variable
  double mealCostForTwo = -34.2; // make meal cost for two variable
  double tip = -4.3; // make tip variable
  double tax = -7.5; // make tax variable
  double totalCost = -1.2; // make total cost variable
  
  //input
  Scanner readMe = new Scanner(System.in); // make Scanner instance
  System.out.println("What is the restaurant name?"); // prompt for restaurant name
  restaurantName = readMe.nextLine(); // read restaurant name
  System.out.println("How much is the average entree cost?"); // prompt for average entree cost
  averageEntreeCost = readMe.nextDouble(); // read average entree cost
  System.out.println("How much is the average beverage cost?"); // prompt for average beverage cost
  averageBeverageCost = readMe.nextDouble(); //read average beverage cost
  
  //processing
  mealCostForOne = averageEntreeCost + averageBeverageCost; // calculate meal cost for one
  mealCostForTwo = 2*mealCostForOne; // calculate meal cost for two
  tip = 0.2*mealCostForTwo; // calculate tip
  tax = 0.0825*mealCostForTwo; // calculate tax
  totalCost = mealCostForTwo + tip + tax; // calculate total cost
  
  //output
  System.out.println(""); 
  System.out.println(Format.left("Item", 20) + Format.left("Cost", 0)); // print header
  System.out.println(""); 
  System.out.println(Format.left("Meal Subtotal", 20) + "$" + Format.right(mealCostForTwo, 5, 2)); // print subtotal
  System.out.println(Format.left("Meal Tip", 20) + "$" + Format.right(tip, 5, 2)); // print subtotal
  System.out.println(Format.left("Meal Tax", 20) + "$" + Format.right(tax, 5, 2)); // print subtotal
  System.out.println(Format.left("Total", 20) + "$" + Format.right(totalCost, 5, 2)); // print subtotal
  
 }
}
