import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static int k = 0;

    public static Integer Computermove(Integer key) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(key);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        if (args.length % 2 != 0) {
            while (true) {

                String key = Hmac.GenerateKey();
                Integer computerMove = Computermove(args.length);
                k = 1;
                System.out.println("HMAC: " + Hmac.hmacSha(key, args[computerMove]));
                for (String str : args) {
                    System.out.println(k + " - " + str);
                    k++;
                    if (k - 1 == args.length) {
                        System.out.println("0" + " - exit");
                        System.out.println("? - help");
                    }
                }
                System.out.print("Enter your move: ");
                String move = in.nextLine();
                for (int playerMove = 0; playerMove < k; playerMove++) {
                    String ni = Integer.toString(playerMove + 1);
                    if (move.equals(ni)) {
                        System.out.println("Your move: " + args[playerMove]);
                        System.out.println("Computer move: " + args[computerMove]);

                        int winner = Rules.calculate(playerMove, computerMove, args.length);
                        Rules.winner(winner);

                        System.out.println("HMAC key: " + key + '\n');
                        break;
                    } else if (move.equals("0")) {
                        System.exit(0);
                    } else if (move.equals("?")) {
                        table.createTable(args.length, args);
                        break;
                    }
                }
            }
        }
        else System.out.println("Invalid input!");
    }
}