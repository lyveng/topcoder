package srm156.division1;
import java.util.LinkedList;

/**
 * Level 3 problem. 900pts.
 * @author emmanuel
 *
 */
public class PathFinding {

  public int minTurns(String[] board) {
    // Find position of A and B
    int ax=0, ay=0, bx=0, by=0;
    int rows = board.length, cols = board[0].length();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length(); j++) {
        if (board[i].charAt(j) == 'A') {
          ax = i;
          ay = j;
        }
        else if (board[i].charAt(j) == 'B') {
          bx = i;
          by = j;
        }
      }
    }

    Node start = new Node(ax, ay, bx, by, 0);
    LinkedList<Node> q = new LinkedList<>();
    boolean[][][][] visited = new boolean[20][20][20][20];
    visited[ax][ay][bx][by] = true;
    q.addLast(start);
    while (!q.isEmpty()) {
      Node cur = q.removeFirst();
      for (int dx1 = -1; dx1 <= 1; dx1++) {
        for (int dy1 = -1; dy1 <= 1; dy1++) {
          // check if point is within board and not wall
          int nx1 = cur.x1 + dx1, ny1 = cur.y1 + dy1;
          if (nx1 < 0 || nx1 >= rows || ny1 < 0 || ny1 >= cols || board[nx1].charAt(ny1) == 'X')
            continue;
          for (int dx2 = -1; dx2 <= 1; dx2++) {
            for (int dy2 = -1; dy2 <= 1; dy2++) {
              // check if point is within board and not wall
              int nx2 = cur.x2 + dx2, ny2 = cur.y2 + dy2;
              if (nx2 < 0 || nx2 >= rows || ny2 < 0 || ny2 >= cols || board[nx2].charAt(ny2) == 'X')
                continue;
              // check if not visited and not crossing
              if (visited[nx1][ny1][nx2][ny2] || (cur.x1 == nx2 && cur.y1 == ny2 && cur.x2 == nx1 && cur.y2 == ny1))
                continue;
              // check if a pos and b pos are same
              if (nx1 == nx2 && ny1 == ny2)
                continue;
              if (board[nx1].charAt(ny1) == 'B' && board[nx2].charAt(ny2) == 'A')
                return cur.steps+1;
              visited[nx1][ny1][nx2][ny2] = true;
              q.addLast(new Node(nx1, ny1, nx2, ny2, cur.steps+1));
            }
          }
        }
      }
    }
    return -1;
  }

  class Node {
    int x1, y1, x2, y2;
    int steps;
    Node(int x1, int y1, int x2, int y2, int steps) {
      super();
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.steps = steps;
    }
  }
}
