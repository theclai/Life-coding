package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextSmallestTimeWithDigits {
    static String result = "";
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(nextClosestTime("23:59"));
    }

    public static String nextClosestTime(String time) {
        int originalMins = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        Set<Character> set = new HashSet<>();
        time.chars().mapToObj(c -> (char) c).forEach(val -> {
            if (val != ':')
                set.add(val);
        });

        List<Character> list = new ArrayList<>(set);
        dfs(list, "", originalMins);
        return result;
    }

    private static void dfs(List<Character> list, String temp, int originalMins) {
        if (temp.length() == 4) {
            // convert time into min
            String hrString=temp.substring(0, 2);
            String minString=temp.substring(2);
            int hour = Integer.parseInt(hrString);
            int min = Integer.parseInt(minString);
            if (hour > 23 || min > 59) {
                return;
            }
            // you have to add 24hrs if smaller
            int total = (hour * 60) + min;
            total +=((total <= originalMins) ? (24 * 60) : 0);

            if (minDiff > total - originalMins) {
                minDiff = total - originalMins;
                result = hrString + ":" + minString;
            }
            return;
        }

        // create all combinations
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);
            dfs(list, temp, originalMins);
            temp = temp.substring(0, temp.length() - 1);
        }
        return;
    }


}
