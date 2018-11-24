package pramp;

import java.util.Arrays;

public class AwardBudget {
        /**
         N is the number of grants

         newBudget=total amount of budget

         all the grant higher than cap, will be down to cap

         grant<= cap wont be impacated

         188/4 = 47

         2 50 100 120 1000

         O(n) is time compexity
         O(1) is space

         len=5
         total=190

         cap= 38


         iterate over and find something <cap
         update len and update total= total-current




         sort();


         cap = total/len


         Manual test:
         2 50 100 120 1000
         len=5
         cap= 190/5= 38

         i:0 newB: 188 cap: 47


         */
        static double findGrantsCap(double[] grantsArray, double newBudget) {
            if(grantsArray.length==0)
                return 0.0;
            // your code goes here
            int len=grantsArray.length;
            double cap= newBudget/len;
            Arrays.sort(grantsArray);

            for(int i=0;i<len;i++){
                if(grantsArray[i]<=cap){
                    newBudget-=grantsArray[i];
                    cap = updateCap(newBudget,len-(i+1));
                }
                else{
                    return cap;
                }
            }
            return cap;

        }

        public static double updateCap(double budget, int len){
            return budget/len;
        }

        public static void main(String[] args) {

            double[] in=new double[]{2, 100, 50, 120, 1000};
            double budget= 190;
            System.out.println(findGrantsCap(in,budget));

        }
}
