import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void setPlayerInput() {
        String initialStream = "r";
        InputStream targetStream = new ByteArrayInputStream(initialStream.getBytes());
        assertEquals("r", Player.setPlayerInput(targetStream));
    }


    @org.junit.jupiter.api.Test
    void getCurrentLetter() {
        String initialStream = "r";
        InputStream targetStream = new ByteArrayInputStream(initialStream.getBytes());
        Player.setPlayerInput(targetStream);
        assertEquals('r', Player.getCurrentLetter());
    }
}