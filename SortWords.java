/*Sathya Gadhiraju
This program sorts words from a text file.*/

import java.util.Scanner;
import java.io.*;
public class SortWords{
        File y = new File("SortWords.txt");
        public static void main(String [] args){
                String a = "";
                File inputFile = new File("SortWords.txt");
                // Declare variable to read user input.
                String x[] = new String[5]; // Declare array for words (file) in txt.
                Scanner readMe =  null;
                Scanner readIn = new Scanner(System.in);
                try{
                    readMe = new Scanner(inputFile); // Scanner
                }
                catch(FileNotFoundException ex)
                {
                    System.out.println("Cannot open SortWords.txt");
                    System.exit(1);
                }
                for(int i = 0; i<5; i++){
                    if(readMe.hasNext()){
                        x [i] = readMe.next(); // Read the words in the txt file.
                    }
                    else{
                        break;
                    }
                }

                System.out.print("Which sort do you think should be used? Type 'Bubble', 'Selection', or 'Insertion'.");
                a = readIn.next(); // Read user input.
                if(a.equals("Bubble")){ // If the user types Bubble.
                        System.out.print("The bubble sort is the most inefficient sort as it requires the most steps. 
                        It compares and swaps two elements at a time, so it takes a long time.");
                        BubbleSort(x);
                }
                else if(a.equals("Selection")){ // If the user types Selection.
                        System.out.print("The selection sort looks at the whole array, rather than just bits and pieces of
                        it. It is more efficient than the Bubble Sort.");
                        SelectionSort(x);
                }
                else if(a.equals("Insertion")) {// If the user types Insertion.
                        System.out.print("The insertion sort is the most efficient sort. It compares items in the array and inserts another element once it finds the correct
                        place. It starts from the beginning. It is very useful when the elements in the array are close to
                        being sorted correctly.");
                        InsertionSort(x);
                }
                    //Sorted words

                    for(int i = 0; i<x.length; i++){
                        System.out.println(x[i]);
                    }
         }
                public static void SelectionSort(String[] x){
                        int i;
                        int j;
                        int first;
                        String temp;
                        for(i= x.length-1; i>0; i--){
                                first= 0;
                                for(j= 1; j<=i; j++) {
                                        if(x[first].compareTo(x[j])<0)
                                           first = j;
                                 }
                                        temp= x[first];
                                        x[first] = x[i];
                                        x[i] = temp;
                                }
                        }
                public static void InsertionSort(String [] x){

                // Sort the words (from code on paper).
                int j;
                String key;
                int i;
                // Declare variables j, key, and i.

                for(j = 1; j < x.length; j++){
                    key = x[j];
                        //if(x[i].compareTo(x[i+1])<0){ // Use compareTo String method.
                                for(i = j - 1; (i >= 0) && (key.compareTo(x[i])<0); i--){
                                        x[i+1] = x[i];
                        }
                        x[i+1] = key;
                }
        }

        public static void BubbleSort(String [] x){
        int j;
        boolean flag = true;
        String temp;

        while(flag){
                flag= false;
                for(j=0; j<x.length-1; j++)
                {
                        if(x[j+1].compareTo(x[j])<0)
                        {
                                temp = x[j];
                                x[j] = x[j+1];
                                x[j+1] = temp;
                                flag = true;
                      }
                }
        }
        }
    }
