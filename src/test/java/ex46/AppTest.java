package ex46;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void freqFinder() throws FileNotFoundException {
        File file = new File(
                "src/test/java/ex46/exercise46_input.txt");
        App app = new App();
        Map<String,Integer> actual = app.freqFinder(new Scanner(file));
        Map<String,Integer> expected = new HashMap<>();
        expected.put("cats",1);
        expected.put("dog",2);

       assertEquals(expected,actual);

    }
}
