package srm211.division1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class grafixMask {

  public int[] sortedAreas(String[] rectangles) {
    boolean[][] visited = new boolean[400][600];
    List<Integer> holes = new ArrayList<>();
    for (String rect : rectangles) {
      String[] rectCoord = rect.split(" ");
      int r1 = Integer.parseInt(rectCoord[0]), c1 = Integer.parseInt(rectCoord[1]);
      int r2 = Integer.parseInt(rectCoord[2]), c2 = Integer.parseInt(rectCoord[3]);
      for (int r = r1; r <= r2; r++)
        for (int c = c1; c <= c2; c++)
          visited[r][c] = true;
    }
    int curHoleArea;
    LinkedList<Integer> qr = new LinkedList<>(), qc = new LinkedList<>();
    int[] rMoves = {-1, 0, 0, 1};
    int[] cMoves = {0, -1, 1, 0};
    int nextR, nextC, curR, curC;
    for (int r = 0; r < 400; r++) {
      for (int c = 0; c < 600; c++) {
        if (!visited[r][c]) {
          qr.add(r);
          qc.add(c);
          curHoleArea = 1;
          visited[r][c] = true;
          while (!qr.isEmpty()) {
            curR = qr.remove();
            curC = qc.remove();
            for (int i = 0; i < cMoves.length; i++) {
              nextR = curR + rMoves[i];
              nextC = curC + cMoves[i];
              if (nextR >= 0 && nextC >= 0 && nextR < 400 && nextC < 600 && !visited[nextR][nextC]) {
                curHoleArea++;
                qr.add(nextR);
                qc.add(nextC);
                visited[nextR][nextC] = true;
              }
            }
          }
          holes.add(curHoleArea);
        }
      }
    }
    Collections.sort(holes);
    int[] holesArr = new int[holes.size()];
    for (int i = 0; i < holesArr.length; i++)
      holesArr[i] = holes.get(i);
    return holesArr;
  }
}
