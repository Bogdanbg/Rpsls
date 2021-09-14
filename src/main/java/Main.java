import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static int k = 0;

    public static Integer Computermove(Integer key) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(key);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        int length = args.length;
        boolean isDuplicate = false;
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (Objects.equals(args[i], args[j])) {
                    isDuplicate = true;
                    break;
                }
            }
        }
        if(args.length < 2){
            System.out.println("Not enough parameters!");
        }else if (args.length % 2 == 0) {
            System.out.println("The number of parameters is even!");
        }else if(isDuplicate){
            System.out.println("Parameters are duplicated!");
        }
        else{
            while (true) {

                String key = Hmac.GenerateKey();
                Integer computerMove = Computermove(args.length);
                k = 1;
                System.out.println("HMAC: " + Hmac.hmacSha(key, args[computerMove]));
                System.out.println("Available moves: \n");

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
                        System.exit(0);
                    } else if (move.equals("0")) {
                        System.exit(0);
                    } else if (move.equals("?")) {
                        table.createTable(args.length, args);
                        System.exit(0);
                    }
                }
            }
        }
    }
}