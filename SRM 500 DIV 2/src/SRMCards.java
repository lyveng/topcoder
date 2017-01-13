import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SRMCards {
	
	public int maxTurns(int[] cards) {
		Arrays.sort(cards);
		int maxMoves =0;
		int i=0,cc=1;
		while (i+1 < cards.length) {
			if (cards[i+1] != cards[i] + 1) {
				maxMoves += (cc % 2 == 0 ? cc / 2 : cc / 2 + 1);
				cc = 1;
			} else  {
				cc++;
			}
			i++;
		}
		maxMoves += (cc % 2 == 0 ? cc / 2 : cc / 2 + 1);
		return maxMoves;
	}

}
