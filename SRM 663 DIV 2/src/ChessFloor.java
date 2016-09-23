import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ChessFloor {
	
	public int minimumChanges(String[] floor) {
		int min = Integer.MAX_VALUE, cost;
		for (int c1=0;c1<26;c1++) {
			for (int c2=0;c2<26;c2++) {
				if (c1 == c2) {
					continue;
				}
				cost = 0;
				for (int i=0;i<floor.length;i++) {
					for (int j=0;j<floor.length;j++) {
						if ((i+j) % 2 == 0) {
							if (floor[i].charAt(j) - 'a' != c1)
								cost++;
						} else {
							if (floor[i].charAt(j) - 'a' != c2)
								cost++;
						}
					}
				}
				min = Math.min(cost, min);
			}
		}
		return min;
	}
}
