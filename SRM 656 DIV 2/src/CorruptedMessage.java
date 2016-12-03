import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CorruptedMessage {
	
	public String reconstructMessage(String s, int k) {
		char d = '-', e = '-';
		for (char c='a';c <= 'z';c++) {
			int count = 0;
			for (char ch : s.toCharArray())
				if (ch == c)
					count++;
			if (count == s.length() - k && k != s.length()) {
				d = c;
				break;
			} else if (count == 0 && e == '-')
				e = c;
		}
		if (d == '-')
			d = e;
		char[] ret = new char[s.length()];
		Arrays.fill(ret, d);
		return new String(ret);
	}
}
