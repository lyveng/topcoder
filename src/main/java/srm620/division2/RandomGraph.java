package srm620.division2;

/**
 * Level 3 problem.
 * 
 * @author emmanuel
 *
 */
public class RandomGraph {
  double[][][] dp = new double[51][26][18];
  boolean[][][] solved = new boolean[51][26][18];
  double p;

  public double probability(int n, int p) {
    this.p = p / 1000.;
    return 1 - f(n, 0, 0, 0);
  }

  private double f(int r, int a, int b, int c) {
    if (solved[a][b][c])
      return dp[a][b][c];
    solved[a][b][c] = true;
    if (r == 0)
      return (dp[a][b][c] = 1.0);

    // 1 vertex of the remaining r vertices is added to the graph.

    // case 1 : the new vertex not connected with any of the existing a+2b+3c vertices.
    int vertexCount = a+2*b+3*c;
    dp[a][b][c] += (f(r-1, a+1, b, c) * Math.pow(1 - p, vertexCount));

    // case 2 : the new vertex is connected to one of the existing a vertices.
    if (a > 0)
      dp[a][b][c] += (f(r-1, a-1, b+1, c) * Math.pow(1 - p, vertexCount-1) * p * a);

    if (b > 0) {
      // case 3 : the new vertex is connected to one of the existing 2b vertices.
      dp[a][b][c] += (f(r-1, a, b-1, c+1) * Math.pow(1-p, vertexCount-1) * p * 2 * b);

      // case 4 : the new vertex is connected to both the vertices in the existing b connected components of size 2.
      dp[a][b][c] += (f(r-1, a, b-1, c+1) * Math.pow(1-p, vertexCount-2) * b * p*p);
    }

    // case 5 : the new vertex is connected to any two of the existing a vertices.
    if (a > 1)
      dp[a][b][c] += (f(r-1, a-2, b, c+1) * Math.pow(1-p, vertexCount-2) * p * p * a * (a-1) / 2);

    return dp[a][b][c];
  }
}
