package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParanthesisChecker {
    public static void main(String[] args){
        String input = "(]";
        boolean output = isValid(input);
        System.out.println(output);

    }

    public static boolean isValid(String input){
        Stack<Character> q = new Stack<>();
        for(int i=0;i<input.length();i++){
            char iChar = input.charAt(i);
            if(!q.isEmpty()) {
                char c = q.lastElement();
                if(isReverse(iChar,c)){
                    q.pop();
                }else{
                    q.push(iChar);
                }

            }else{
                q.push(iChar);
            }
        }
        if(q.isEmpty()){
            return true;
        }
        return false;

    }

    private static boolean isReverse(char iChar, char c) {
        switch (c){
            case '(':
                if(iChar==')'){
                    return true;
                }
                break;
            case '{':
                if(iChar=='}'){
                    return true;
                }
                break;
            case '[':
                if(iChar==']'){
                    return true;
                }
                break;
        }
        return false;
    }

}
