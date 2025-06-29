import java.util.ArrayList;
import java.util.List;

public class Board {

    String[][] board = new String[3][3];
    public void initialize() {
        int value = 1;

        // Fill the board with strings "1" to "9"
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = String.valueOf(value++);
            }
        }
    }

    public void draw() {
        System.out.println("|---|---|---|");
        for (int row = 0; row < 3; row++) {
            System.out.printf("| %s | %s | %s |\n", board[row][0], board[row][1], board[row][2]);
            System.out.println("|-----------|");
        }
    }

    /**
     * Checks if there's a winner on the board.
     * @return "X" or "O" if there's a winner, or null if there's no winner yet
     */
    public String getWinningSymbol() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(board[row][1]) &&
                    board[row][1].equals(board[row][2])) {
                return board[row][0];
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(board[1][col]) &&
                    board[1][col].equals(board[2][col])) {
                return board[0][col];
            }
        }

        // Check main diagonal
        if (board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2])) {
            return board[0][0];
        }

        // Check anti-diagonal
        if (board[0][2].equals(board[1][1]) &&
                board[1][1].equals(board[2][0])) {
            return board[0][2];
        }

        // No winner
        return null;
    }

    /**
     * Returns a list of available move positions (1–9) on the board.
     * A cell is available if it is not already "X" or "O".
     *
     * @return list of available positions (1 to 9)
     */
    public List<Integer> getAvailableMoves() {
        List<Integer> moves = new ArrayList<>();

        int position = 1; // Start from 1 to 9
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                String cell = this.board[row][col];
                if (!cell.equals("X") && !cell.equals("O")) {
                    moves.add(position);
                }
                position++;
            }
        }

        return moves;
    }

    public Board copy() {
        Board cloned =  new Board();
        for (int i=0; i < 3; i++) {
            cloned.board[i] = board[i].clone();
        }
        return cloned;
    }
}
