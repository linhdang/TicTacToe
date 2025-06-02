import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            game.board.draw();

            // Get current player
            Player currentPlayer = game.currentPlayer;
            System.out.println("the current player is " + game.currentPlayer.symbol);

            // Get available moves
            List<Integer> availableMoves = game.board.getAvailableMoves();
            if (availableMoves.isEmpty()) {
                System.out.println("It's a draw!");
                break;
            }

            System.out.println("Available moves: " + availableMoves);
            System.out.print("Enter your move (1-9): ");

            int move = scanner.nextInt();

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
