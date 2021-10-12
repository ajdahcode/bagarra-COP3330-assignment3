/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex46;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class App {

    // Function for finding the frequency of a word
    public static void freqFinder(Scanner scn){
        // Create a map
        Map<String, Integer> freq = new HashMap<String, Integer>();

        // Create an array
        ArrayList<String> word = new ArrayList<String>();

        // Process of reading and adding the words into an array and map
        while (scn.hasNextLine()) {
            String data = scn.nextLine();
            String[] words = data.split(" ");
            for(String w : words){
                // System.out.println(w);
                word.add(w);
                if(!freq.containsKey(w)){
                    freq.put(w, 1);
                }
                else{
                    freq.put(w, freq.get(w)+1);
                }
            }
        }

        // Process of putting the word frequency of highest to lowest
        Map<String, Integer> sortFreq = freq.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        // Print out the word and their frequency by using '*'
        for (Map.Entry<String, Integer> entry : sortFreq.entrySet()) {
            System.out.printf("%-11s", entry.getKey() + ":");

            for(int i = 0; i < entry.getValue(); i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main( String[] args ) throws Exception {
        // Open the file and take in the strings
        File file = new File(
                "src/main/java/ex46/exercise46_input.txt");
        Scanner scn = new Scanner(file);

        // Function used to find the frequency of the words
        freqFinder(scn);
    }
}
