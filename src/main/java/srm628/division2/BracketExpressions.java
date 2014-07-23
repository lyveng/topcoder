package srm628.division2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Level 2 problem.
 * 
 * @author emmanuel
 * 
 */
public class BracketExpressions {
  private char[] values = new char[] {'(', '{', '[', ']', '}', ')'};
  private Map<Character, Character> charMap;

  public String ifPossible(String expression) {
    charMap = new HashMap<Character, Character>();
    charMap.put(')', '(');
    charMap.put(']', '[');
    charMap.put('}', '{');
    StringBuilder sb = new StringBuilder(expression);
    List<Integer> xPositions = new ArrayList<>();
    for (int i = 0; i < expression.length(); i++)
      if (expression.charAt(i) == 'X')
        xPositions.add(i);
    if (ifPossibleUtil(sb, xPositions, 0))
      return "possible";
    return "impossible";
  }

  private boolean ifPossibleUtil(StringBuilder expression, List<Integer> xPositions, int index) {
    if (index == xPositions.size()) {
      return checkIfPossible(expression);
    }
    for (char c : this.values) {
      expression.setCharAt(xPositions.get(index), c);
      if (ifPossibleUtil(expression, xPositions, index + 1))
        return true;
      expression.setCharAt(xPositions.get(index), 'X');
    }
    return false;
  }

  private boolean checkIfPossible(StringBuilder exp) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < exp.length(); i++) {
      if (exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{')
        s.push(exp.charAt(i));
      else if (s.empty() || s.pop() != charMap.get(exp.charAt(i)))
        return false;
    }
    return s.empty();
  }
}
