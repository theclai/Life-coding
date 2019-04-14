package leetcode.contests.contest_132;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisorGame {
    DivisorGame divisorGame;
    int alice = 1;
    int bob = 2;

    @BeforeEach
    public void init() {
        divisorGame = new DivisorGame();
    }


    @Test
    public void testFirst() {
        int N = 2;
        boolean res = play(N);
        System.out.println(res);
        Assertions.assertEquals(true,res);
    }

    @Test
    public void testSecond() {
        int N = 3;
        boolean res = play(N);
        System.out.println(res);
        Assertions.assertEquals(false,res);
    }
    @Test
    public void testThird() {
        int N = 0;
        boolean res = divisorGame(N);
        System.out.println(res);
        Assertions.assertEquals(false,res);
    }


    @Test
    public void testFourth() {
        int N = 4;
        boolean res = divisorGame(N);
        System.out.println(res);
        Assertions.assertEquals(true,res);
    }

    public boolean divisorGame(int N) {
        return play(N);
    }

    private boolean play(int n) {
        int player=alice;
        while (n > 0) {
           int move= nextMove(n,player);
            n-=move;
            if(n==1 && player==alice)
               return true;
           else if(n==1 && player==bob){
               return false;
           }
           if(player==alice)
               player=bob;
           else
               player=alice;
        }
        return false;
    }

    private int nextMove(int n,int player) {
       return 1;
    }
}
