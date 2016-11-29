import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Hexspeak {
	
	public String decode(long ciphertext) {
		String s = String.format("%x", ciphertext);
		s = s.toUpperCase().replace('1', 'I').replace('0', 'O');
		for (char c : s.toCharArray()) {
			if (c >= '2' && c <= '9') return "Error!";
		}
		return s;
	}
}
