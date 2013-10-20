/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/8/13
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class SmartWordToy
{
    private static final int ASCII_VALUE_OF_A = (int) 'a';

    private static final StringBuilder sb = new StringBuilder();

    private void addConstraint(String constraint, Set<String> constraints)
    {
        String[] split = constraint.split(" ");
        String a = split[0], b = split[1], c = split[2], d = split[3];
        for (char a_c : a.toCharArray())
        {
            for (char b_c : b.toCharArray())
            {
                for (char c_c : c.toCharArray())
                {
                    for (char d_c : d.toCharArray())
                    {
                        constraints.add(new String(new char[] {a_c, b_c, c_c, d_c}));
                    }
                }
            }
        }
    }

    public static String getNextNode(String cur_node, int index, int direction)
    {
        int asciiOfCharToReplace = ((int) cur_node.charAt(index)) - ASCII_VALUE_OF_A + direction;
        if (asciiOfCharToReplace == 26)
            asciiOfCharToReplace = 0;
        else if (asciiOfCharToReplace == -1)
            asciiOfCharToReplace = 25;

        char newChar = (char) (ASCII_VALUE_OF_A + asciiOfCharToReplace);
        sb.delete(0, sb.length());
        sb.append(cur_node);
        sb.replace(index, index+1, new String(new char[] {newChar}));
        return sb.toString();
    }

    public int minPresses(String start, String finish, String[] forbid)
    {
        if (start.equals(finish))
            return 0;
        Set<String> constraints = new LinkedHashSet<String>();
        Set<String> visited = new LinkedHashSet<String>();
        for (String constraint : forbid)
        {
            addConstraint(constraint, constraints);
        }
        if (constraints.contains(finish))
            return -1;
        Queue<QueueElement> toVisit = new LinkedList<QueueElement>();
        toVisit.add(new QueueElement(0, start));
        visited.add(start);
        int[] directions = new int[] {1,-1};
        while (!toVisit.isEmpty())
        {
            QueueElement cur_node = toVisit.remove();
            for (int i=0;i<4;i++)
            {
                for (int direction : directions)
                {
                    String next_node = getNextNode(cur_node.node, i, direction);
                    if (!constraints.contains(next_node) && !visited.contains(next_node))
                    {
                        visited.add(next_node);
                        toVisit.add(new QueueElement(cur_node.distance+1, next_node));
                        if (finish.equals(next_node))
                            return cur_node.distance + 1;
                    }
                }
            }
        }
        return -1;
    }

    class QueueElement
    {
        String node;
        int distance;

        QueueElement(int distance, String node) {
            this.distance = distance;
            this.node = node;
        }
    }

}