public abstract class Player {
    String symbol; // "X" or "O"
    Game game;
    public Player(String symbol, Game game) {
        this.symbol = symbol;
        this.game = game;
    }

    // Attempt to make a move on the board at row, col
    public void move(Board board, int row, int col) {
        board.board[row][col] = symbol;
    }

    public abstract Integer makeMove(Board board);

    void move(int position, Board board) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        move(board, row, col);
    }
}