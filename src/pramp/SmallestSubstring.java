package pramp;

import java.util.*;

public class SmallestSubstring {

    static String getShortestUniqueSubstring(char[] arr, String str) {
        int start = 0;
        int end = 0;
        int uniqueCounter = 0;
        int patLen = arr.length;
        String result = "";
        char headChar;

        // compute the unique character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, 0);
        }

        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!map.containsKey(c))
                continue;

            int charCount = map.get(c);

            if (charCount == 0) {
                uniqueCounter = uniqueCounter + 1;
            }
            map.put(c, map.get(c) + 1);


            // push the head forward to make the length smaller
            while (uniqueCounter == patLen) {
                int tempLength = i - start + 1;
                if (tempLength == patLen)
                    return str.substring(start, i+1);

                // if current length is smaller update the result
                if (result == "" || tempLength < result.length()) {
                    result = str.substring(start, i+1);
                }
                // try to make the string smaller from beginning and check
                headChar=str.charAt(start);

                // reduce headchar counter
                if(map.containsKey(headChar)){
                    int headCount=map.get(headChar)-1;// we are reducing
                    // after removing first character, if value is zero
                    // it means unique character count should reduced
                    if(headCount==0){
                        uniqueCounter = uniqueCounter - 1;
                    }

                    // update the map
                    map.put(headChar,headCount);
                }

                // move head
                start=start+1;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "xyyzyzyx";
        char[] arr = new char[]{'x', 'y', 'z'};
        System.out.println("output" + getShortestUniqueSubstring(arr, str));
    }
}
