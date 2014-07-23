package srm623.division2;

import java.util.Arrays;

/**
 * Level 1 problem.
 * 
 * @author emmanuel
 *
 */
class Point implements Comparable<Point> {
  int x, y;

  public Point(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o) {
    return y - o.y;
  }
}

public class CatchTheBeatEasy {

  public String ableToCatchAll(int[] x, int[] y) {
    Point[] points = new Point[x.length];
    for (int i = 0; i < points.length; i++) {
      points[i] = new Point(x[i], y[i]);
    }
    Arrays.sort(points);
    int prevX = 0, prevY = 0;
    for (int i = 0; i < points.length; i++) {
      if (Math.abs(points[i].x - prevX) <= Math.abs(points[i].y - prevY)) {
        prevX = points[i].x;
        prevY = points[i].y;
      } else
        return "Not able to catch";
    }
    return "Able to catch";
  }

}
