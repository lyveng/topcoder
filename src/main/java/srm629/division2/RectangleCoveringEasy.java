package srm629.division2;
public class RectangleCoveringEasy {

  public int solve(int holeH, int holeW, int boardH, int boardW) {
    int h1, w1, h2, w2;
    h1 = Math.min(holeH, holeW);
    w1 = Math.max(holeH, holeW);
    h2 = Math.min(boardH, boardW);
    w2 = Math.max(boardH, boardW);
    if ((h2 > h1 && w2 >= w1) || (h2 >= h1 && w2 > w1))
      return 1;
    return -1;
  }

}
