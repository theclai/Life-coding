package contest.hashcode_2019;

import java.io.*;
import java.util.*;

public class FirstProblem {
    static class Photo {
        String orientation;
        int t;
        String tags;
        int id;

        public Photo(String orientation, int id, int t, String[] ts) {
            StringBuilder sb = new StringBuilder();
            this.orientation = orientation;
            this.t = t;
            for (int i = 0; i < ts.length; i++) {
                sb.append(ts[i]);
                sb.append(" ");
            }
            this.tags = sb.toString().trim();
            this.id = id;
        }
    }

    static List<Photo> horizontals;
    static List<Photo> verticals;

    static List<Integer[]> finalResult;

    public static void main(String[] args) throws Exception {
        finalResult = new ArrayList<>();
        FileInputStream fstream = new FileInputStream("/Users/omarfaroque/Life-coding/src/contest/hashcode_2019/e_shiny_selfies.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        int numOfInput = Integer.parseInt(br.readLine());
        System.out.println(numOfInput);

        horizontals = new ArrayList<>();
        verticals = new ArrayList<>();
        int i = 0;

        List<Photo> photos = new ArrayList<>();
        while (i < numOfInput) {
            String str = br.readLine();
            String[] splited = str.split(" ");
            System.out.println(str);
            if (splited[0].equalsIgnoreCase("H")) {
                Photo p = new Photo(splited[0], i, Integer.parseInt(splited[1]), Arrays.copyOfRange(splited, 2, splited.length));
                horizontals.add(p);
            } else {
                Photo p = new Photo(splited[0], i, Integer.parseInt(splited[1]), Arrays.copyOfRange(splited, 2, splited.length));
                verticals.add(p);
            }
            i++;
        }

        Collections.sort(horizontals, new TagsSimilarityComparator());
        for (Photo p : horizontals) {
            Integer[] arr = new Integer[1];
            arr[0] = p.id;
            finalResult.add(arr);

        }

        Collections.sort(verticals, new TagsSimilarityComparator());
        int it = 0;
        while (it < verticals.size()) {
            Integer[] arr = new Integer[2];
            arr[0] = verticals.get(it).id;
            if (it + 1 < verticals.size()) {
                arr[1] = verticals.get(it + 1).id;
            }
            finalResult.add(arr);
            it += 2;
        }

        System.out.println(finalResult);
//Close the input stream
        fstream.close();
        printOutput(finalResult);
    }

    private static void printOutput(List<Integer[]> finalResult) throws Exception {
        FileWriter f0 = new FileWriter("/Users/omarfaroque/Desktop/out.txt");

        String newLine = System.getProperty("line.separator");
        f0.write(String.valueOf(finalResult.size()) + newLine);



        for (int i = 0; i < finalResult.size(); i++) {
            Integer[] arr=finalResult.get(i);
            if(arr.length==1){
                f0.write(arr[0]+newLine);
            }else{
                f0.write(arr[0]+" "+arr[1]+newLine);
            }

        }

        f0.close();
      //  bw.close();

    }

    static class TagsSimilarityComparator implements Comparator<Photo> {
        public int compare(Photo p1, Photo p2) {
            return (int) similarity(p1.tags, p2.tags);
        }
    }

    public static double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2;
            shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            return 1.0; /* both strings are zero length */
        }
    /* // If you have Apache Commons Text, you can use it to calculate the edit distance:
    LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength; */
        return (int) (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }

    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }
}
