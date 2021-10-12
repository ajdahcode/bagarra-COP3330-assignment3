package ex44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readJson() {
        App app = new App();
        assertFalse(app.readJson("output"));
    }
}
