/*Sathya Gadhiraju
 This program converts units.*/

import java.util.Scanner; // import libraries
public class MathMethods{ //class is MathMethods
public static void main (String [] args){ //main method header
  
   //converting inches to feet
   int inches = -2; // make int inches variable
   double feet= -1.0; // double feet variable
   Scanner readMe= new Scanner(System.in); // make Scanner instance
   System.out.println("Type number of inches as an integer"); // prompt for inches
   inches = readMe.nextInt();// read inches
   feet= inchesToFeet(inches); //call inchesToFeet method
   System.out.println(inches + "inches is equal to"+ Format.center (feet, 5, 2) + " feet."); //output (print) inches as equalling feet
  
   //converting yards to inches
   int yards = -5; // make int yards variable
   double inch = -2.0; // double inches variable
   System.out.println("Type number of yards as an integer"); // prompt for yards
   yards = readMe.nextInt();// read yards
   inch = yardsToInches (yards) ; //call yardsToInches method
   System.out.println(yards + " yards is equal to " + Format.center (inch, 5, 2) + " inches."); //output (print) yards as equalling inches
    
   //converting ounces to pounds
   int ounces= -3; //make int ounces variable
   double pounds = -4.0; //double pounds variable
   System.out.println("Type number of ounces (as a weight) as an integer"); // prompt for ounces (as a weight)
   ounces= readMe.nextInt();//read ounces
   pounds = ouncesToPounds (ounces) ; //call ouncesToPounds method
   System.out.println(ounces + " ounces is equal to " + Format.center (pounds, 5, 2) + " pounds."); //output (print) ounces as equalling pounds
 
   //converting centimeters to meters
   int centimeters = -3; // make int centimeters variable
   double meters = -3.1; //double meters variable
   System.out.println("Type number of centimeters as an integer"); // prompt for centimeters
   centimeters = readMe.nextInt (); // read centimeters
   meters = centimetersToMeters (centimeters) ; //call centimetersToMeters method
   System.out.println(centimeters + " centimeters is equal to " + Format.center (meters, 5, 2) + " meters."); //output (print) centimeters as equalling meters
    
   //converting quarts to gallons
   int quarts = -2; //make int quarts variable
   double gallons = -4.9; //double gallons variable
   System.out.println("Type number of quarts as an integer"); //prompt for quarts
   quarts = readMe.nextInt (); //read quarts
   gallons = quartsToGallons (quarts) ; //call quartsToGallons method
   System.out.println(quarts + " quarts is equal to " + Format.center (gallons, 5, 2) + "gallons."); //output (print) quarts as equalling gallons
}
public static double inchesToFeet(int inch){ // method inchesToFeet accepts inches input calculates feet, returns type
   double foot= -12.5; 
   foot = inch/12.0; 
   return foot;
}
     
public static double yardsToInches(int yard) { //method yardsToInches accepts yards input calculates inches, returns type
   double inch = -23.3;
   inch = yard*36.0;
   return inch;
}
   
public static double ouncesToPounds (int ounce) { //method ouncesToPounds accepts ounces input calculates pounds, returns type
   double pound = -93.3;
   pound = ounce/16.0;
   return pound;
}
  
public static double centimetersToMeters (int centimeter) { //method centimetersToMeters accepts centimeters input calculates meters, returns type
   double meter = -3.4;
   meter = centimeter/100.0;
   return meter;
}
   
public static double quartsToGallons (int quart) { //method quartsToGallons accepts quarts input calculates gallons, returns type
   double gallon = -6.6;
   gallon = quart/4.0;
   return gallon; 
}
}
