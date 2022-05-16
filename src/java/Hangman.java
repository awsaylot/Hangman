public class Hangman {
    public static void main(String[] args) {

        boolean play = true;
        while(play) {
            play = Host.play();
            System.out.println(Host.drawBoard());
            if (play == false) {
                break;
            }
            try {
                String guess = Player.setPlayerInput(System.in);
                if (guess.length() > 1) {
                    throw new InputTooLong("Input is too long");
                }
            } catch (Exception e) {
                System.out.println("Something went wrong, try again.");
                Player.setPlayerInput(System.in);
            }
            Host.checkLetter(Player.getCurrentLetter());
        }
    }
}
