import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ColorfulRoad {
	public int getMin(String road) {
		Map<Character, Character> colorMap = new HashMap<>();
		colorMap.put('R', 'G');
		colorMap.put('G', 'B');
		colorMap.put('B', 'R');

		int[] distTo = new int[road.length()];
		distTo[0] = 0;
		for (int i=1;i<distTo.length;i++)
			distTo[i] = Integer.MAX_VALUE;
		Stack<Entry> s = new Stack<>();
		s.push(new Entry(0, 'R'));
		while (!s.empty()) {
			Entry cur = s.pop();
			char nextColor = colorMap.get(cur.color);
			for (int next = cur.cur+1;next < road.length();next++) {
				if (road.charAt(next) != nextColor)
					continue;
				int length = next - cur.cur;
				distTo[next] = Math.min(distTo[next], distTo[cur.cur] + length*length);
				s.push(new Entry(next, nextColor));
			}
		}
		if (distTo[road.length() - 1] == Integer.MAX_VALUE)
			return -1;
		return distTo[road.length() - 1];
	}

	public class Entry {
		int cur;
		char color;

		public Entry(int cur, char color) {
			this.cur = cur;
			this.color = color;
		}
	}

}
