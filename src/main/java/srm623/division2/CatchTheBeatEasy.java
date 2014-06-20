package srm623.division2;

/**
 * One of the modes in the game "osu!" is called "catch the beat". In this mode, you control a character that catches
 * falling fruit.   The game is played in the vertical plane. For simplicity, we will assume that both your character
 * and all pieces of fruit are points in that plane.   You start the game at the coordinates (0, 0). Your character
 * can only move along the x-axis. The maximum speed of your character is 1 unit of distance per second. For example,
 * you need at least 3 seconds to move from (-2, 0) to (1, 0).   You are given int[]s x and y that contain initial
 * coordinates of the fruit you should catch: for each valid i, there is one piece of fruit that starts at (x[i], y[i]).
 * All pieces of fruit fall down with constant speed of 1 unit of distance per second. That is, a fruit currently
 * located at (xf, yf) will move to (xf, yf-t) in t seconds.   You will catch a fruit if the character is located at the
 * same point as the fruit at some moment in time. Can you catch all the fruit in the game? Return "Able to catch"
 * (quotes for clarity) if you can, and "Not able to catch" otherwise.
 */
public class CatchTheBeatEasy {
    public String ableToCatchAll(int[] x, int[] y) {
        int prevX = 0, prevY = 0;
        for (int i=0;i<x.length;i++) {
            if (Math.abs(x[i] - prevX) <= Math.abs(y[i] - prevY))
            {
                prevX = x[i];
                prevY = y[i];
            }
            else
                return "Not able to catch";
        }
        return "Able to catch";
    }

    public static void main(String[] args)
    {
      CatchTheBeatEasy obj = new CatchTheBeatEasy();
      System.out.println(obj.ableToCatchAll(new int[] {-1,1,0}, new int[] {1,3,4}));
      System.out.println(obj.ableToCatchAll(new int[] {-3}, new int[] {2}));
      System.out.println(obj.ableToCatchAll(new int[] {-1,1,0}, new int[] {1,2,4}));
      System.out.println(obj.ableToCatchAll(new int[] {0,-1,1}, new int[] {9,1,3}));
    }
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!