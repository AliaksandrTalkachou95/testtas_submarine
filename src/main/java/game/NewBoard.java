package game;

import java.util.*;

public class NewBoard {
    private Set<Submarine> aliveSubmarines = new HashSet<>();

    private final Cell[][] cells = new Cell[8][5];

    public boolean hitCell(int x, int y) {
        Cell cell = cells[x][y];
        if (checkAlreadyHit(cell)) return false;

        cell.setHit(true);
        Submarine submarine = cell.getSubmarine();
        if (submarine == null) {
            System.out.println("You've missed!");
            return false;
        }

        submarine.removeSubCell(cell);
        if (submarine.markSubAsDown()) {
            aliveSubmarines.remove(submarine);
        }

        return aliveSubmarines.isEmpty();
    }

    private boolean checkAlreadyHit(Cell cell) {
        if (cell.isHit()) {
            System.out.println("You've already hit that cell!");
            return true;
        }
        return false;
    }

    public void initBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 5; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }

        initSubmarines();
    }

    public Submarine addSubmarine(String name, Set<Cell> subCells) {
        Submarine submarine = new Submarine(name, subCells);
        for (Cell cell : subCells) {
            Cell boardCell = cells[cell.getX()][cell.getY()];
            if (boardCell.getSubmarine() != null) {
                throw new BusyCellException("Cell is already busy!");
            }
            boardCell.setSubmarine(submarine);
        }
        return submarine;
    }

    public void initSubmarines() {
        Submarine submarine1 = addSubmarine("Submarine 1", new HashSet<>(Arrays.asList(new Cell(0, 0), new Cell(0, 1))));
        Submarine submarine2 = addSubmarine("Submarine 2", new HashSet<>(Arrays.asList(new Cell(5, 0), new Cell(5, 1), new Cell(5, 2))));
        Submarine submarine3 = addSubmarine("Submarine 3", new HashSet<>(Arrays.asList(new Cell(1, 4), new Cell(2, 4), new Cell(3, 4))));
        Submarine submarine4 = addSubmarine("Submarine 4", new HashSet<>(List.of(new Cell(5, 3))));

        aliveSubmarines = new HashSet<>(Arrays.asList(submarine1, submarine2, submarine3, submarine4));
    }
}
