import java.util.Scanner;
import java.io.InputStream;

public class Player {
    private static char currentLetter;

    private static void setCurrentLetter(String letter) {
        currentLetter = letter.charAt(0);
    }

    public static String setPlayerInput(InputStream in) {
        System.out.println("Select a letter.");
        Scanner scan = new Scanner(in);
        String guess = scan.nextLine();
        setCurrentLetter(guess);
        return guess;
    }

    public static char getCurrentLetter() {
        return currentLetter;
    }
}
