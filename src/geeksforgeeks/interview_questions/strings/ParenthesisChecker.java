package geeksforgeeks.interview_questions.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String in = "[()]{}{[()()]()}";
        System.out.println(isValid(in));

        //System.out.println(isValid("{{}}"));
    }

    public static boolean isValid(String in) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < in.length(); i++) {
            if (!stack.isEmpty()) {
                Character c = stack.peekFirst();
                if (helper(in.charAt(i)) == c)
                    stack.removeFirst();
                else
                    stack.addFirst(c);
            } else {
                stack.addFirst(in.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    public static Character helper(Character character) {
        Character op = null;
        switch (character) {
            case ']':
                op = '[';
                break;
            case '}':
                op = '{';
                break;
            case ')':
                op = '(';
                break;
        }
        return op;
    }
}
