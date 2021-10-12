package ex42;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readfile() throws Exception {
        App app = new App();
        File file = new File(
                "src/test/java/ex42/exercise42_input.txt");
        String expected = String.format("\n%-10s %-10s %d", "Doe", "John", 0067);
        String actual = app.readfile(new Scanner(file));
        System.out.print(actual);
        assertEquals(expected, actual);
    }
}