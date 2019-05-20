/*Sathya Gadhiraju
 10-16-13
 This program asks which words you would like to print and how many times you want to print it, until you press terminate.*/
 
 import java.util.Scanner; // import libraries
 public class GetInfo{ // class header 
     static String words = ""; // make static variable words
     static int number = -2; // make static variable number
     public static void main(String [] args){ // main method header 
         do{
             askForInput(); // call askForInput()
             OutputAd printBanner = new OutputAd(words, number); // create instance of second class
             if(number!= -1)
                printBanner.printOutput(); // call printOutput() by using instance
            } while(number != -1); // test condition
        }
    
        public static void askForInput(){// header for askForInput()
            Scanner readMe = new Scanner(System.in);
            System.out.println("What words would you like to print?"); // prompt for words
            words = readMe.nextLine(); // read user input
            System.out.println("How many times would you like to print? Press -1 to terminate."); // prompt for how many times
            number = readMe.nextInt(); // read user input
        }
    }

