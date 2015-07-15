import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void emptyWhenCreated() {
        assertTrue(board.empty());
    }

    @Test
    public void oneMoveNotEmpty() {
        board = board.add(0, Board.Mark.X);
        assertFalse(board.empty());
    }

    @Test
    public void emptyToString() {
        assertEquals("---\n---\n---", board.toString());
    }

    @Test
    public void oneMoveToString() {
        board = board.add(0, Board.Mark.X);
        assertEquals("X--\n---\n---", board.toString());
    }

    @Test
    public void twoMoveToString() {
        board = board.add(0, Board.Mark.X).add(1, Board.Mark.O);
        assertEquals("XO-\n---\n---", board.toString());
    }

    @Test
    public void immutableBoard() {
        board = board.add(0, Board.Mark.X);
        assertFalse(board.empty());
    }

    @Test
    public void getTwoMovesByX() {
        board = board.add(0, Board.Mark.X).add(1, Board.Mark.X);
        Set<Integer> movesByX = board.get(Board.Mark.X);
        assertEquals(new HashSet<>(Arrays.asList(0, 1)), movesByX);
    }

    @Test
    public void isNotFull() {
        assertFalse(board.full());
    }

    @Test
    public void isFull() {
        board = board
                .add(0, Board.Mark.X).add(1, Board.Mark.X).add(2, Board.Mark.O)
                .add(3, Board.Mark.O).add(4, Board.Mark.O).add(5, Board.Mark.X)
                .add(6, Board.Mark.X).add(7, Board.Mark.O).add(8, Board.Mark.X);
        assertTrue(board.full());
    }

    @Test
    public void winner() {
        board = board
                .add(0, Board.Mark.X).add(1, Board.Mark.O).add(2, Board.Mark.X)
                .add(3, Board.Mark.O).add(4, Board.Mark.X).add(5, Board.Mark.O)
                .add(6, Board.Mark.X).add(7, Board.Mark.O).add(8, Board.Mark.X);
        assertEquals(Board.Mark.X, board.getWinner());
    }
    @Test
    public void noAvailabilities() {
        int count = 0;
        for (int i : board.availabilities())
            count++;
        assertEquals(9, count);
    }

    @Test
    public void numberOfAvailabilites() {
        assertEquals(9, board.numberOfAvailabilities());
        assertEquals(8, board.add(0, Board.Mark.O).numberOfAvailabilities());
    }

}