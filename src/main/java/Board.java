import static utilit.Constant.BOARD_SIZE;
import static utilit.Constant.THREE;
import static utilit.Constant.SIX;
import static utilit.Constant.EMPTY;
import static utilit.Constant.ZERO;

final class Board {
    private Board() {
    }

    public static void displayBoard(final char[] box) {
        for (int i = ZERO; i < BOARD_SIZE; i += THREE) {
            System.out.println("\n " + box[i] + " | " + box[i + 1] + " | " + box[i + 2] + " ");
            if (i < SIX) {
                System.out.print("-----------");
            }
        }
        System.out.println();
    }

    public static boolean isBoxEmpty(final boolean boxEmpty, final char[] box, final byte boardSize) {
        if (!boxEmpty) {
            for (byte i = ZERO; i < boardSize; i++) {
                box[i] = EMPTY;
            }
        }
        return true;
    }
}
