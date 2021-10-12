/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex44;
import com.google.gson.Gson;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    // Function for reading in JSON file and returns true or false
    // True if product isn't there
    // False if product is there
    public static boolean readJson(String inputname) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/ex44/exercise44_input.json"));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {

                // Boolean to set return statement
                Boolean flag = false;

                // Checks to see if the product is there or not and print out the product information
                List <Object> list = (List<Object>) entry.getValue();
                for (Object obj : list){
                    Map <String, String> innerEntry = (Map <String, String>) obj;
                    if(innerEntry.get("name").equalsIgnoreCase(inputname)) {
                        System.out.println("Name: " + innerEntry.get("name"));
                        String price = String.valueOf(innerEntry.get("price"));
                        Double priceD = Double.parseDouble(price);
                        System.out.printf("Price: %.2f\n", priceD);
                        String quantity = String.valueOf(innerEntry.get("quantity"));
                        Double quantityD = Double.parseDouble(quantity);
                        System.out.printf("Quantity: %.0f", quantityD);
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("Sorry, that product was not found in our inventory.");
                    return true;
                }
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main ( String[] args ){
        // Prompt for product name and take input
        Scanner scn = new Scanner (System.in);
        System.out.print("What is the product name? ");
        String name = scn.nextLine();

        // Boolean for output of the function
        Boolean flag = readJson(name);

        // If function came out true then it means that the product isn't there and continue looping
        // the question until the product is there and get out of loop and print results from function
        while(flag == true){
            System.out.print("What is the product name? ");
            name = scn.nextLine();
            flag = readJson(name);
        }
    }

}
