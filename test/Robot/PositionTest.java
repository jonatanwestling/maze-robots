package Robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void getX() {
        Position posX = new Position(1, 0);
        assert (posX.getX() == 1);
    }

    @Test
    void getY() {
        Position posY = new Position(0, 1);
        assert (posY.getY() == 1);
    }

    @Test
    void getPositionToNorth() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, -1);
        assertEquals(pos2, pos1.getPosToNorth());
    }

    @Test
    void getPositionToEast() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        assertEquals(pos2, pos1.getPosToEast());
    }

    @Test
    void getPositionToSouth() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 1);
        assertEquals(pos2, pos1.getPosToSouth());
    }

    @Test
    void getPositionToWest() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(-1, 0);
        assertEquals(pos2, pos1.getPosToWest());
    }
}
