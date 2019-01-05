package program_creek;

import java.util.HashMap;

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomor("egg", "foo"));
    }

    private static boolean isIsomor(String egg, String foo) {
        if (egg == null) return false;
        if (foo == null || foo.length() == 0) return false;
        if (egg.length() != foo.length()) return false;

        HashMap<Character,Character> map=new HashMap<>();
        for (int i = 0; i < egg.length(); i++) {
            char c1 = egg.charAt(i);
            char c2 = foo.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2){
                    return false;
                }
            }else{
                if(map.containsKey(c2))
                    return false;
                map.put(c1,c2);
            }
        }
        return true;
    }
}
