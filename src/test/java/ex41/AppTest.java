package ex41;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readfile() throws Exception {
        App app = new App();
        File file = new File(
                "src/test/java/ex41/exercise41_input.txt");
        app.readfile(file, new Scanner(file), 0);
    }
}