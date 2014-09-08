package srm198.division1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Level 2 problem.
 * 
 * @author emmanuel
 * 
 */
public class DungeonEscape {

  public int exitTime(String[] up, String[] down, String[] east, String[] west, int startLevel, int startEasting) {
    State start = new State(startLevel, startEasting, 0);
    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.add(start);
    int ret = Integer.MAX_VALUE;
    int totalLevels = up.length;
    int roomsInLevel = up[0].length();
    boolean[][] visited = new boolean[totalLevels][roomsInLevel];
    int[][] time = new int[totalLevels][roomsInLevel];
    for (int i = 0; i < totalLevels; i++) {
      Arrays.fill(time[i], Integer.MAX_VALUE);
    }
    while (!pq.isEmpty()) {
      State curState = pq.remove();
      visited[curState.row][curState.col] = true;
      // move up
      if (up[curState.row].charAt(curState.col) != 'x') {
        int t = up[curState.row].charAt(curState.col) - '0';
        int nextStateTime = curState.time + t;
        if (curState.row == 0)
          ret = Math.min(ret, nextStateTime);
        else if (!visited[curState.row - 1][curState.col]) {
          int nextRow = curState.row - 1;
          int timeToFillNextState = (totalLevels - nextRow) * roomsInLevel;
          if (nextStateTime < timeToFillNextState && nextStateTime < time[nextRow][curState.col]) {
            pq.add(new State(nextRow, curState.col, nextStateTime));
            time[nextRow][curState.col] = nextStateTime;
          }
        }
      }
      // move down
      if (down[curState.row].charAt(curState.col) != 'x' && curState.row != (totalLevels - 1) && !visited[curState.row + 1][curState.col]) {
        int t = down[curState.row].charAt(curState.col) - '0';
        int nextRow = curState.row + 1;
        int timeToFillNextState = (totalLevels - nextRow) * roomsInLevel;
        int nextStateTime = curState.time + t;
        if (nextStateTime < timeToFillNextState && nextStateTime < time[nextRow][curState.col]) {
          pq.add(new State(nextRow, curState.col, nextStateTime));
          time[nextRow][curState.col] = nextStateTime;
        }
      }
      // move left
      if (west[curState.row].charAt(curState.col) != 'x' && curState.col != 0 && !visited[curState.row][curState.col - 1]) {
        int t = west[curState.row].charAt(curState.col) - '0';
        int nextCol = curState.col - 1;
        int timeToFillNextState = (totalLevels - curState.row) * roomsInLevel;
        int nextStateTime = curState.time + t;
        if (nextStateTime < timeToFillNextState && nextStateTime < time[curState.row][nextCol]) {
          pq.add(new State(curState.row, nextCol, nextStateTime));
          time[curState.row][nextCol] = nextStateTime;
        }
      }
      // move right
      if (east[curState.row].charAt(curState.col) != 'x' && curState.col != (roomsInLevel - 1) && !visited[curState.row][curState.col + 1]) {
        int t = east[curState.row].charAt(curState.col) - '0';
        int nextCol = curState.col + 1;
        int timeToFillNextState = (totalLevels - curState.row) * roomsInLevel;
        int nextStateTime = curState.time + t;
        if (nextStateTime < timeToFillNextState && nextStateTime < time[curState.row][nextCol]) {
          pq.add(new State(curState.row, nextCol, nextStateTime));
          time[curState.row][nextCol] = nextStateTime;
        }
      }
    }
    return ret == Integer.MAX_VALUE ? -1 : ret;
  }

  class State implements Comparable<State> {
    int row, col, time;

    public State(int row, int col, int time) {
      super();
      this.row = row;
      this.col = col;
      this.time = time;
    }

    @Override
    public int compareTo(State o) {
      return this.time - o.time;
    }
  }
}
