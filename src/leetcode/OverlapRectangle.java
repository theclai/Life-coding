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
        int areaSum = (C-A)*(D-B) + (G-E)*(H-F);

        if(E>=C || A>=G || B>=H || F>=D){
            return areaSum;
        }
        int bX = Math.max(A, E);
        int bY = Math.max(B, F);
        int tX = Math.min(C, G);
        int tY = Math.min(D, H);
        int areaIntersect = (tX-bX)*(tY-bY);

        return areaSum - areaIntersect;

    }

}
