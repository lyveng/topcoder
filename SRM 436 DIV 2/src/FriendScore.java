import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FriendScore {
	
	public int highestScore(String[] friends) {
		int maxFriendScore = 0;
		for (int u=0;u < friends.length;u++) {
			int score = 0;
			for (int v=0;v<friends.length;v++) {
				if (u == v)
					continue;
				if (friends[u].charAt(v) == 'Y') {
					score++;
				} else {
					for (int w=0;w<friends.length;w++) {
						if (u == w || v == w)
							continue;
						if (friends[u].charAt(w) == 'Y' && friends[v].charAt(w) == 'Y') {
							score++;
							break;
						}
					}
				}
			}
			maxFriendScore = score > maxFriendScore ? score : maxFriendScore;
		}
		return maxFriendScore;
	}
}
