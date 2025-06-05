import java.util.List;
import java.util.Random;

public class MachinePlayer extends Player{
    private final Random random = new Random();

    public MachinePlayer(String symbol) {
        super(symbol);
    }

    @Override
    public Integer makeMove(Board board) {
        List<Integer> moves =board.getAvailableMoves();
        int randomIndex = random.nextInt(0, moves.size());
        return moves.get(randomIndex);
    }
}
