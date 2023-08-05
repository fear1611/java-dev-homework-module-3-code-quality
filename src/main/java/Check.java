import static utilit.Constant.*;

final class Check {

    private Check() {
    }

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

    public static boolean checkWinForSymbol(final char symbol, final char[] box) {
        return isRows(symbol, box) || isColum(symbol, box) || isDiagonals(symbol, box);
    }

    private static boolean isDiagonals(final char symbol, final char[] box) {
        int[] diagonalIndices = {0, 4, 8, 2, 4, 6};

        for (int i = 0; i < diagonalIndices.length; i += 3) {
            if (box[diagonalIndices[i]] == symbol && box[diagonalIndices[i + 1]] == symbol && box[diagonalIndices[i + 2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    private static boolean isColum(final char symbol, final char[] box) {
        int[][] columnIndices = {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}};

        for (int i = 0; i < columnIndices.length; i++) {
            if (box[columnIndices[i][0]] == symbol && box[columnIndices[i][1]] == symbol && box[columnIndices[i][2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    private static boolean isRows(final char symbol, final char[] box) {
        int[][] rowIndices = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

        for (int i = 0; i < rowIndices.length; i++) {
            if (box[rowIndices[i][0]] == symbol && box[rowIndices[i][1]] == symbol && box[rowIndices[i][2]] == symbol) {
                return true;
            }
        }

        return false;
    }

}
