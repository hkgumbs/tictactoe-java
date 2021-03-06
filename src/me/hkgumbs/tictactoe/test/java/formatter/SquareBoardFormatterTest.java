package me.hkgumbs.tictactoe.test.java.formatter;

import me.hkgumbs.tictactoe.main.java.board.Board;
import me.hkgumbs.tictactoe.main.java.board.SquareBoard;
import me.hkgumbs.tictactoe.main.java.formatter.BoardFormatter;
import me.hkgumbs.tictactoe.main.java.formatter.SlotRepresentation;
import me.hkgumbs.tictactoe.main.java.formatter.SquareBoardFormatter;
import me.hkgumbs.tictactoe.main.java.formatter.DefaultSlotRepresentation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareBoardFormatterTest {

    private BoardFormatter getFormatter(
            int dimension, int padding) {
        SlotRepresentation slot = new DefaultSlotRepresentation();
        BoardFormatter formatter = new SquareBoardFormatter(dimension, slot);
        formatter.setPadding(padding);
        return formatter;
    }

    @Test
    public void emptyThreeByThreeBoard() {
        BoardFormatter formatter = getFormatter(3, 0);
        assertEquals("(0)|(1)|(2)\n" +
                        "-----------\n" +
                        "(3)|(4)|(5)\n" +
                        "-----------\n" +
                        "(6)|(7)|(8)",
                formatter.format(new SquareBoard(3)));
    }

    @Test
    public void threeByThreeBoardWithTwoPieces() {
        BoardFormatter formatter = getFormatter(3, 0);
        Board board = new SquareBoard(3)
                .add(0, Board.Mark.X).add(1, Board.Mark.O);
        assertEquals(" X | O |(2)\n" +
                        "-----------\n" +
                        "(3)|(4)|(5)\n" +
                        "-----------\n" +
                        "(6)|(7)|(8)",
                formatter.format(board));
    }

    @Test
    public void threeByThreeWithTwoPadding() {
        BoardFormatter formatter = getFormatter(3, 2);
        formatter.setPadding(2);
        Board board = new SquareBoard(3)
                .add(0, Board.Mark.X).add(1, Board.Mark.O);
        assertEquals("       |       |       \n" +
                        "       |       |       \n" +
                        "   X   |   O   |  (2)  \n" +
                        "       |       |       \n" +
                        "       |       |       \n" +
                        "-----------------------\n" +
                        "       |       |       \n" +
                        "       |       |       \n" +
                        "  (3)  |  (4)  |  (5)  \n" +
                        "       |       |       \n" +
                        "       |       |       \n" +
                        "-----------------------\n" +
                        "       |       |       \n" +
                        "       |       |       \n" +
                        "  (6)  |  (7)  |  (8)  \n" +
                        "       |       |       \n" +
                        "       |       |       ",
                formatter.format(board));
    }

    @Test
    public void fourByFourWithOnePadding() {
        BoardFormatter formatter = getFormatter(4, 1);
        formatter.setPadding(1);
        Board board = new SquareBoard(4)
                .add(0, Board.Mark.X).add(1, Board.Mark.O);
        assertEquals(   "      |      |      |      \n" +
                        "   X  |   O  |  (2) |  (3) \n" +
                        "      |      |      |      \n" +
                        "---------------------------\n" +
                        "      |      |      |      \n" +
                        "  (4) |  (5) |  (6) |  (7) \n" +
                        "      |      |      |      \n" +
                        "---------------------------\n" +
                        "      |      |      |      \n" +
                        "  (8) |  (9) | (10) | (11) \n" +
                        "      |      |      |      \n" +
                        "---------------------------\n" +
                        "      |      |      |      \n" +
                        " (12) | (13) | (14) | (15) \n" +
                        "      |      |      |      ",
                formatter.format(board));
    }

    @Test
    public void getPadding() {
        BoardFormatter formatter = getFormatter(1, 1);
        assertEquals(1, formatter.getPadding());
        formatter.setPadding(6);
        assertEquals(6, formatter.getPadding());
    }
}
