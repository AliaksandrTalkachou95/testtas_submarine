import game.NewBoard;

import java.util.Random;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Starting a game");
        NewBoard board = new NewBoard();
        System.out.println("Init submarines!");
        board.initBoard();

        boolean isAllDown;

        do {
            Random random = new Random();
            int x = random.nextInt(8);
            int y = random.nextInt(5);
            System.out.println("Hitting x: " + x + " y: " + y);
            isAllDown = board.hitCell(x, y);
        } while (!isAllDown);

        System.out.println("All subs down!!");
    }
}
