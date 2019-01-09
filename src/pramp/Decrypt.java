package pramp;

public class Decrypt {
    static String decrypt(String word) {
        char a = 'a';
        int aVal = (int) a;

        char z = 'z';
        int zVal = (int) z;

        if (word == null || word.length() == 0) return "";

        int len = word.length();
        int[] msg = new int[len];

        for (int i = 0; i < len; i++) {
            msg[i] = (int) word.charAt(i);
        }

        for (int i = 0; i < len; i++) {
            if (i == 0)
                msg[i] = msg[i] + 1;
            else
                msg[i] = msg[i - 1] + msg[i];
        }

        for (int i = 0; i < len; i++) {
            int val = msg[i];
            boolean flag = true;
            while (flag) {
                if (val >= aVal && val <= zVal) {
                    msg[i] = val;
                    flag = false;
                } else {
                    val = val - 26;
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append((char) msg[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        char a = 'a';
        int aVal = (int) a;
        System.out.println(aVal);

        char z = 'z';
        int zVal = (int) z;

        System.out.println(zVal);

        System.out.println(decrypt("crime"));
    }

}
