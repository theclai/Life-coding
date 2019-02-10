package leetcode.contests.contest_123;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArraytoFormInteger {

    ArraytoFormInteger arraytoFormInteger;

    @BeforeEach
    public void init() {
        arraytoFormInteger = new ArraytoFormInteger();
    }

    @Test
    public void test_first() {
        List<Integer> res = addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        res.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }

    @Test
    public void test_second() {
        List<Integer> res1 = addToArrayForm(new int[]{2, 7, 4}, 181);
        res1.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }


    @Test
    public void test_third() {
        List<Integer> res2 = addToArrayForm(new int[]{2, 1, 5}, 806);
        res2.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }

    @Test
    public void test_fourth() {
        List<Integer> res2 = addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1);
        res2.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }

    @Test
    public void test_fifth() {
        List<Integer> res2 = addToArrayForm(new int[]{0}, 23);
        res2.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }

    @Test
    public void test_sixth() {
        List<Integer> res2 = addToArrayForm(new int[]{0}, 10000);
        res2.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }

    @Test
    public void test_seventh() {
        List<Integer> res2 = addToArrayForm(new int[]{6}, 809);
        res2.forEach(integer -> System.out.print(integer));
        System.out.println("");
    }



    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int rem = K;
        while (rem / 10 != 0) {
            int r = rem % 10;
            ((LinkedList<Integer>) result).addFirst((int) r);
            rem = rem / 10;
        }
        ((LinkedList<Integer>) result).addFirst(rem);

        List<Integer> finalResult = new LinkedList<>();
        int len=A.length-1;
        int carry=0;

        while (len>=0){
            int a=A[len];
            int b=0;
            if(result.size()!=0){
                b=((LinkedList<Integer>) result).getLast();
                int t=a+b+carry;
                if(t>=10){
                    ((LinkedList<Integer>) finalResult).addFirst(t-10);
                    carry=1;
                }else {
                    ((LinkedList<Integer>) finalResult).addFirst(t);
                    carry=0;
                }
                ((LinkedList<Integer>) result).removeLast();
            }else{
                int t=a+carry;
                if(t>=10){
                    ((LinkedList<Integer>) finalResult).addFirst(t-10);
                    carry=1;
                }else {
                    ((LinkedList<Integer>) finalResult).addFirst(t);
                    carry=0;
                }
            }
            len--;
        }

        while (result.size()>0){
            int r=((LinkedList<Integer>) result).getLast()+carry;
            if(r>=10){
                ((LinkedList<Integer>) finalResult).addFirst(r-10);
                carry=1;
            }else{
                ((LinkedList<Integer>) finalResult).addFirst(r);
                carry=0;
            }
            ((LinkedList<Integer>) result).removeLast();
        }
        if(carry>0)
            ((LinkedList<Integer>) finalResult).addFirst(1);

        return finalResult;
    }
}
