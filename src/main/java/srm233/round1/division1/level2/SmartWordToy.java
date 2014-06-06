package srm233.round1.division1.level2;

import java.util.*;

/**
 * The toy company "I Can't Believe It Works!" has hired you to help develop educational toys. The
 * current project is a word toy that displays four letters at all times. Below each letter are two
 * buttons that cause the letter above to change to the previous or next letter in alphabetical
 * order. So, with one click of a button the letter 'c' can be changed to a 'b' or a 'd'. The
 * alphabet is circular, so for example an 'a' can become a 'z' or a 'b' with one click. In order to
 * test the toy, you would like to know if a word can be reached from some starting word, given one
 * or more constraints. A constraint defines a set of forbidden words that can never be displayed by
 * the toy. Each constraint is formatted like "X X X X", where each X is a string of lowercase
 * letters. A word is defined by a constraint if the ith letter of the word is contained in the ith
 * X of the contraint. For example, the constraint "lf a tc e" defines the words "late", "fate",
 * "lace" and "face". You will be given a String start, a String finish, and a String[] forbid.
 * Calculate and return the minimum number of button presses required for the toy to show the word
 * finish if the toy was originally showing the word start. Remember, the toy must never show a
 * forbidden word. If it is impossible for the toy to ever show the desired word, return -1.
 * 
 * @author emmanuel
 * 
 */
public class SmartWordToy
{
    private static final int ASCII_VALUE_OF_A = (int) 'a';

    private static final StringBuilder sb = new StringBuilder();

  /**
   * Each constraint is formatted like "X X X X", where each X is a string of lowercase letters. A
   * word is defined by a constraint if the ith letter of the word is contained in the ith X of the
   * contraint. For example, the constraint "lf a tc e" defines the words "late", "fate", "lace" and
   * "face"
   * 
   * All possible constraints are generated and added to the given set.
   * 
   * @param constraint
   * @param constraints
   */
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

    /**
     * Fetches the next word formed by changing the character at given index in the specified direction.
     * 
     * @param cur_node
     * @param index
     * @param direction
     * @return
     */
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
        sb.setCharAt(index, newChar);
        return sb.toString();
    }

  /**
   * Consider the different possible words as nodes of a graph and every button press as an edge.
   * Now find the shortest path from start to finish while not visiting the elements in the
   * constraints set.
   * 
   * This problem uses BreadthFirst Search of Undirected Graphs.
   * 
   * @param start
   * @param finish
   * @param forbid
   * @return
   */
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