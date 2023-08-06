import java.util.Scanner;

import static utilit.Constant.ZERO;
import static utilit.Constant.BOX;
import static utilit.Constant.BOARD_SIZE;
import static utilit.Constant.PLAYER_SYMBOL;
import static utilit.Constant.TWO;
import static utilit.Constant.THREE;
import static utilit.Constant.COMPUTER_SYMBOL;
import static utilit.Constant.NINE;
import static utilit.Constant.ONE;
import static utilit.Constant.TEN;
import static utilit.Constant.LINE_SEPARATOR;

/**
 * This class represents the game processor that handles the game flow.
 */
final class Processor {
    private static boolean boxEmpty;
    private static byte winner = ZERO;

    private Processor() {
    }

    /**
     * This method starts the game.
     */
    public static void startGame() {

        System.out.println("Enter box number to select. Enjoy!" + LINE_SEPARATOR);

        do {

            Board.displayBoard(BOX);

            boxEmpty = Board.resetBoxIfEmpty(boxEmpty, BOX, BOARD_SIZE);

            if (Check.message(winner)) {
                break;
            }

            playerInput();

            if ((Check.checkWinForSymbol(PLAYER_SYMBOL, BOX))) {
                winner = TWO;
                continue;
            }

            boolean boxAvailable = Check.isBoxAvailable(BOX, BOARD_SIZE);

            if (!boxAvailable) {
                winner = THREE;
                continue;
            }

            computerRandomProgress();

            if ((Check.checkWinForSymbol(COMPUTER_SYMBOL, BOX))) {
                winner = TWO;
            }
        } while (true);
    }

    /**
     * This method is responsible for the progress of the computer.
     */
    private static void computerRandomProgress() {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (NINE - ONE + ONE) + ONE);
            if (utilit.Constant.BOX[rand - ONE] != PLAYER_SYMBOL && utilit.Constant.BOX[rand - ONE] != COMPUTER_SYMBOL) {
                utilit.Constant.BOX[rand - ONE] = COMPUTER_SYMBOL;
                break;
            }
        }
    }

    /**
     * This method is responsible for the player's progress.
     */
    private static void playerInput() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            byte input = scan.nextByte();
            if (input > ZERO && input < TEN) {
                if (utilit.Constant.BOX[input - ONE] == PLAYER_SYMBOL || utilit.Constant.BOX[input - ONE] == COMPUTER_SYMBOL) {
                    System.out.println("That one is already in use. Enter another.");
                } else {
                    utilit.Constant.BOX[input - ONE] = PLAYER_SYMBOL;
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }
}
