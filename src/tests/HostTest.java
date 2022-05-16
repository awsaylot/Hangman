import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HostTest {

    @BeforeEach
    void setUp() {
        Host.setCurrentWord("hangman");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setCurrentWord(){
        Host.setCurrentWord("jail");
        assertEquals("jail", Host.currentWord);
    }

    @Test
    void drawBoard() {
        assertEquals("String", Host.drawBoard().getClass().getSimpleName());
    }

    @Test
    void play() {
        assertEquals(true, Host.play());
    }

    @Test
    void drawMan() {
        Host.drawMan(3);
        assertEquals("String", Host.drawBoard().getClass().getSimpleName());
    }

    @Test
    void checkLetter() {
        Host.checkLetter('r');
        assertEquals(1, Host.stage);
    }

    @Test
    void drawBlanks() {
        assertEquals(7, Host.drawBlanks().length());
    }
}