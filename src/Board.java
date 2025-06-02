public class Board {

    private String[][] board = new String[3][3];
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


}
