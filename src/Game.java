public class Game {
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Board board;

    // Translates a 1–9 position into (row, col) and makes the move
    public boolean move(int position) {
        if (position < 1 || position > 9) {
            System.out.println("Invalid position! Must be between 1 and 9.");
            return false;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        currentPlayer.move(board, row, col);
        switchTurn();
        return true;
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playerX = new Player("X");
        game.playerO = new Player("O");
        game.board = new Board();
        game.board.initialize();
        game.currentPlayer = game.playerX;
        System.out.println("New game, with the current player is " + game.currentPlayer.symbol);
        game.board.draw();

        game.move(3);
        System.out.println("the current player is " + game.currentPlayer.symbol);
        game.board.draw();

    }
}
