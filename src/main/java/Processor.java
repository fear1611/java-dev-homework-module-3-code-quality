import java.util.Scanner;

final class Processor {
    private Processor() {
    }
    private static final byte BOARD_SIZE = 9;
    private static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';
    private static boolean boxEmpty;
    private static byte winner = 0;

    public static void startGame() {

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {

            Board.dyspley(BOX);

            boxEmpty = Board.isBoxEmpty(boxEmpty, BOX, BOARD_SIZE);

            if (Check.message(winner)) {
                break;
            }

            playerInput();

            if ((Check.checkWinForSymbol(PLAYER_SYMBOL, BOX))) {
                winner = 1;
                continue;
            }

            boolean boxAvailable = Check.isBoxAvailable(BOX, BOARD_SIZE);

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            computerRandomProgress();

            if ((Check.checkWinForSymbol(COMPUTER_SYMBOL, BOX))) {
                winner = 2;
            }
        }
    }

    private static void computerRandomProgress() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (BOX[rand - 1] != PLAYER_SYMBOL && BOX[rand - 1] != COMPUTER_SYMBOL) {
                BOX[rand - 1] = COMPUTER_SYMBOL;
                break;
            }
        }
    }


    private static void playerInput() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (BOX[input - 1] == PLAYER_SYMBOL || BOX[input - 1] == COMPUTER_SYMBOL) {
                    System.out.println("That one is already in use. Enter another.");
                } else {
                    BOX[input - 1] = PLAYER_SYMBOL;
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }
}
