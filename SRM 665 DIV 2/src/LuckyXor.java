import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LuckyXor {
	boolean isLucky(int i) {
		while (i > 0) {
			if (i % 10 != 4 && i %10 != 7)
				return false;
			i = i / 10;
		}
		return true;
	}
	
	public int construct(int a) {
		for (int i=a+1;i<=100; i++)
			if (isLucky(a^i))
				return i;
		return -1;
	}
}
