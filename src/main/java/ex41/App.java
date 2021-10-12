/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex41;
import java.io.*;
import java.util.*;


public class App {
    public static void readfile (File filepath, Scanner scnN, int count){
        // Create an array
        ArrayList<String> input = new ArrayList<>();

        // Read in the number of lines and add the text in the array
        while (scnN.hasNextLine()) {
            count++;
            input.add(scnN.nextLine());
        }

        // Function used to alphabetize the names
        Collections.sort(input);

        // Print out the total # of names
        System.out.print("Total of  " + count +" names\n"+
                "-----------------");

        // Print out the names
        for(int i = 0; i < input.size(); i++){
            System.out.print("\n"+ input.get(i));
        }
    }

    public static void main( String[] args ) throws Exception {
        // Read and Scan the file
        File file = new File(
                "C:\\Users\\AJ\\IdeaProjects\\demo\\bagarra-COP3330-assignment3\\src\\main\\java\\ex41\\exercise41_input.txt");
        Scanner scnN = new Scanner(file);

        // Function used to read the file and output the count and names
        readfile(file, scnN, 0);

        scnN.close();
    }
}
