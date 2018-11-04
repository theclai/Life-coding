package leetcode;

/**
 *
 * */
public class KthSymbolInGrammer {
    /**
     * 0
     * o1
     * <p>
     * <p>
     * 0
     * 01
     * o110
     * 01 10 10 01
     *
     * 0110 1001 0110 0110
     */
    public static void main(String[] args) {
        int N = 30;
        int K = 434991989;
        System.out.println(kthGrammar(N, K));
    }

    public static int kthGrammar(int N, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        StringBuilder s;
        while (count < N) {
            if (count == 0) {
                sb.append('0');
            } else {
                s = new StringBuilder();
                for (int i = 0; i < sb.length(); i++) {
                    if (sb.charAt(i) == '0') {
                        s.append('0');
                        s.append('1');
                    } else {
                        s.append('1');
                        s.append('0');
                    }
                }
                sb.setLength(0);
                if(s.length()>=K)
                    sb.append(s.substring(0,K));
                else
                    sb.append(s);
                s.setLength(0);
            }
            count++;
        }
        return Integer.parseInt(String.valueOf(sb.charAt(K - 1)));
    }

}

