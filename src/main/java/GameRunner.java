import game.Board;
import game.Cell;

import java.util.Random;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("Starting a game");
        Board board = new Board();
        System.out.println("Init submarines!");
        board.initSubmarines();

        boolean isAllDown = false;

        do {
            Random random = new Random();
            int x = random.nextInt(9);
            int y = random.nextInt(6);
            Cell cell = new Cell(x, y);
            System.out.println("Hitting x: " + x + " y: " + y);
            isAllDown = board.hit(cell);
        } while (!isAllDown);

        System.out.println("All subs down!!");
    }
}
