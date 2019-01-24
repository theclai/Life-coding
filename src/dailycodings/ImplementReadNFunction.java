package dailycodings;

import java.util.ArrayList;
import java.util.List;

public class ImplementReadNFunction {
    public String read7() {
        return "7 characters";
    }

    public List<String> readN(int n) {
        List<String> strs = new ArrayList<>();
        int total=0;
        String str = read7();
        total+=str.length();
        strs.add(str);
        while (str.length() == 7 && total<n) {
            str = read7();
            total+=str.length();
            if (str != "")
                strs.add(str);
        }
        return strs;
    }
}
