import java.util.Arrays;

public class Host {
    static public String currentWord="hangman";
    static public String guessedWord = "";
    static private final char[] man = {'O', '|', '/', '\\',  '/', '\\'};
    static public int stage = 0;
    static private String[] board = {"HANGMAN\n", " +---+\n", "     |\n",  "     |\n",  "     |\n",  "    ===\n\n", drawBlanks() + "\n", "Missed Letters: "};
    static private String[] dictionary = {"cat", "bat", "rat", "mat"};

    public static String drawBoard(){
        return Arrays.stream(board)
                        .reduce("", (acc, line) -> acc+line);
    }

    public static boolean play() {
        if (stage > 5) {
            System.out.println(drawBoard());
            System.out.println("You have lost.");
            return false;
        } else if (guessedWord.equals(currentWord)) {
            System.out.println("You have won.");
            return false;
        }
        return true;
    }

    public static void drawMan(int stage) {
        switch(stage) {
            case 1:
                board[2] = board[2].substring(0,1) + man[0] + board[2].substring(2);
                break;
            case 2:
                board[3] = board[3].substring(0,1) + man[1] + board[3].substring(2);
                break;
            case 3:
                board[3] = board[3].substring(0, 0) + man[2] + board[3].substring(1);
                break;
            case 4:
                board[3] = board[3].substring(0, 2) + man[3] + board[3].substring(3);
                break;
            case 5:
                board[4] = board[4].substring(0, 0) + man[4] + board[4].substring(1);
                break;
            case 6:
                board[4] = board[4].substring(0, 2) + man[5] + board[4].substring(3);
                break;
        }
    }

    public static void checkLetter(char letter) {
        if (currentWord.contains(Character.toString(letter))) {
            System.out.println("You got one");
            addLetter(letter);
        } else {
            board[7] += letter;
            stage++;
            drawMan(stage);
        }
    }

    private static void addLetter(char letter) {
        for (int i = 0; i < currentWord.length(); i++){
            if(currentWord.charAt(i) == letter){
                board[6] = board[6].substring(0, i) + letter + board[6].substring(i + 1);
                guessedWord = guessedWord.substring(0, i) + letter + guessedWord.substring(i + 1);
            }
        }
    }

    public static String drawBlanks() {
        int letters = currentWord.length();
        String blanks = "";
        for(int i = 0; i < letters; i++){
            blanks += "_";
            guessedWord += " ";
        }
        return blanks;
    }

    public static void setCurrentWord(String word){
        currentWord = word;
    }
}
