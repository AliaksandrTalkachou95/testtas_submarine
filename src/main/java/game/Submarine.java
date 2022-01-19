package game;

import java.util.Objects;
import java.util.Set;

public class Submarine {
    private String name;
    private final Set<Cell> cells;

    public Submarine(Set<Cell> cells) {
        this.cells = cells;
    }

    public Submarine(String name, Set<Cell> cells) {
        this.cells = cells;
        this.name = name;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    public void removeSubCell(Cell cell) {
        cells.remove(cell);
    }

    public boolean markSubAsDown() {
        if (cells.isEmpty()) {
            System.out.println(name + " is down!");
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submarine submarine = (Submarine) o;
        return name.equals(submarine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
