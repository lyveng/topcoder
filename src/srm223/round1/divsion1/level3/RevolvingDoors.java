package srm223.round1.divsion1.level3;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 10/23/13
 * Time: 12:42 AM
 */
public class RevolvingDoors {
    private int getLinearIndex(char[][] map, int i, int j) {
        return i * map[0].length + j;
    }

    private Position get2dPosition(char[][] map, int linearIndex) {
        int i = linearIndex / map[0].length;
        int j = linearIndex - (i * map[0].length);
        return new Position(i, j);
    }

    private int findChar(char[][] map, char value) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == value)
                    return getLinearIndex(map, i, j);
            }
        }
        return -1;
    }

    private boolean isIndexValid(char[][] map, int i, int j) {
        return i >= 0 && j >= 0 && i < map.length && j < map[0].length;
    }

    private boolean isDoor(char[][] map, int i, int j) {
        return isIndexValid(map, i, j) && map[i][j] == 'O';
    }

    private boolean canRevolveDoor(char[][] map, int linearIndex) {
        Position pos = get2dPosition(map, linearIndex);
        return isDoor(map, pos.i - 1, pos.j - 1) || isDoor(map, pos.i + 1, pos.j - 1) || isDoor(map, pos.i - 1, pos.j + 1) || isDoor(map, pos.i + 1, pos.j + 1);
    }

    private boolean canVisit(char[][] map, int i, int j) {
        return isIndexValid(map, i, j) && (map[i][j] == ' ' || map[i][j] == 'S' || map[i][j] == 'E');
    }

    private List<Integer> getAdjacentNodesToVisit(char[][] map, int element) {
        Position pos = get2dPosition(map, element);
        List<Integer> adj = new LinkedList<Integer>();
        if (canVisit(map, pos.i - 1, pos.j))
            adj.add(getLinearIndex(map, pos.i - 1, pos.j));
        if (canVisit(map, pos.i, pos.j - 1))
            adj.add(getLinearIndex(map, pos.i, pos.j - 1));
        if (canVisit(map, pos.i, pos.j + 1))
            adj.add(getLinearIndex(map, pos.i, pos.j + 1));
        if (canVisit(map, pos.i + 1, pos.j))
            adj.add(getLinearIndex(map, pos.i + 1, pos.j));
        return adj;
    }

    private boolean bfs(char[][] map, Queue<Integer> doorQueue, Set<Integer> visitedDoors, int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Integer curElement = queue.remove();
            if (curElement == end) {
                return true;
            }
            if (!visitedDoors.contains(curElement) && canRevolveDoor(map, curElement)) {
                doorQueue.add(curElement);
                visitedDoors.add(curElement);
            }
            List<Integer> adjList = getAdjacentNodesToVisit(map, curElement);
            for (Integer adj : adjList)
            {
                if (!visited.contains(adj))
                {
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }
        return false;
    }

    private char[][] getCharMap(String[] map)
    {
        char[][] charMap = new char[map.length][];
        for (int i = 0;i<map.length;i++)
        {
            charMap[i] = new char[map[0].length()];
            for (int j=0;j<map[0].length();j++)
            {
                charMap[i][j] = map[i].charAt(j);
            }
        }
        return charMap;
    }

    private List<Position> getDoorPositionsFromDiagonalPosition(char[][] map, Position pos)
    {
        List<Position> positions = new LinkedList<Position>();
        if (isDoor(map, pos.i-1, pos.j-1))
            positions.add(new Position(pos.i-1, pos.j-1));
        if (isDoor(map, pos.i-1, pos.j+1))
            positions.add(new Position(pos.i-1, pos.j+1));
        if (isDoor(map, pos.i+1, pos.j-1))
            positions.add(new Position(pos.i+1, pos.j-1));
        if (isDoor(map, pos.i+1, pos.j+1))
            positions.add(new Position(pos.i+1, pos.j+1));
        assert !positions.isEmpty(); // Code execution should not reach this place.
        return positions;
    }

    private void turnDoor(char[][] map, Position pos)
    {
        assert (map[pos.i-1][pos.j] == '|' && map[pos.i+1][pos.j] == '|') || (map[pos.i][pos.j-1] == '-' && map[pos.i][pos.j+1] == '-');
        if (map[pos.i-1][pos.j] == '|' && map[pos.i+1][pos.j] == '|')
        {
            map[pos.i-1][pos.j] = ' ';
            map[pos.i+1][pos.j] = ' ';
            map[pos.i][pos.j-1] = '-';
            map[pos.i][pos.j+1] = '-';
        }
        else if (map[pos.i][pos.j-1] == '-' && map[pos.i][pos.j+1] == '-')
        {
            map[pos.i-1][pos.j] = '|';
            map[pos.i+1][pos.j] = '|';
            map[pos.i][pos.j-1] = ' ';
            map[pos.i][pos.j+1] = ' ';
        }
        else
        {
            assert false; // Code execution should not reach this place.
        }
    }

    public int turns(String[] map) {
        char[][] charMap = getCharMap(map);
        final int start = findChar(charMap, 'S');
        final int end = findChar(charMap, 'E');
        Set<Integer> visitedDoors = new HashSet<Integer>();
        Queue<Integer> doorQueue = new LinkedList<Integer>();
        Queue<Integer> nextLevelDoorQueue = new LinkedList<Integer>();
        int turns = 0;
        if (bfs(charMap, doorQueue, visitedDoors, start, end))
            return turns;
        turns++;
        while (!doorQueue.isEmpty())
        {
            int doorToTurn = doorQueue.remove();
            List<Position> doorsToTurn = getDoorPositionsFromDiagonalPosition(charMap, get2dPosition(charMap, doorToTurn));
            for (Position pos : doorsToTurn)
            {
                turnDoor(charMap, pos);
                visitedDoors.add(doorToTurn);
                if (bfs(charMap, nextLevelDoorQueue, visitedDoors, doorToTurn, end))
                    return turns;
            }
            if (doorQueue.isEmpty())
            {
                turns++;
                doorQueue = nextLevelDoorQueue;
                nextLevelDoorQueue = new LinkedList<Integer>();
                visitedDoors = new HashSet<Integer>();
            }
        }
        return -1;
    }

    private class Position {
        int i;
        int j;

        private Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
