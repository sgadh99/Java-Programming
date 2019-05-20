/*Sathya Gadhiraju
 This program creates an output word based on user input.*/

import java.util.Scanner; // import java.Scanner.util
public class PseudoWelsh{// class header
public static void main(String [] args){ // main method header
String ownObject = ""; // create variable for thing owned by someone
(ownObject) String
String adjective = ""; // create variable for adjective (adjective) String
String relativeObject = ""; // create variable for relative another object
(relativeObject) String
String s = ownObject+ adjective + relativeObject ; // create String s ,
concatenation of three other variables

Scanner readMe = new Scanner(System.in); // Scanner needed for getting
user input
System.out.println("Enter a thing owned by someone, as 'Jenny's house' or
'His Bridge'."); // prompt for thing owned by someone
ownObject = readMe.nextLine(); // read user input
System.out.println("Provide an adjective to describe " + ownObject + ".");
// prompt for adjective to describe thing owned by someone
adjective = readMe.nextLine(); // read user input
System.out.println("Enter how " + ownObject + " is relative to another
object, as 'next to river' or 'on top of hill'."); // prompt for how
object is relative to another object
relativeObject = readMe.nextLine(); // read user input
ownObject.toLowerCase(); // put the own object from user input to all
lower case
adjective.toLowerCase(); // put the adjective from user input to all lower
case
relativeObject.toLowerCase(); // put the relative object from user input
to all lower case
ownObject.trim(); // trim the user input of the own object
adjective.trim(); // trim the user input of the adjective
relativeObject.trim(); // trim the user input of the relative object
ownObject.replace("'", 'l');
ownObject.replace
}
}
