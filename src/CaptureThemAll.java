import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/8/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CaptureThemAll {
    private static int NOT_FOUND=-1;
    public int fastKnight(String knight, String queen, String rook)
    {
        Position start = new Position(knight);
        final Position queenPos = new Position(queen);
        final Position rookPos = new Position(rook);
        start.checkQueenOrRook(queenPos, rookPos);
        if (start.isFinalPosition())
            return 0;
        Queue<Position> q = new LinkedList<Position>();
        q.add(start);
        while (!q.isEmpty())
        {
            Position cur_position = q.remove();
            for (Position next_position : cur_position.getValidMoves(queenPos,rookPos))
            {
                if (next_position.isFinalPosition())
                    return next_position.moves;
                q.add(next_position);
            }
        }
        return NOT_FOUND;
    }
}

class Position {
    private static final int ASCII_VALUE_OF_A = (int) 'a';
    private static final int ASCII_VALUE_OF_1 = (int) '1';
    private static final Position[] VALID_MOVES = new Position[]{
            new Position(-2, -1), new Position(-2, 1), new Position(-1, -2), new Position(-1, 2), new Position(1, -2), new Position(1, 2), new Position(2, -1), new Position(2, 1)
    };

    int x,y;
    boolean visitedQueen=false;
    boolean visitedRook=false;
    int moves = 0;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
        assert x >= 0 && x <= 7;
        assert y >= 0 && y <= 7;
    }

    Position(String pos) {
        x = ((int) pos.charAt(0)) - ASCII_VALUE_OF_A;
        y = ((int) pos.charAt(1)) - ASCII_VALUE_OF_1;
        assert x >= 0 && x <= 7;
        assert y >= 0 && y <= 7;
    }

    Position(Position value) {
        x = value.x;
        y = value.y;
        visitedRook = value.visitedRook;
        visitedQueen = value.visitedQueen;
        moves = value.moves + 1;
    }

    public void checkQueenOrRook(Position queen, Position rook)
    {
        if (queen.equals(this))
            visitedQueen = true;
        if (rook.equals(this))
            visitedRook = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    boolean isValid() {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", visitedQueen=" + visitedQueen +
                ", visitedRook=" + visitedRook +
                ", moves=" + moves +
                '}';
    }

    Position addPosition(Position delta)
    {
        Position returnValue = new Position(this);
        returnValue.x += delta.x;
        returnValue.y += delta.y;
        return returnValue;
    }

    public LinkedList<Position> getValidMoves(Position queen, Position rook)
    {
        LinkedList<Position> returnValue = new LinkedList<Position>();
        for (Position delta : VALID_MOVES)
        {
            Position nextPos = addPosition(delta);
            if (nextPos.isValid())
            {
                nextPos.checkQueenOrRook(queen, rook);
                returnValue.add(nextPos);
            }
        }
        return returnValue;
    }

    public boolean isFinalPosition() {
        return visitedQueen && visitedRook;
    }
}
