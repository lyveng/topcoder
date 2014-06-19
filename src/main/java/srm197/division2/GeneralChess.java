package srm197.division2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Level 2 problem
 * 
 * @author emmanuel
 *
 */
public class GeneralChess {
  public String[] attackPositions(String[] pieces)
  {
    List<Position> attackMoves = generateAttackMoves();
    String[] split;
    Set<Position> ret = new TreeSet<>();
    split = pieces[0].split(",");
    ret.addAll(generateAttackPositions(new Position(Integer.parseInt(split[0]), Integer.parseInt(split[1])), attackMoves));
    for (String piece : pieces) {
      split = piece.split(",");
      ret.retainAll(generateAttackPositions(new Position(Integer.parseInt(split[0]), Integer.parseInt(split[1])), attackMoves));
      if (ret.isEmpty())
        break;
    }
    return generateReturnValue(ret);
  }

  private static String[] generateReturnValue(Set<Position> positions) {
    String[] arr = new String[positions.size()];
    int i=0;
    for (Position pos : positions) {
      arr[i] = pos.toString();
      i++;
    }
    return arr;
  }

  private static List<Position> generateAttackMoves() {
    String[] possibleMoves = new String[] { "-2,-1",  "-2,1",  "-1,-2",  "-1,2",  "1,-2",  "1,2",  "2,-1",  "2,1" };
    List<Position> attackMoves = new ArrayList<Position>();
    String[] split;
    for (String move : possibleMoves) {
      split = move.split(",");
      attackMoves.add(new Position(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
    }
    return attackMoves;
  }

  private static Set<Position> generateAttackPositions(Position p, List<Position> moves) {
    Set<Position> attackPositions = new HashSet<Position>();
    for (Position move : moves)
      attackPositions.add(move.add(p));
    return attackPositions;
  }

  public static class Position implements Comparable<Position>{
    int x, y;

    Position(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }

    public Position add(Position p) {
      return new Position(this.x + p.x, this.y + p.y);
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + x;
      result = prime * result + y;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Position other = (Position) obj;
      if (x != other.x)
        return false;
      if (y != other.y)
        return false;
      return true;
    }

    @Override
    public int compareTo(Position o) {
      if (this.x == o.x && this.y == o.y)
        return 0;
      else if (x == o.x)
        return y - o.y;
      else
        return x - o.x;
    }

    @Override
    public String toString() {
      return x + "," + y;
    }
  }

  public static void main(String[] args) {
    GeneralChess obj = new GeneralChess();
    System.out.println(Arrays.toString(obj.attackPositions(new String[] {"0,0"})));
    System.out.println(Arrays.toString(obj.attackPositions(new String[] {"2,1", "-1,-2"})));
    System.out.println(Arrays.toString(obj.attackPositions(new String[] {"0,0", "2,1"})));
    System.out.println(Arrays.toString(obj.attackPositions(new String[] {"-1000,1000", "-999,999", "-999,997"})));
  }
}
