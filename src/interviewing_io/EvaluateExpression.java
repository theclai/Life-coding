package interviewing_io;
// Implement a function to evaluate an expression string.


// The expression string may contain the plus + or minus sign - and non-negative integers.
// Assume that the given expression is always valid.

// Examples =>
// "2+3" = 5
// "3-5" = -2
// "2-7+3" = -2
// "200-100" = 100
//2+3
// Note: Do not use the built-in library functions like eval etc.

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class EvaluateExpression {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }
        //System.out.println(evalExpression("200-100"));
        System.out.println(evalExpression("200-200+10-10+100-100+5-5"));
    }

    public static int evalExpression(String input){
        int left=0;
        int right=0;
        boolean expression =true;
        String temp="";

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+'){
                expression=true;
                //
            }else if(input.charAt(i)=='-'){
                expression=false;
                //
            }else{
                while(i<input.length() &&
                        input.charAt(i)!='+' &&
                        input.charAt(i)!='-'
                        )
                {
                    temp=temp.concat(String.valueOf(input.charAt(i)));
                    i++;
                }
                i--;
                System.out.println(temp);
                right=Integer.parseInt(temp);
                temp="";

                System.out.println(expression);
                if(expression)
                    left=left+right;
                else
                    left=left-right;
            }
        }
        return left;
    }
}




