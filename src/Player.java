import java.util.List;
import java.util.Scanner;

public abstract class Player {
    String symbol; // "X" or "O"

    public Player(String symbol) {
        this.symbol = symbol;
    }

    // Attempt to make a move on the board at row, col
    public void move(Board board, int row, int col) {
        board.board[row][col] = symbol;
    }

    public abstract Integer makeMove(Board board);

}