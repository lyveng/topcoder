package srm222.round1.division1.level2;

import java.util.*;

/**
 * Johnny has to walk home from school, and wants to map out the best route to take, so that he has
 * to cross as few streets as possible.
 * 
 * You are given a String[] map that maps the roadway layout of Johnny's town. The location of
 * Johnny's school is designated with a 'S' character, and the location of Johnny's home is
 * designated with a 'H' character. North-South roads are denoted by a '|' character, while
 * East-West roads are denoted by a '-' character. Intersections, which can never be crossed, are
 * indicated by '*' characters. Fences, indicated by a 'F' character, can also never be crossed. All
 * other areas are indicated by '.' characters; Johnny can walk freely over these areas.
 * 
 * For maximum safety, Johnny may only walk directly across a road, perpendicular to the traffic,
 * never diagonally. All of Johnny's movements, onto and off of a road, and walking around town,
 * should be in one of the four cardinal directions. Johnny may, however, cross roads that are
 * multiple lanes wide, and doing so only counts as a single crossing. Two or more adjacent ||
 * characters are always considered to be a single road, and this works similarly for '-' characters
 * that appear adjacent vertically.
 * 
 * For instance, the following requires only a single crossing, since it's a single two-lane road:
 * 
 * S.||.H Also, a situation such as the following leaves Johnny with no safe way to walk home, since
 * he cannot cross the road diagonally, and can only step onto and off a road in a direction
 * perpendicular to the road:
 * 
 * S|| ||H Also notice that because Johnny can never move diagonally, in the following case, Johnny
 * cannot get home:
 * 
 * S.F .F. F.H You are to return an int indicating the fewest number of times Johnny must cross the
 * street on his way home. If there is no safe way for Johnny to get home, return -1.
 * 
 * @author emmanuel
 * 
 */
public class WalkingHome {
    /**
   * Initialize an empty m by n integer matrix where m is length of the strings in map and n is the
   * number of elements in map.
   * All integers are initialized to -1.
   * 
   * @param map
   * @return
   */
    private int[][] getInitialConnectedComponents(String[] map)
    {
        int[][] connectedComponents = new int[map.length][];
        for (int i=0;i<map.length;i++)
        {
            connectedComponents[i] = new int[map[i].length()];
            for (int j=0;j<map[i].length();j++)
            {
                connectedComponents[i][j] = -1;
            }
        }
        return connectedComponents;
    }

    /**
     * Sets the connected components matrix and returns the number of connected components.
     * 
     * @param map
     * @param connectedComponents
     * @return
     */
    private int getConnectedComponents(String[] map, int[][] connectedComponents)
    {
        int component = 0;
        for (int i=0;i<map.length;i++)
        {
            for (int j=0;j<map[i].length();j++)
            {
                if (!canVisit(map, i, j) || isVisited(connectedComponents, i, j))
                    continue;
                dfs(map, connectedComponents, i, j, component);
                component++;
            }
        }
        return component;
    }

    /**
     * Performs dfs on the given matrix and computes the connected components.
     * 
     * @param map
     * @param connectedComponents
     * @param i
     * @param j
     * @param component
     */
    private void dfs(String[] map, int[][] connectedComponents, int i, int j, int component)
    {
        connectedComponents[i][j] = component;
        for (int di = -1; di <= 1; di++)
        {
            for (int dj = -1; dj <= 1; dj++)
            {
                int newI = i+di;
                int newJ = j+dj;
                if (isIndicesValid(map, newI, newJ) && canVisit(map, newI, newJ) && !isVisited(connectedComponents, newI, newJ))
                {
                    dfs(map, connectedComponents, newI, newJ, component);
                }
            }
        }
    }

    /**
     * Checks if the given indices are within the maps range.
     * 
     * @param map
     * @param i
     * @param j
     * @return
     */
    private boolean isIndicesValid(String[] map, int i, int j)
    {
        return !(i < 0 || i >= map.length || j < 0 || j >= map[0].length());
    }

    /**
     * Checks if the character corresponding the given indices i,j is one of those that can be visited.
     * 
     * @param map
     * @param i
     * @param j
     * @return
     */
    private boolean canVisit(String[] map, int i, int j)
    {
        return map[i].charAt(j) == '.' || map[i].charAt(j) == 'S' || map[i].charAt(j) == 'H';
    }

