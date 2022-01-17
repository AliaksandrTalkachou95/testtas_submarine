package game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Board {
    private Submarine[] submarines = new Submarine[4];

    public boolean hit(Cell cell) {
        for (Submarine submarine : submarines) {
            if (submarine.getCells().contains(cell)) {
                if (hitSubmarine(cell, submarine)) break;
            }
        }
        return checkIfAllSubsDown();
    }

    private boolean checkIfAllSubsDown() {
        for (Submarine submarine : submarines) {
            if (!submarine.isDown())
                return false;
        }
        return true;
    }

    private boolean hitSubmarine(Cell cell, Submarine submarine) {
        for (Cell cell1 : submarine.getCells()) {
            if (cell1.equals(cell)) {
                cell1.setHit(true);
                System.out.println("Target accuired!");
                if (!submarine.isDown()) {
                    System.out.println("Submarine is down!");
                    submarine.markSubAsDown();
                }
                return true;
            }
        }
        return false;
    }


    public void initSubmarines() {
        //First sub
        Cell cell = new Cell(0, 0);
        Cell cell1 = new Cell(0, 1);
        Set<Cell> cells1 = new HashSet<>(Arrays.asList(cell, cell1));
        Submarine submarine1 = new Submarine(cells1);

        //Second sub
        Cell cell2 = new Cell(5, 0);
        Cell cell3 = new Cell(5, 1);
        Cell cell4 = new Cell(5, 2);
        Submarine submarine2 = new Submarine(new HashSet<>(Arrays.asList(cell2, cell3, cell4)));

        //Third sub
        Cell cell5 = new Cell(1, 4);
        Cell cell7 = new Cell(2, 4);
        Cell cell8 = new Cell(3, 4);
        Cell cell9 = new Cell(4, 4);
        Submarine submarine3 = new Submarine(new HashSet<>(Arrays.asList(cell5, cell7, cell8, cell9)));

        //Fourth sub
        Cell cell10 = new Cell(5, 5);
        Submarine submarine4 = new Submarine(new HashSet<>(Arrays.asList(cell10)));

        submarines[0] = submarine1;
        submarines[1] = submarine2;
        submarines[2] = submarine3;
        submarines[3] = submarine4;
    }
}
