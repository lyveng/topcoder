package srm219.division1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: emmanuel
 * Date: 11/2/13
 * Time: 6:05 PM
 */
public class TurntableService {
    private List<HashSet<Integer>> getFavoritesSetList(String[] favorites) {
        List<HashSet<Integer>> favSetList = new ArrayList<HashSet<Integer>>(favorites.length);
        for (String fav : favorites) {
            String[] favSplit = fav.split(" ");
            HashSet<Integer> favSet = new HashSet<Integer>(favSplit.length);
            for (String entree : favSplit) {
                favSet.add(Integer.parseInt(entree));
            }
            favSetList.add(favSet);
        }
        return favSetList;
    }

    private void populateInitialStates(int n, Queue<State> queue) {
        for (int i = 0; i < n; i++) {
            int cost = i == 0 ? 0 : ((i < n - i) ? (i + 1) : (n - i + 1));
            queue.add(new State(cost, i, new HashSet<Integer>(Arrays.asList(new Integer[] {i})), getInitialFilledEntrees(n)));
        }
    }

    private Set<Integer> getInitialFilledEntrees(int n) {
        Set<Integer> set = new HashSet<Integer>(n);
        for (int i = 0; i < n; i++)
            set.add(i);
        return set;
    }

    private Set<Integer> getEntreesThatCanFillInCurrentPosition(int position, List<HashSet<Integer>> favSetList, int n)
    {
        Set<Integer> retValue = new HashSet<Integer>();
        for (int person=0; person < n;person++)
        {
            int entree = (person+n-position) % n;
            if (favSetList.get(person).contains(entree))
            {
                retValue.add(person);
            }
        }
        return retValue;
    }

    public int calculateTime(String[] favorites) {
        List<HashSet<Integer>> favSetList = getFavoritesSetList(favorites);
        int n = favorites.length;
        Queue<State> queue = new LinkedList<State>();
        populateInitialStates(n, queue);
        int minCost = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            State curState = queue.remove();
            curState.personsNotFilled.removeAll(getEntreesThatCanFillInCurrentPosition(curState.currentPosition, favSetList, n));
            curState.cost = curState.cost + 15;
            if (curState.personsNotFilled.isEmpty())
            {
                if (curState.cost < minCost)
                    minCost = curState.cost;
                break;
            }
            for (int nextPos=0;nextPos<n;nextPos++)
            {
                if (curState.visited.contains(nextPos))
                    continue;
                int curPos = curState.currentPosition;
                int turnCost;
                if (nextPos < curPos)
                {
                    turnCost = (curPos - nextPos) < (n - curPos + nextPos) ? (curPos - nextPos + 1) : (n - curPos + nextPos + 1);
                }
                else
                {
                    turnCost = (nextPos - curPos) < (curPos + n - nextPos) ? (nextPos - curPos + 1) : (curPos + n - nextPos + 1);
                }
                curState.visited.add(nextPos);
                State nextState = new State(curState.cost+turnCost, nextPos, new HashSet<Integer>(curState.visited), new HashSet<Integer>(curState.personsNotFilled));
                queue.add(nextState);
            }
        }
        return minCost;
    }

    private static class State {
        private int cost = 0;
        private int currentPosition = 0;
        private Set<Integer> visited;
        private Set<Integer> personsNotFilled;

        private State(int cost, int currentPosition, Set<Integer> visited, Set<Integer> personsNotFilled) {
            this.cost = cost;
            this.currentPosition = currentPosition;
            this.visited = visited;
            this.personsNotFilled = personsNotFilled;
        }
    }
}

