package game;

import java.util.Optional;
import java.util.Set;

public class Submarine {
    private Set<Cell> cells;
    private int length;
    private boolean down = false;

    public Submarine(Set<Cell> cells) {
        this.cells = cells;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void markSubAsDown() {
        Optional<Cell> notHit = this.getCells().stream().filter(cell -> !cell.isHit()).findAny();
        if (notHit.isEmpty()) {
            this.setDown(true);
        }
    }

}
