import java.security.SecureRandom;

public class Rules {
    public static Integer calculate(Integer playerMove, Integer computerMove, Integer moves) {
        int win = 0;
        int d = (moves + playerMove - computerMove) % moves;
        if (d == 0) {
            win = 0;
        } else if (d % 2 == 1) {
            win = 1;
        }
        else if (d % 2 == 0) {
            win = -1;
        }
        return win;
    }

    public static void winner(Integer k) {
        if (k == 0) {
            System.out.println("Draw!");
        } else if (k == 1) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer win!");
        }
    }
}