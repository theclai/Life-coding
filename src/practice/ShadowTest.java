package practice;

public class ShadowTest {
    public int x = 0;

    class FirstLevel {
        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x =  "+x);// This is from the method param
            System.out.println("this.x = "+ this.x); //member variable of the inner class
            System.out.println("ShadowTest.this.x = "+ShadowTest.this.x); // member variable of the outer class
        }
    }

    public static void main(String[] args) {
        ShadowTest st=new ShadowTest();
        ShadowTest.FirstLevel fl=st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
