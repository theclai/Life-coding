package coderbyte;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrettyJSON {
    public static void main(String[] args) {
        pretty("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
    }

    private static void pretty(String jsonStr) {
        if(jsonStr == null || jsonStr.trim().length() == 0){
            System.out.println(jsonStr);
            return;
        }
        final String ret = "\n";
        StringBuilder formattedJson = new StringBuilder();
        StringBuilder spaces = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<jsonStr.length(); ){
            char c = jsonStr.charAt(i);
            switch(c){
                case '{':
                case '[':
                    stack.push(c);
                    spaces.append("\t");
                    formattedJson.append(c).append(ret).append(spaces);
                    i++;
                    break;
                case '}':
                case ']':
                    stack.pop();
                    spaces.deleteCharAt(spaces.length()-1);
                    formattedJson.append(ret).append(spaces).append(c);
                    i++;
                    if(!(i<jsonStr.length() && jsonStr.charAt(i) == ',')){
                        formattedJson.append(ret).append(spaces);
                    }
                    break;
                case ',':
                    formattedJson.append(c).append(ret).append(spaces);
                    i++;
                    break;
                default:
                    formattedJson.append(c);
                    i++;
                    break;
            }
        }
        System.out.println(formattedJson);

    }
}
