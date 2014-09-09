package tccc04.onlineround4;
import java.util.PriorityQueue;

/**
 * Level 2 problem.
 * 
 * @author emmanuel
 *
 */
public class BombMan {

  private static final int MAX_BOMBS = 101;

  public int shortestPath(String[] maze, int bombs) {
    final int rows = maze.length;
    final int cols = maze[0].length();
    boolean[][][] visited = new boolean[rows][cols][MAX_BOMBS];
    State start = null;
    for (int i = 0; i < rows; i++) {
      if (maze[i].contains("B"))
      {
        start = new State(i, maze[i].indexOf('B'), 0, bombs);
        break;
      }
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.add(start);
    while (!pq.isEmpty()) {
      State curState = pq.remove();
      if (visited[curState.x][curState.y][curState.bombsLeft])
        continue;
      visited[curState.x][curState.y][curState.bombsLeft] = true;
      if (maze[curState.x].charAt(curState.y) == 'E')
        return curState.time;
      for (int i = 0; i < dx.length; i++) {
        int nextX = curState.x + dx[i], nextY = curState.y + dy[i];
        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols)
          continue;
        if (maze[nextX].charAt(nextY) == '.' || maze[nextX].charAt(nextY) == 'E') {
          State nextState = new State(nextX, nextY, curState.time + 1, curState.bombsLeft);
          pq.add(nextState);
        }
        else if (maze[nextX].charAt(nextY) == '#'){
          if (curState.bombsLeft == 0)
            continue;
          State nextState = new State(nextX, nextY, curState.time + 3, curState.bombsLeft - 1);
          pq.add(nextState);
        }
      }
    }
    return -1;
  }

  class State implements Comparable<State> {
    int x, y;
    int time;
    int bombsLeft;

    public State(int x, int y, int time, int bombsLeft) {
      super();
      this.x = x;
      this.y = y;
      this.time = time;
      this.bombsLeft = bombsLeft;
    }

    @Override
    public int compareTo(State o) {
      return this.time - o.time;
    }
  }
}
