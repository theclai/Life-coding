package stackoverflow;

import java.util.Arrays;

public class Stackoverflow_03262019 {
    public static void main(String[] args) {
        int[] arr=new int[5];
        Arrays.fill(arr,0);
        Arrays.stream(arr).forEach(val-> System.out.println(val));
    }
}
