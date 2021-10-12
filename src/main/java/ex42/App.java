/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex42;
import java.io.*;
import java.util.*;
import java.lang.*;

public class App {
    public static String readfile(Scanner scnN){
        String result = "";
        // Read in the text files
        while (scnN.hasNextLine()) {
            // Make an array that will split the text to ignore the commas
            String[] lines = scnN.nextLine().split(",");

            // Add each text to their respective arrays
            String Last = lines[0];
            String First = lines[1];
            int salary = Integer.parseInt(lines[2]);

            // Print out the last name, first name, and salary all aligned
            // System.out.printf("\n%-10s %-10s %d", Last, First,salary);
            String str = String.format("\n%-10s %-10s %d", Last, First,salary);
            result += str;
        }
        return result;
    }

    public static void main( String[] args ) throws Exception {
        // Read and Scan the file
        File file = new File(
                "C:\\Users\\AJ\\IdeaProjects\\demo\\bagarra-COP3330-assignment3\\src\\main\\java\\ex42\\exercise42_input.txt");
        Scanner scnN = new Scanner(file);

        // Print out headers
        System.out.print("Last       First      Salary\n"+
                "--------------------------");

        // Function used to read the file and output the first and last names and salary
        String output = readfile(scnN);
        System.out.print(output);

        scnN.close();
    }
}
