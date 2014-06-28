package srm229.division2;

/**
 * Level 2 problem.
 * 
 * @author emmanuel
 *
 */
public class Cafeteria {
  public String latestTime(int[] offset, int[] walkingTime, int[] drivingTime) {
    int target = 870; // Represents 2:30 pm
    int latestTime = Integer.MIN_VALUE, curTime;
    for (int i = 0; i < offset.length; i++) {
      curTime = target - drivingTime[i];
      curTime -= (((curTime % 60) - offset[i]) % 10);
      curTime -= walkingTime[i];
      if (curTime > latestTime)
        latestTime = curTime;
    }
    int hour = latestTime / 60, minutes = latestTime % 60;
    if (hour > 12)
      hour = hour - 12;
    return String.format("%02d:%02d", hour, minutes);
  }

  public static void main(String[] args) {
    Cafeteria obj = new Cafeteria();
    System.out.println(obj.latestTime(new int[] {9}, new int[] {1}, new int[] {1}));
    System.out.println(obj.latestTime(new int[] {6}, new int[] {9}, new int[] {120}));
    System.out.println(obj.latestTime(new int[] {6, 9}, new int[] {9, 10}, new int[] {120, 121}));
    System.out.println(obj.latestTime(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {11, 11, 11, 11, 11, 11, 11, 11, 11, 11}, new int[] {190,
        190, 190, 190, 190, 190, 190, 190, 190, 190}));
    System.out.println(obj.latestTime(new int[] {7, 4, 0, 0, 2, 1, 6, 7, 7, 0, 8, 6, 0, 5, 0, 6, 7, 9, 0, 2, 4, 8, 4, 7, 9, 2, 4, 4, 3, 1, 4, 5, 8,
        8, 2, 5, 7, 8, 7, 5, 6, 8, 8, 0, 1, 3, 5, 0, 8}, new int[] {26, 14, 1, 4, 16, 28, 16, 6, 4, 5, 21, 18, 5, 2, 21, 21, 28, 22, 5, 22, 26, 16,
        14, 19, 19, 19, 4, 12, 24, 4, 30, 16, 28, 20, 25, 2, 30, 18, 4, 6, 9, 22, 8, 3, 7, 29, 8, 30, 6}, new int[] {151, 264, 280, 89, 63, 57, 15,
        120, 28, 296, 76, 269, 90, 106, 31, 222, 291, 52, 102, 73, 140, 248, 44, 187, 76, 49, 296, 106, 54, 119, 54, 283, 263, 285, 275, 127, 108,
        82, 84, 241, 169, 203, 244, 256, 109, 288, 9, 262, 103}));
  }

}
