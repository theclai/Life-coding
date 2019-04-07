package leetcode.contests.contest_131;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamelCaseMatching {
    CamelCaseMatching camelCaseMatching;

    @BeforeEach
    public void init() {
        camelCaseMatching = new CamelCaseMatching();
    }

    @Test
    public void firstCase() {
        List<Boolean> result = camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB");
        Assertions.assertEquals(Arrays.asList(true,false,true,true,false),result);
    }

    @Test
    public void secondCase() {
        List<Boolean> result = camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa");
        Assertions.assertEquals(Arrays.asList(true,false,true,false,false),result);
    }

    @Test
    public void thirdCase() {
        List<Boolean> result = camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT");
        Assertions.assertEquals(Arrays.asList(false,true,false,false,false),result);

    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        if (queries == null || queries.length == 0 || pattern == null || pattern.length() == 0)
            return new ArrayList<>();

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String str = queries[i];
            res.add(findCamel(str, pattern));
        }

        return res;
    }

    private Boolean findCamel(String str, String pattern) {
        int i = 0;
        int j = 0;
        while (i < str.length() && j < pattern.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (Character.isLowerCase(str.charAt(i))) {
                i++;
            } else if (Character.isUpperCase(str.charAt(i))) {
                return false;
            }
        }

        if (j != pattern.length()) return false;
        if (i != str.length()) {
            while (i < str.length()) {
                if (Character.isUpperCase(str.charAt(i)))
                    return false;
                else
                    i++;
            }
        }
        return true;
    }

}
