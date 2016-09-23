import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class VerySecureEncryption {
	String encrypt(String message, int[] key) {
		char[] c = new char[message.length()];
		for (int i=0;i<message.length();i++) {
			c[key[i]] = message.charAt(i);
		}
		return new String(c);
	}
	
	public String encrypt(String message, int[] key, int K) {
		String m = message;
		for (int i=0; i<K;i++) {
			m = encrypt(m, key);
		}
		return m;
	}
}
