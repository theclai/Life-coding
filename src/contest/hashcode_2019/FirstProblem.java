package contest.hashcode_2019;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstProblem {

    static class Photo {
        String orientation;
        int t;
        List<String> tags;

        public  Photo(String orientation, int t, String[] ts) {
            tags = new ArrayList<>();
            this.orientation = orientation;
            this.t = t;
            for (int i = 0; i < ts.length; i++) {
                tags.add(ts[i]);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fstream = new FileInputStream("/Users/omarfaroque/Life-coding/src/contest/hashcode_2019/a_example.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        int numOfInput = Integer.parseInt(br.readLine());
        System.out.println(numOfInput);

        int i = 0;

        List<Photo> photos = new ArrayList<>();
        while (i < numOfInput) {
            String str = br.readLine();
            String[] splited = str.split(" ");
            System.out.println(str);
            Photo p = new Photo(splited[0], Integer.parseInt(splited[1]), Arrays.copyOfRange(splited, 2, splited.length));
            photos.add(p);
            i++;
        }

//Close the input stream
        fstream.close();
    }
}
