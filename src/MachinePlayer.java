import java.util.List;
import java.util.Random;

public class MachinePlayer extends Player{
    private final Random random = new Random();

    public MachinePlayer(String symbol, Game game) {
        super(symbol, game);
    }

    @Override
    public Integer makeMove(Board board) {
        List<Integer> availableMoves =board.getAvailableMoves();
        Player opponent = getOpponent();

        // Step 1: Try to block opponent's winning move
        for (int possibleMove : availableMoves) {
            Board tempBoard = board.copy(); // Make a copy so we don't modify the real board
            opponent.move(possibleMove, tempBoard);
            if (tempBoard.getWinningSymbol() != null && tempBoard.getWinningSymbol().equals(opponent.symbol)) {
                return possibleMove;
            }
        }

        if (availableMoves.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(0, availableMoves.size());
        return availableMoves.get(randomIndex);
    }

    private Player getOpponent() {
        Player opponent = null;
        if (game.getPlayerO().equals(this)) {
            opponent = game.getPlayerX();
        } else {
            opponent = game.getPlayerO();
        }
        return opponent;
    }
}
