package leetcode;

import java.util.Arrays;

public class TopVotedCandiate {
    int[] p;
    int[] times;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public TopVotedCandiate(int[] persons, int[] times) {
        this.p=persons;
        this.times=times;
    }

    public int q(int t) {
        int step=0;
        for(int i=0;i<times.length;i++) {
            if(times[i]<=t) {
                step++;
            }
        }
        int[] targetPersons=Arrays.copyOfRange(p,0,step+1);
        int zeroCounter=0;
        int oneCounter=0;
        for(int i=0;i<=targetPersons.length;i++) {
            if(targetPersons[i]==0)
                zeroCounter++;
            else
                oneCounter++;
        }
        return zeroCounter>oneCounter?zeroCounter:oneCounter;

    }
}
