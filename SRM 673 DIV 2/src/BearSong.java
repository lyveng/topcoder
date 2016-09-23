import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class BearSong {
	
	public int countRareNotes(int[] notes) {
		int ret = 0;
		short[] count = new short[1001];
		for (int i=0;i<notes.length;i++)
			count[notes[i]]++;
		for (int i=0;i<notes.length;i++)
			if (count[notes[i]] == 1)
				ret++;
		return ret;
	}
}
