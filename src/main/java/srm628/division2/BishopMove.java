package srm628.division2;

/**
 * Level 1 Problem.
 * 
 * @author emmanuel
 *
 */
public class BishopMove {

  public int howManyMoves(int r1, int c1, int r2, int c2) {
    if (r1 == r2 && c1 == c2)
      return 0;
    else if (Math.abs(r1 - r2) == Math.abs(c1 - c2))
      return 1;
    else if ((r1 + c1) % 2 == (r2 + c2) % 2)
      return 2;
    else
      return -1;
  }

}
