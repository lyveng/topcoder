import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class QuizShow {
	
	public int wager(int[] scores, int wager1, int wager2) {
		int[][] outcomes = new int[][] {
				{ 1, 1, 1},
				{ 1, 1,-1},
				{ 1,-1, 1},
				{ 1,-1,-1},
				{-1, 1, 1},
				{-1, 1,-1},
				{-1,-1, 1},
				{-1,-1,-1}
		};
		int minWager=-1;
		double maxProb=Double.NEGATIVE_INFINITY;
		for (int i=0;i<=scores[0];i++) {
			int winningCases = 0;
			for (int[] outcome : outcomes) {
				int A = scores[0] + outcome[0]*i;
				int B = scores[1] + outcome[1]*wager1;
				int C = scores[2] + outcome[2]*wager2;
				if (A > B && A > C) {
					winningCases++;
				}
			}
			double prob = winningCases / 8.0;
			if (prob > maxProb || maxProb == Double.NEGATIVE_INFINITY) {
				maxProb = prob;
				minWager = i;
			}
		}
		if (minWager == -1)
			return 0;
		return minWager;
	}
}
