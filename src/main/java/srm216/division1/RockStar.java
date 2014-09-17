package srm216.division1;
/**
 * Level 1 problem.
 * 
 * @author emmanuel
 * 
 */
public class RockStar {

  public int getNumSongs(int ff, int fs, int sf, int ss) {
    int count = 0;
    if (ff > 0) {
      count += ff;
      if (fs > 0) {
        fs--;
        count++;
        if (sf > 0 && ss > 0) {
          count += ss;
          while (sf > 0 && fs > 0) {
            count += 2;
            sf--;
            fs--;
          }
          if (sf > 0)
            count++;
          return count;
        } else if (sf > 0) {
          while (sf > 0 && fs > 0) {
            count += 2;
            sf--;
            fs--;
          }
          if (sf > 0)
            count++;
          return count;
        } else if (ss > 0) {
          count += ss;
          return count;
        } else
          return count;
      } else
        return count;
    }
    if (fs > 0) {
      count += 1;
      fs--;
      if (sf > 0 && ss > 0) {
        count += ss;
        while (sf > 0 && fs > 0) {
          count += 2;
          sf--;
          fs--;
        }
        if (sf > 0)
          count++;
        return count;
      } else if (sf > 0) {
        while (sf > 0 && fs > 0) {
          count += 2;
          sf--;
          fs--;
        }
        if (sf > 0)
          count++;
        return count;
      } else if (ss > 0) {
        count += ss;
        return count;
      } else
        return count;
    }
    if (ss > 0)
      count += ss;
    if (sf > 0)
      count += 1;
    return count;
  }

}
