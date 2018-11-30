package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * <p>
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * <p>
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 */

interface NestedInteger {

    //public NestedInteger();

    // Constructor initializes a single integer.
    //public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class MiniParser_385 {
    public static void main(String[] args) {
        MiniParser_385 mp = new MiniParser_385();
        mp.deserialize("[123,[456,[789]]]");
    }

    public NestedInteger deserialize(String s) {
/*
        char[] arr = s.toCharArray();
        if (arr[0] != '[') return new NestedInteger(Integer.parseInt(s));
        String temp = "";
        Deque<NestedInteger> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                    stack.push(new NestedInteger());
                    break;
                case ']':
                    if (!temp.equals("")) {
                        NestedInteger ni = new NestedInteger(Integer.parseInt(temp));
                        stack.peek().add(ni);
                        temp = "";
                    }
                    NestedInteger top = stack.pop();
                    if (!stack.isEmpty()) {
                        stack.peek().add(top);
                    } else {
                        return top;
                    }


                    break;
                case ',':
                    if (!temp.equals("")) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(temp)));//add NI to parent
                        temp = "";
                    }
                    break;
                default:
                    temp += c;
                    break;
            }
        }
        if (!temp.equals("")) {
            return new NestedInteger(Integer.parseInt(temp));
        }
*/
        return null;
    }


}
