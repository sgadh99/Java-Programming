/*Sathya Gadhiraju
 This program prints a christmas tree. The amount of rows in the christmas tree are based on user input.*/
 
 import java.util.Scanner; // import libraries
 public class HolidayTree{ // class header
  public static void main(String [] args){ // main method header
  
   int tall = -3; // make tall variable
   int blanks = -4; // make blanks variable
   int numCharacters = -5; // make numCharacters variable
   char printCharacter = 'a'; // make printCharacter variable
  
   Scanner readMe= new Scanner(System.in); // make scanner instance
  
   do{
    System.out.print("How tall is your tree (in whole feet)?"); // prompt user for height of tree (how many rows)
    tall = readMe.nextInt(); // read height
   }while(tall<=0 || tall>=30); // while
   for(int counter = 1; counter<tall; counter++) // for
   {
    switch(counter) { // switch for character
    case 1 : printCharacter = '*';break; // case 1 switch
    default : printCharacter = '#';break; // default switch
       }
      
      blanks = tall-counter-1; // calculate blanks
   numCharacters = counter*2-1; // calculate numCharacters
   
   for(int b = 0; b<blanks; b++) // print first blanks
    System.out.print(' ');
    
   for(int c = 0; c<numCharacters; c++) // print tree characters
    System.out.print(printCharacter);
    
   for(int b = 0; b<blanks; b++) // print last blanks
    System.out.print(' ');
   System.out.println();
   
   }
      if(tall>1) // if tall greater than 1
   System.out.print(Format.center("!", tall*2-1)); // print trunk and format to center
  
  }
 }
