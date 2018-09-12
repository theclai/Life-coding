package leetcode;

public class OverlapRectangle {
    /**
     * Point for rectangle
     * (A,B): (-3,0)
     * (C,D): (3,4)
     *
     * (E,F):(0,-1)
     * (G,H):(9,2)
     */
    public int computeArea(int A, int B,
                           int C, int D,
                           int E, int F,
                           int G, int H) {
        int wx=Math.abs(A-C);
        int hx=Math.abs(B-D);
        int ax=wx*hx;
        System.out.println(ax);

        int wy=Math.abs(E-G);
        int hy=Math.abs(F-H);
        int ay=wy*hy;
        System.out.println(ay);
        int ao;
        if(ax==0 || ay==0){
            ao=0;
        }else{
            int wo=Math.abs(C-E);
            int wh=Math.abs(H-B);
            ao=wo*wh;
        }


        System.out.println(ao);
        int overlap=(ax+ay)-ao;
        System.out.println(overlap);
        return overlap;

    }

}
