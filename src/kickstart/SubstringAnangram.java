package kickstart;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubstringAnangram {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numOfChars = in.nextInt();
            String A = in.nextLine();
            String B= in.nextLine();
            System.out.println(A);
            System.out.println(B);

            List<String> subsA=subStringOfA(A,numOfChars);
            List<String> subsB=subStringOfA(B,numOfChars);

            int returnNumerOfAnangram= ananGramCounter(subsA,subsB);

        }

    }

    private static int ananGramCounter(List<String> subsA, List<String> subsB) {
        int counter=0;
        for (String word:subsA) {
            for(int i=0;i<subsB.size();i++){

                char[] tempArrayA=word.toCharArray();
                Arrays.sort(tempArrayA);
                String sortedWord=new String(tempArrayA);

                char[] targetArray=subsB.get(i).toCharArray();
                Arrays.sort(targetArray);
                String sortedTarget=new String(targetArray);

                if(sortedWord.length()==sortedTarget.length()){
                    //compare char by char
                    boolean checked=true;
                    for(int j=0;j<sortedWord.length();j++){
                        if(sortedWord.charAt(j)!=sortedTarget.charAt(j)){
                            checked=false;
                            break;
                        }
                    }
                    if(checked)
                        counter=counter+1;
                }
            }
        }
        return counter;
    }

    private static List<String> subStringOfA(String in,int n) {
        List<String> output=new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                output.add(in.substring(i,j));

        return output;
    }
}
