import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FallingSand {
	
	public String[] simulate(String[] board) {
		char[][] s = new char[board.length][];
		for (int i=0;i<board.length;i++) {
			s[i] = board[i].toCharArray();
		}
		for (int i=s.length-1;i>=0;i--) {
			for (int j=0;j<s[i].length;j++) {
				if (s[i][j] == '.' || s[i][j] == 'x')
					continue;
				for (int k=i+1;k<s.length;k++) {
					if (s[k][j] != '.')
						break;
					s[k-1][j] = '.';
					s[k][j] = 'o';
				}
			}
		}
		String[] ret = new String[board.length];
		for (int i=0;i<s.length;i++)
			ret[i] = new String(s[i]);
		return ret;
	}
}
