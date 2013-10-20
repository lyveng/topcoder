import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/20/13
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class WalkingHome {
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

    private boolean isIndicesValid(String[] map, int i, int j)
    {
        return !(i < 0 || i >= map.length || j < 0 || j >= map[0].length());
    }

    private boolean canVisit(String[] map, int i, int j)
    {
        return map[i].charAt(j) == '.' || map[i].charAt(j) == 'S' || map[i].charAt(j) == 'H';
    }

    private boolean isVisited(int[][] connectedComponents, int i, int j)
    {
        return connectedComponents[i][j] != -1;
    }

    private boolean isRoad(String[] map, int i, int j)
    {
        return map[i].charAt(j) == '-' || map[i].charAt(j) == '|';
    }

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
