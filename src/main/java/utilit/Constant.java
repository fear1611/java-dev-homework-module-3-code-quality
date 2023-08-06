package utilit;

/**
 * His is a utility class.
 */
public final class Constant {
    public static final byte ZERO = 0;
    public static final byte ONE = 1;
    public static final byte TWO = 2;
    public static final byte THREE = 3;
    public static final byte FOUR = 4;
    public static final byte FIVE = 5;
    public static final byte SIX = 6;
    public static final byte SEVEN = 7;
    public static final byte EIGHT = 8;
    public static final byte NINE = 9;
    public static final byte TEN = 10;
    public static final byte BOARD_SIZE = 9;
    public static final char EMPTY = ' ';
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String THANKS = "Thanks for playing!";
    public static final String MESSAGE_WIN = "You won the game!"
            + LINE_SEPARATOR
            +  THANKS;
    public static final String MESSAGE_LOST = "You lost the game!"
            + LINE_SEPARATOR
            + THANKS;
    public static final String MESSAGE_DRAW = "It's a draw!"
            + LINE_SEPARATOR
            + THANKS;
    public static final String HORIZONTAL_LINE = "-----------";
    public static final String VERTICAL_LINE = " | ";
    public static final char PLAYER_SYMBOL = 'X';
    public static final char COMPUTER_SYMBOL = 'O';
    public static final char[] BOX = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Constant() {
    }
}
