import java.util.Scanner;

public class Game {
    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

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

        currentPlayer.move(position, this.board);
        switchTurn();
        return true;
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        game.playerX = new HumanPlayer("X", scanner, game);
        game.playerO = new MachinePlayer("O", game);
        game.board = new Board();
        game.board.initialize();
        game.currentPlayer = game.playerX;
        System.out.println("New game, with the current player is " + game.currentPlayer.symbol);
        while (true) {
            game.board.draw();
            // Get current player

            System.out.println("the current player is " + game.currentPlayer.symbol);
            Player currentPlayer = game.currentPlayer;
            Integer move = currentPlayer.makeMove(game.board);
            if (move == null) break;

            // Attempt move
            boolean success = game.move(move);
            if (!success) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Check for winner
            String winnerSymbol = game.board.getWinningSymbol();
            if (winnerSymbol != null) {
                game.board.draw();
                System.out.println("Player " + winnerSymbol + " wins!");
                break;
            }
        }

        scanner.close();

    }

}
