import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DevuAndGame {
	
	public String canWin(int[] nextLevel) {
		boolean[] visited = new boolean[nextLevel.length];
		int cur = 0;
		while (nextLevel[cur] != -1) {
			if (visited[cur]) {
				return "Lose";
			}
			visited[cur] = true;
			cur = nextLevel[cur];
		}
		return "Win";
	}
}
