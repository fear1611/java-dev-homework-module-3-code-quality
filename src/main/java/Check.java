final class Check {
    private static final String MESSAGE_WIN = "You won the game!\nThanks for playing!";
    private static final String MESSAGE_LOST = "You lost the game!\nThanks for playing!";
    private static final String MESSAGE_DRAW = "It's a draw!\nThanks for playing!";
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';

    private Check() {
    }

    public static boolean message(final byte winner) {
        if (winner == 1) {
            System.out.println(MESSAGE_WIN);
            return true;
        } else if (winner == 2) {
            System.out.println(MESSAGE_LOST);
            return true;
        } else if (winner == 3) {
            System.out.println(MESSAGE_DRAW);
            return true;
        }

        return false;
    }

    public static boolean isBoxAvailable(final char[] box, final byte boardSize) {
        boolean boxAvailable = false;
        for (byte i = 0; i < boardSize; i++) {
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
        return (box[0] == symbol && box[4] == symbol && box[8] == symbol)
                || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private static boolean isColum(final char symbol, final char[] box) {
        return (box[0] == symbol && box[3] == symbol && box[6] == symbol)
                || (box[1] == symbol && box[4] == symbol && box[7] == symbol)
                || (box[2] == symbol && box[5] == symbol && box[8] == symbol);
    }

    private static boolean isRows(final char symbol, final char[] box) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol)
                || (box[3] == symbol && box[4] == symbol && box[5] == symbol)
                || (box[6] == symbol && box[7] == symbol && box[8] == symbol);
    }

}
