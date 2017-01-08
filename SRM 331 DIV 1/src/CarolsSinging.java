import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CarolsSinging {

	public int choose(String[] lyrics) {
		int carols = lyrics[0].length();
		List<Integer>[] adj = new List[carols];
		for (int i = 0; i < carols; i++)
			adj[i] = new LinkedList<>();
		for (int i = 0; i < lyrics.length; i++) {
			for (int j = 0; j < lyrics[i].length(); j++) {
				if (lyrics[i].charAt(j) == 'Y')
					adj[j].add(i);
			}
		}

		for (int length = 1; length <= carols; length++) {
			Set<Integer> chosenCarols = new HashSet<>();
			for (int i = 1; i <= length; i++) {
				chosenCarols.clear();
				if (isSatisfied(adj, length, 0, chosenCarols, lyrics.length))
					return length;
			}
		}
		return 0;
	}

	private boolean isSatisfied(List<Integer>[] adj, int length, int nextCarol, Set<Integer> chosenCarols, int membersCount) {
		if (chosenCarols.size() == length) {
			Set<Integer> members = new HashSet<>();
			for (int carol : chosenCarols) {
				members.addAll(adj[carol]);
			}
			if (members.size() == membersCount)
				return true;
			return false;
		}

		// check if we've exhausted carols
		if (nextCarol == adj.length)
			return false;

		// exclude nextCarol
		if (isSatisfied(adj, length, nextCarol+1, chosenCarols, membersCount))
			return true;

		// choose nextCarol
		chosenCarols.add(nextCarol);
		if (isSatisfied(adj, length, nextCarol+1, chosenCarols, membersCount))
			return true;
		chosenCarols.remove(nextCarol);
		return  false;
	}
}