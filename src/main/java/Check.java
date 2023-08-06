import static utilit.Constant.ONE;
import static utilit.Constant.MESSAGE_WIN;
import static utilit.Constant.TWO;
import static utilit.Constant.MESSAGE_LOST;
import static utilit.Constant.THREE;
import static utilit.Constant.MESSAGE_DRAW;
import static utilit.Constant.ZERO;
import static utilit.Constant.PLAYER_SYMBOL;
import static utilit.Constant.COMPUTER_SYMBOL;
import static utilit.Constant.FIVE;
import static utilit.Constant.FOUR;
import static utilit.Constant.SIX;
import static utilit.Constant.SEVEN;
import static utilit.Constant.EIGHT;

/**
 *This class is responsible for checking the gain.
 */
final class Check {

    private Check() {
    }

    /**
     * This method is used to display the appropriate message depending on the game result.
     * @param winner This parameter accepts a number from one to three
     * @return Returns false if the condition is not met
     */
    public static boolean message(final byte winner) {
        if (winner == ONE) {
            System.out.println(MESSAGE_WIN);
            return true;
        } else if (winner == TWO) {
            System.out.println(MESSAGE_LOST);
            return true;
        } else if (winner == THREE) {
            System.out.println(MESSAGE_DRAW);
            return true;
        }

        return false;
    }

    /**
     * This method checks if there are still available spaces on the game board.
     * @param box Game board
     * @param boardSize Board Size
     * @return Returns false if all slots are occupied
     */
    public static boolean isBoxAvailable(final char[] box, final byte boardSize) {
        boolean boxAvailable = false;
        for (byte i = ZERO; i < boardSize; ++i) {
            if (box[i] != PLAYER_SYMBOL && box[i] != COMPUTER_SYMBOL) {
                boxAvailable = true;
                break;
            }
        }

        return boxAvailable;
    }

    /**
     * This method checks all winning options.
     * The first sorter is arrayed if all rows are filled
     * The second sorter in the array checks if all columns are filled
     * The third sorter in the array checks if all diagonals are filled
     * @param symbol Player or computer symbol
     * @param box Game board
     * @return Returns true if one of the selectors is filled
     */
    public static boolean checkWinForSymbol(final char symbol, final char[] box) {
        int[][] winPatterns = {
                {ZERO, ONE, TWO}, {THREE, FOUR, FIVE}, {SIX, SEVEN, EIGHT},
                {ZERO, THREE, SIX}, {ONE, FOUR, SEVEN}, {TWO, FIVE, EIGHT},
                {ZERO, FOUR, EIGHT}, {TWO, FOUR, SIX}
        };

        for (int i = ZERO; i < winPatterns.length; i++) {
            int a = winPatterns[i][ZERO];
            int b = winPatterns[i][ONE];
            int c = winPatterns[i][TWO];

            if (box[a] == symbol && box[b] == symbol && box[c] == symbol) {
                return true;
            }
        }

        return false;
    }

}
