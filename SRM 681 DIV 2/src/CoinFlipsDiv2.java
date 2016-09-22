import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CoinFlipsDiv2 {
	
	public int countCoins(String state) {
		int count = 0;
		boolean interesting;
		for (int i=0;i<state.length();i++) {
			if ((i - 1 >= 0 && state.charAt(i-1) != state.charAt(i)) || (i + 1 < state.length() && state.charAt(i+1) != state.charAt(i)))
				count++;
		}
		return count;
	}
}
