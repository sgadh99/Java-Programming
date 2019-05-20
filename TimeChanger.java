/*Sathya Gadhiraju
 This program accepts time from user and converts using TimeMath.java */
 
 import java.util.Scanner; // import libraries
 public class TimeChanger { // class header
  public static void main(String [] args) { // main method header
  
   int timeCalifornia = -2; // make timeCalifornia variable
   int timeDallas = -3; // make timeDallas variable
   int timeTampa = -4; // make timeTampa variable
  
   System.out.print("What is the time in California? (enter in military format)"); // prompt for California time
   Scanner readMe = new Scanner(System.in); // create Scanner instance
   timeCalifornia = readMe.nextInt(); // read user input
  
   TimeMath convertIt = new TimeMath(); // create TimeMath instance
   timeDallas = convertIt.makeDallasTime(timeCalifornia); // call makeDallasTime method
   timeTampa = convertIt.makeTampaTime(timeCalifornia); // call makeTampaTime method
   
      System.out.println(Format.left("Place", 20) + ("Time")); // print header
      System.out.println(Format.left("California", 20) + timeCalifornia); // print California time
      System.out.println(Format.left("Dallas", 20) + timeDallas); // print Dallas time
      System.out.println(Format.left("Tampa", 20) + timeTampa); // print Tampa time
  }
}