    /**
   * Checks if the node at i,j has already been visited. All visited nodes will have a valid value
   * other than -1 as the connected component.
   * 
   * @param connectedComponents
   * @param i
   * @param j
   * @return
   */
    private boolean isVisited(int[][] connectedComponents, int i, int j)
    {
        return connectedComponents[i][j] != -1;
    }

    /**
     * Checks if the character at i,j is a road.
     * 
     * @param map
     * @param i
     * @param j
     * @return
     */
    private boolean isRoad(String[] map, int i, int j)
    {
        return map[i].charAt(j) == '-' || map[i].charAt(j) == '|';
    }

    /**
   * Adds an edge to the adjacency list based on whether it is a horizontal or vertical road. It
   * adds an edge only if both ends of the crossing can be visited and combines immediate parallel
   * roads.
   * 
   * @param map
   * @param connectedComponents
   * @param components
   * @param i
   * @param j
   * @param adjList
   */
    private void visitRoad(String[] map, int[][] connectedComponents, int components, int i, int j, List<Set<Integer>> adjList)
    {
        if (map[i].charAt(j) == '-')
            visitHorizontal(map, connectedComponents, components, i, j, adjList);
        else if (map[i].charAt(j) == '|')
            visitVerticalRoad(map, connectedComponents, components, i, j, adjList);
    }

    private void visitVerticalRoad(String[] map, int[][] connectedComponents, int components, int i, int j, List<Set<Integer>> adjList)
    {
        int leftJ = j - 1;
        int rightJ = j + 1;
        while (leftJ >= 0 && map[i].charAt(leftJ) == '|')
        {
            connectedComponents[i][leftJ] = components;
            leftJ--;
        }
        if (!isIndicesValid(map, i, leftJ) || !canVisit(map, i, leftJ))
            return;
        while (rightJ < map[0].length() && map[i].charAt(rightJ) == '|')
        {
            connectedComponents[i][rightJ] = components;
            rightJ++;
        }
        if (!isIndicesValid(map, i, leftJ) || !canVisit(map, i, rightJ))
            return;
        int leftJComponent = connectedComponents[i][leftJ];
        int rightJComponent = connectedComponents[i][rightJ];
        adjList.get(leftJComponent).add(rightJComponent);
        adjList.get(rightJComponent).add(leftJComponent);
    }

    private void visitHorizontal(String[] map, int[][] connectedComponents, int components, int i, int j, List<Set<Integer>> adjList)
    {
        connectedComponents[i][j] = components;
        int upperI = i-1;
        int lowerI = i+1;
        while (upperI >= 0 && map[upperI].charAt(j) == '-')
        {
            connectedComponents[upperI][j] = components;
            upperI--;
        }
        if (!isIndicesValid(map, upperI, j) || !canVisit(map, upperI, j)) {
            return;
        }
        while (lowerI < map.length && map[lowerI].charAt(j) == '-')
        {
            connectedComponents[lowerI][j] = components;
            lowerI++;
        }
        if (!isIndicesValid(map, lowerI, j) || !canVisit(map, lowerI, j))
            return;
        int lowerIComponent = connectedComponents[lowerI][j];
        int upperIComponent = connectedComponents[upperI][j];
        adjList.get(lowerIComponent).add(upperIComponent);
        adjList.get(upperIComponent).add(lowerIComponent);
    }

    /**
   * Constructs a graph where the nodes are the connected components of the input matrix and the
   * list of edges are the vertical or horizontal roads that the boy can cross.
   * 
   * @param map
   * @param connectedComponents
   * @param components
   * @return
   */
    private List<Set<Integer>> getAdjacencyList(String[] map, int[][] connectedComponents, int components)
    {
        List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
        for (int i=0;i<components;i++)
        {
            adjList.add(new HashSet<Integer>(components));
        }
        for (int i=0;i<map.length;i++)
        {
            for (int j=0;j<map[i].length();j++)
            {
                if (isRoad(map, i, j) && !isVisited(connectedComponents, i, j))
                {
                    visitRoad(map, connectedComponents, components, i, j, adjList);
                }
            }
        }

        return adjList;
    }

