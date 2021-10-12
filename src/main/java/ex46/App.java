/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex46;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class App {
    // Function for finding the freqMapuency of a word
    public static Map<String, Integer> freqFinder(Scanner scn){
        // Create a map
        Map<String, Integer> freqMap = new HashMap<String, Integer>();

        // Process of reading and adding the words into an array and map
        while (scn.hasNextLine()) {
            String data = scn.nextLine();
            String[] words = data.split(" ");
            for(String w : words){
                if(!freqMap.containsKey(w)){
                    freqMap.put(w, 1);
                }
                else{
                    freqMap.put(w, freqMap.get(w)+1);
                }
            }
        }

        // Process of putting the word freqMapuency of highest to lowest
        Map<String, Integer> sortedfreqMap = freqMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        return sortedfreqMap;
    }

    public static void printMap(Map<String,Integer> map) {
        // Print out the word and their freqMapuency by using '*'
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
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

        // Function used to find the freqMapuency of the words
        Map<String, Integer> wordMap = freqFinder(scn);
        printMap(wordMap);
    }
}
