/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 alden bagarra
 */

package ex43;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void createdir (String site, String author, String folderJS, String folderCSS) throws IOException {

        // Make directory
        new File("src/main/java/ex43/" + site).mkdirs();

        // Copy html file into directory
        File index = new File("src/main/java/ex43/"+ site +"/index.html");
        Path dest = index.toPath();
        Path src = Paths.get("src/main/java/ex43/template.html");
        Files.copy(src, dest);

        // Replace the title tag with site from the newly created html file from created directory
        String title = new String(Files.readAllBytes(dest));
        Charset charset = StandardCharsets.UTF_8;
        title = title.replaceAll("Title", site);
        Files.write(dest, title.getBytes(charset));

        // Replace the meta tag with author from the newly created html file from created directory
        String meta = new String(Files.readAllBytes(dest));
        meta = meta.replaceAll("charset=\"UTF-8\"", author);
        Files.write(dest, meta.getBytes(charset));

        // Output the created websites
        System.out.print("Created ./website/"+ site);
        System.out.print("\nCreated ./website/"+ site +"/index.html");
        if(folderJS.equalsIgnoreCase("y") || folderJS.equalsIgnoreCase("yes")){
            System.out.print("\nCreated ./website/"+ site +"/js/");
        }
        if(folderCSS.equalsIgnoreCase("y") || folderCSS.equalsIgnoreCase("yes")){
            System.out.print("\nCreated ./website/"+ site +"/css/");
        }
    }
    public static void main (String[] args ) throws IOException {

        // Prompt and scan input
        Scanner scn = new Scanner(System.in);
        System.out.print("Site name: ");
        String site = scn.nextLine();
        System.out.print("Author: ");
        String author = scn.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        String folderJS = scn.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        String folderCSS = scn.nextLine();

        // Function that will do everything
        createdir(site, author, folderJS, folderCSS);
    }
}
