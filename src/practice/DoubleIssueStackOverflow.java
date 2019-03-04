package practice;

import org.junit.jupiter.api.Test;

public class DoubleIssueStackOverflow {

    @Test
    public void test_first(){
        TraceClass traceObj = new TraceClass(1.75);

        traceObj.doIt(true);
        double temp = traceObj.getValAfter();
        System.out.println("Result is " + temp);

        traceObj.doIt(false);
        temp = traceObj.getValAfter();
        System.out.println("Result is " + temp);

    }
    public class TraceClass {
        private double valBefore;
        private double valAfter;

        public TraceClass(double valIn) {
            this.valBefore = valIn;
            this.valAfter = 0.0;
        }

        public void doIt(boolean which) {
            if (which == true) {
                this.valAfter = this.valBefore + .5;
            } else {
                this.valAfter = this.valBefore + .5;
            }
        }

        public double getValAfter() {
            return this.valAfter;
        }
    }

}