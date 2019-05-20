/*Sathya Gadhiraju
 This program shows the amount of food needed to sustain yourself for a year, prints the amount of calories per trophic level, and it shows the food energy pyramid.*/  

import java.util.Scanner; // import libraries
public class FoodEnergyPyramid{ //class is FoodEnergyPyramid
public static void main (String [] args){ //main method header
	
  int caloriesPerDay = -2; // make int caloriesPerDay variable
	String foodType = ""; // make String foodType variable
	int trophicLevel = -3; // make int trophicLevel variable
	int caloriesInFoodType = -4; // make caloriesInFoodType variable
	double amountFoodItemToSustainForYear = -4.4; // make amountFoodItemToSustainForYear variable
	int caloriesPerYear = -9; // make caloriesPerYear variable
	int trophicLevelOneCalories = -5; // make trophicLevelOneCalories variable
	int trophicLevelTwoCalories = -6; // make trophicLevelTwoCalories variable

	Scanner readMe= new Scanner(System.in); // make Scanner instance
	System.out.print("Enter the number of calories you need to eat per day, to maintain your health."); // prompt for number of calories needed per day
	caloriesPerDay = readMe.nextInt();// read calories per day
	System.out.print("What food do you eat?"); // prompt for food type
	foodType = readMe.next(); // read food type
	System.out.print("What trophic level does the vast majority of the food come from? Enter 1 for primary producer, 2 for primary consumer, 3 for secondary consumer, and 4 for tertiary consumer."); //prompt for trophic level
	trophicLevel = readMe.nextInt(); // read trophic level
	System.out.print("How many calories does a " + foodType + " have? "); // prompt number of calories in food type
	caloriesInFoodType = readMe.nextInt(); // read number calories in food type
	
	caloriesPerYear = caloriesPerDay*365; // process calories per year
	amountFoodItemToSustainForYear = ((double)caloriesPerYear)/caloriesInFoodType; // process amount of food type to sustain for year
	trophicLevelTwoCalories = multiplyByTen(caloriesPerYear); // process trophic level two calories
	trophicLevelOneCalories = multiplyByTen(trophicLevelTwoCalories); // process trophic level one calories
	
	System.out.println(); 
	System.out.println();
	System.out.print("You will need to eat " + amountFoodItemToSustainForYear + " " + foodType + "s to sustain yourself for a year."); // print amount of food items to sustain for year
	System.out.print(" " + trophicLevelTwoCalories + " calories from trophic level 2 and " + trophicLevelOneCalories + " calories from plants are required to give you your " + foodType + "s!"); // print trophic level two calories and trophic level one calories
	System.out.println(); 
	System.out.println("Here's how the food energy pyramid looks:"); 
	System.out.println();
	System.out.println(Format.center("Level 3: " + caloriesPerYear + " calories", 50)); // print trophic level three calories
	System.out.println(Format.center("Level 2: " + trophicLevelTwoCalories + " calories", 50)); // print trophic level two calories
	System.out.println(Format.center("Level 1: " + trophicLevelOneCalories + " calories", 50)); // print trophic level one calories
	
	}
	
	public static int multiplyByTen (int inNumber){ // method. It multiplies inNumber by ten. Then, returns type.
	int inNumberTimesTen = -7; // make inNumberTimesTen variable
	inNumberTimesTen = inNumber*10; // multiply inNumber by ten
	return inNumberTimesTen; // return result
	}
}
