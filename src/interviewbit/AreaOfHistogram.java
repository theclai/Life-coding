package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class AreaOfHistogram {

        public int largestRectangleArea(ArrayList<Integer> A) {
            int width=1;
            if(A==null || A.size()==0)
                return 0;
            int curMax=0;
            int max=0;
            for(int i=0;i<A.size();i++){
                if(i==0)
                    curMax=A.get(i);

                int[] minBarPositionAndHeight=findMinBar(A,i);

                int pos=minBarPositionAndHeight[0];
                int val=minBarPositionAndHeight[1];

                int area=val*width;
                while(pos<i){
                    int area=A.get(pos)*i-pos;
                    pos++;
                }

                if(A.get(i)<area){
                    A.add(i,area);
                }
            }
        }

        public static int[] findMinBar(List<Integer> A, position){
            return new int[]{position,height};
        }


}
