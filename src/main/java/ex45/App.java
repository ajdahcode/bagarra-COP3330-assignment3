/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex45;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class App {
    // Function to modify the text
    public static void modifytext (String name) throws IOException {
        // Copy the contents of the input file and put it into the new file
        File inputF = new File("src/main/java/ex45/"+ name +".txt");
        Path dest = inputF.toPath();
        Path src = Paths.get("src/main/java/ex45/exercise45_input.txt");
        Files.copy(src, dest);

        // This process will replace the word 'utilize' with the word 'use'
        String utilize = new String(Files.readAllBytes(dest));
        Charset charset = StandardCharsets.UTF_8;
        utilize = utilize.replaceAll("utilize", "use");
        Files.write(dest, utilize.getBytes(charset));

        System.out.print("Your file has been created.");
    }

    public static void main ( String[] args ) throws IOException {
        // Prompt for output file name and scan input
        Scanner scn = new Scanner(System.in);
        System.out.print("What name do you want for your output file? ");
        String outputN = scn.nextLine();

        // Function that will change the word 'utilize' to 'use'
        modifytext(outputN);
    }
}
