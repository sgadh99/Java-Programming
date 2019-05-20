/*Sathya Gadhiraju
 This class prints the words number of times given from input.*/
 
 class OutputAd{ // class header
     String words; // make words variable
     int number; // make number variable
     
     public OutputAd(String w, int n){ // header for constructor, accepting 2 parameters
         words = w; // set String to input String
         number = n; // set int to input number
     }
     public void printOutput(){ // header for printOutput
         for(int i= 0; i < number; i++){ // loop for printing
             System.out.print(words+ " ");
         } // close loop
         System.out.println();
     }
 }
