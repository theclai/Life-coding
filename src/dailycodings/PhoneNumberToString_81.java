package dailycodings;
import java.util.*;

public class PhoneNumberToString_81 {
    static PhoneNumberToString_81 ps;
    static ArrayList<String>[] rel;

    public static void main(String[] args) {
        rel = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            rel[i] = new ArrayList<>();
        }
        rel[2].add("a");rel[2].add("b");rel[2].add("c");
        rel[3].add("d");rel[3].add("e");rel[3].add("f");
        rel[4].add("g");rel[4].add("h");rel[4].add("i");
        List<String> output=findSets(new int[]{2,3,4});
        for (String s:output
             ) {
            System.out.println(s);

        }

    }
    public static List<String> findSets(int[] in) {
        return helper(in, 0, new ArrayList<>());

    }

    private static List<String> helper(int[] ins, int pos, ArrayList<String> results) {
        if (pos == ins.length) return results;

        int inChar = ins[pos];
        if (results.size() == 0) {
            results.addAll(rel[inChar]);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            for (String str : results) {
                for (int i = 0; i < rel[inChar].size(); i++) {
                    String s = rel[inChar].get(i);
                    temp.add(str.concat(s));
                }
            }
            results.clear();
            results.addAll(temp);
        }
        return helper(ins, pos + 1, results);
    }

}
