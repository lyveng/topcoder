import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class WhichDay {
	
	public String getDay(String[] notOnThisDay) {
		String[] weekdays = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		Set<String> s = new TreeSet<>();
		for (String si:weekdays)
			s.add(si);
		for (String si:notOnThisDay)
			s.remove(si);
		return s.toArray(new String[]{})[0];
	}
}