    /**
     * Prints the connected components.
     * 
     * @param connectedComponents
     * @param components
     */
    private void printConnectedComponents(int[][] connectedComponents, int components)
    {
        System.out.println("Total number of components is " + components);
        for (int i=0;i<connectedComponents.length;i++)
        {
            for (int j=0;j<connectedComponents[i].length;j++)
            {
                System.out.print(connectedComponents[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Prints the graph generated from the connected components and the roads.
     * 
     * @param adjList
     */
    private void printAdjacencyList(List<Set<Integer>> adjList)
    {
        System.out.println("Printing adjacency list.");
        for (int i=0; i < adjList.size(); i++)
        {
            Set<Integer> edges = adjList.get(i);
            System.out.print(i + " : ");
            for (Integer edge : edges)
            {
                System.out.print(edge + "\t");
            }
            System.out.println();
        }
    }

    private int shortestPath(List<Set<Integer>> adjList, int start, int end)
    {
        Queue<Integer> Q = new LinkedList<Integer>();
        Map<Integer, Integer> V = new HashMap<Integer, Integer>();
        Q.add(start);
        V.put(start, 0);
        while (!Q.isEmpty())
        {
            Integer t = Q.remove();
            int path = V.get(t);
            if (end == t)
            {
                return path;
            }
            for (Integer u : adjList.get(t))
            {
                if (!V.containsKey(u))
                {
                    V.put(u, path + 1);
                    Q.add(u);
                }
            }
        }
        return -1;
    }

    /**
     * Calculates the fewest crossings. The edges in the adjList correspond to the actual crossings.
     * 
     * @param map
     * @param connectedComponents
     * @param adjList
     * @return
     */
    private int fewestCrossings(String[] map, int[][] connectedComponents, List<Set<Integer>> adjList)
    {
        int startI=0, startJ=0, endI=0, endJ=0;
        for (int i=0;i<map.length;i++)
        {
            for (int j=0;j<map[i].length();j++)
            {
                if (map[i].charAt(j) == 'S')
                {
                    startI = i;
                    startJ = j;
                }
                else if (map[i].charAt(j) == 'H')
                {
                    endI = i;
                    endJ = j;
                }
            }
        }
        int schoolComponent = connectedComponents[startI][startJ];
        int homeComponent = connectedComponents[endI][endJ];
        return shortestPath(adjList, schoolComponent, homeComponent);
    }

    /**
     * 1. Finds the connected components
     * 2. Generates a new graph with the connected components as nodes and crossings as edges.
     * 3. Finds shortest the path from start component to end component.
     * 
     * @param map
     * @return
     */
    public int fewestCrossings(String[] map)
    {
        int[][] connectedComponents = getInitialConnectedComponents(map);
        int components = getConnectedComponents(map, connectedComponents);
        printConnectedComponents(connectedComponents, components);
        List<Set<Integer>> adjList = getAdjacencyList(map, connectedComponents, components);
        printAdjacencyList(adjList);
        int fewestCrossings = fewestCrossings(map, connectedComponents, adjList);
        System.out.println("Fewest crossings is " + fewestCrossings);
        return fewestCrossings;
    }

    public static void main(String[] args)
    {
        WalkingHome w = new WalkingHome();
        String[] input0 = new String[] {"S.|..",
                                        "..|.H"};
        w.fewestCrossings(input0);
        String[] input1 = new String[] {"S.|..",
                "..|.H",
                "..|..",
                "....."};
        w.fewestCrossings(input1);
        String[] input2 = new String[] {"S.||...",
                "..||...",
                "..||...",
                "..||..H"};
        w.fewestCrossings(input2);
        String[] input3 = new String[] {"S.....",
                "---*--",
                "...|..",
                "...|.H"};
        w.fewestCrossings(input3);
        String[] input4 = new String[] {"S.F..",
                "..F..",
                "--*--",
                "..|..",
                "..|.H"};
        w.fewestCrossings(input4);
        String[] input5 = new String[] {"H|.|.|.|.|.|.|.|.|.|.|.|.|.",
                "F|F|F|F|F|F|F|F|F|F|F|F|F|-",
                "S|.|.|.|.|.|.|.|.|.|.|.|.|."};
        w.fewestCrossings(input5);
        String[] input6 = new String[]{"S-H"};
        w.fewestCrossings(input6);
    }

}
