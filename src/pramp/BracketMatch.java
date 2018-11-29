package pramp;

public class BracketMatch {
    static int bracketMatch(String text) {
        int diffCounter = 0;
        int ans = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(')
                diffCounter++;
            else if (c == ')')
                diffCounter--;
            if (diffCounter < 0) {
                diffCounter++;
                ans++;
            }
        }
        return diffCounter + ans;

    }

    public static void main(String[] args) {
        String str = "(())";
        System.out.println(bracketMatch(str));

    }
}
