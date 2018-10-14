package leetcode.contests;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Minimum_Add_to_Make_Parentheses_Valid_921 {
    public static void main(String[] args) {
        String input="())";
        //String input="(((";
        //String input="()))((";
        //String input="((())";
        System.out.println(minAddToMakeValid(input));
    }

    private static int minAddToMakeValid(String S) {
        if(S==null || S.length()==0){
            return 0;
        }
        Stack stack=new Stack();
        for (int i = 0; i <S.length() ; i++) {
            if(!stack.isEmpty()){
                char c= (char) stack.peek();
                if(isReverse(c,S.charAt(i))){
                    stack.pop();
                }else {
                    stack.push(S.charAt(i));
                }

            }else{
                stack.push(S.charAt(i));
            }

        }
        return stack.size();
    }

    private static boolean isReverse(char char1, int char2) {
        if(char1=='(' && char2==')'){
            return true;
        }
        return false;
    }
}
