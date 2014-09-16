package tci02.semi2;
import java.util.LinkedList;

public class Escape {
  private static final int MAX_N = 501;

  public int lowest(String[] harmful, String[] deadly) {
    int[][] board = new int[MAX_N][MAX_N];
    boolean[][] visited = new boolean[MAX_N][MAX_N];
    for (String string : harmful) {
      String[] split = string.split(" ");
      int x1 = Integer.parseInt(split[0]), y1 = Integer.parseInt(split[1]), x2 = Integer.parseInt(split[2]), y2 = Integer.parseInt(split[3]);
      for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
        for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
          board[x][y] = 1;
        }
      }
    }
    for (String string : deadly) {
      String[] split = string.split(" ");
      int x1 = Integer.parseInt(split[0]), y1 = Integer.parseInt(split[1]), x2 = Integer.parseInt(split[2]), y2 = Integer.parseInt(split[3]);
      for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
        for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
          board[x][y] = 2;
        }
      }
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    Node start = new Node(0, 0);
    LinkedList<Node> working = new LinkedList<>(), frontier = new LinkedList<>();
    working.addFirst(start);
    visited[0][0] = true;
    int swaps = 0;
    while (!working.isEmpty() || !frontier.isEmpty()) {
      if (working.isEmpty()) {
        swaps++;
        working = frontier;
        frontier = new LinkedList<>();
      }
      Node cur = working.removeFirst();
      if (cur.x == 500 && cur.y == 500)
        return swaps;
      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i], ny = cur.y + dy[i];
        if (nx < 0 || nx >= MAX_N || ny < 0 || ny >= MAX_N)
          continue;
        if (board[nx][ny] == 2 || visited[nx][ny])
          continue;
        else if (board[nx][ny] == 0) {
          working.addLast(new Node(nx,ny));
          visited[nx][ny] = true;
        }
        else if (board[nx][ny] == 1) {
          frontier.addLast(new Node(nx, ny));
          visited[nx][ny] = true;
        }
      }
    }
    return -1;
  }

  class Node {
    int x, y;

    Node(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }
  }
}
