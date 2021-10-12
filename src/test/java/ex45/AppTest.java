package ex45;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void modifytext() throws IOException {
        App app = new App();
        app.modifytext("test");
        Path testPath = Paths.get("src/main/java/ex45/test.txt");
        boolean exists = Files.exists(testPath);
        assertTrue(exists);
        if (exists) Files.delete(testPath);
    }
}
