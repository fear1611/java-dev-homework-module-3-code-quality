import static utilit.Constant.BOARD_SIZE;
import static utilit.Constant.THREE;
import static utilit.Constant.SIX;
import static utilit.Constant.EMPTY;
import static utilit.Constant.ZERO;
import static utilit.Constant.ONE;
import static utilit.Constant.TWO;
import static utilit.Constant.HORIZONTAL_LINE;
import static utilit.Constant.VERTICAL_LINE;

/**
 * This class is responsible for displaying the game board draws.
 */

final class Board {
    private Board() {
    }

    /**
     * Displays the game board.
     * @param box Game board
     */
    public static void displayBoard(final char[] box) {
        for (int i = ZERO; i < BOARD_SIZE; i += THREE) {
            System.out.println("\n " + box[i] + VERTICAL_LINE + box[i + ONE] + VERTICAL_LINE + box[i + TWO] + " ");
            if (i < SIX) {
                System.out.print(HORIZONTAL_LINE);
            }
        }
        System.out.println();
    }

    /**
     * Checks if the box is empty, and if it was not empty then clears it.
     * @param boxEmpty Indicates whether the box was initially empty
     * @param box Game board
     * @param boardSize Board Size
     * @return Returns tru as the board was empty
     */
    public static boolean resetBoxIfEmpty(final boolean boxEmpty, final char[] box, final byte boardSize) {
        if (!boxEmpty) {
            for (byte i = ZERO; i < boardSize; ++i) {
                box[i] = EMPTY;
            }
        }
        return true;
    }
}
