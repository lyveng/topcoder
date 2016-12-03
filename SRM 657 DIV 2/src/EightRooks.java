import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class EightRooks {
	
	public String isCorrect(String[] board) {
		for (int i=0;i<8;i++) {
			int rcount = 0, lcount = 0;
			for (int j=0;j<8;j++) {
				if (board[i].charAt(j) == 'R')
					rcount++;
				if (board[j].charAt(i) == 'R')
					lcount++;
			}
			if (rcount != 1 || lcount != 1)
				return "Incorrect";
		}
		return "Correct";
	}
}
