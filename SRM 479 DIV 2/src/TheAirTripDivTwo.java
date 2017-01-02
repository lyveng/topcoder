import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class TheAirTripDivTwo {
	
	public int find(int[] flights, int fuel) {
		if (flights[0] > fuel)
			return 0;
		int sum=0;
		for (int i=0;i<flights.length;i++) {
			sum += flights[i];
			if (sum > fuel)
				return i;
		}
		return flights.length;
	}
}
