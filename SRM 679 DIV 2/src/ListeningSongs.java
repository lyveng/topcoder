import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class ListeningSongs {
	
	public int listen(int[] durations1, int[] durations2, int minutes, int T) {
		int timeToLeave = minutes*60;
		Arrays.sort(durations1);
		Arrays.sort(durations2);
		int cur = 0, songs = 2*T;
		if (T > durations1.length || T > durations2.length)
			return -1;
		for (int i=0;i<T;i++)
			cur += (durations1[i] + durations2[i]);
		if (cur > timeToLeave)
			return -1;
		int[] n = new int[durations1.length-T+durations2.length-T];
		for (int i=T;i<durations1.length;i++)
			n[i-T] = durations1[i];
		for (int i=T;i<durations2.length;i++)
			n[durations1.length-T+i-T] = durations2[i];
		Arrays.sort(n);
		for (int i=0;i<n.length;i++) {
			if (cur + n[i] > timeToLeave)
				break;
			cur += n[i];
			songs++;
		}
		return songs;
	}
}
