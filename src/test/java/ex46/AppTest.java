package ex46;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

class AppTest {

    @Test
    void freqFinder() throws Exception {
        App app = new App();
        File file = new File(
                "src/test/java/ex46/exercise46_input.txt");
        Scanner scn = new Scanner(file);
        app.freqFinder(scn);
    }
}
