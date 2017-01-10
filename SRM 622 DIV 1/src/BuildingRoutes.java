import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BuildingRoutes {
	
	public int build(String[] dist, int T) {
		int n = dist.length;
		int[][] distTo = new int[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				distTo[i][j] = dist[i].charAt(j) - '0';
			}
		}

		for (int k=0;k<n;k++) {
			for (int i=0;i<n;i++) {
				for (int j=0;j<n;j++) {
					if (distTo[i][j] > distTo[i][k] + distTo[k][j]) {
						distTo[i][j] = distTo[i][k] + distTo[k][j];
					}
				}
			}
		}

		int[][] busCount = new int[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						if (i==j || x==y)
							continue;
						if (distTo[i][x] + (dist[x].charAt(y) - '0') + distTo[y][j] == distTo[i][j])
							busCount[x][y]++;
					}
				}
			}
		}

		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (busCount[i][j] >= T)
					ret += (dist[i].charAt(j) - '0');
			}
		}

		return ret;
	}
}
