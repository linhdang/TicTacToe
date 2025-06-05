import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{
    private final Scanner scanner;
    public HumanPlayer(String symbol, Scanner scanner) {
        super(symbol);
        this.scanner = scanner;
    }


    public Integer makeMove(Board board) {


        // Get available moves
        List<Integer> availableMoves = board.getAvailableMoves();
        if (availableMoves.isEmpty()) {
            System.out.println("It's a draw!");
            return null;
        }

        System.out.println("Available moves: " + availableMoves);
        System.out.print("Enter your move (1-9): ");

        return scanner.nextInt();
    }
}
