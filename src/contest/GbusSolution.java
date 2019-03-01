package contest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GbusSolution {
    public static void main(String[] args){
        readInput("/Users/omarfaroque/Life-coding/src/kickstart/input_gbus.txt");
    }

    private static void readInput(String s) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(s), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("someting");

    }
}
