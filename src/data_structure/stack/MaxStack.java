package data_structure.stack;

import java.util.LinkedList;

public class MaxStack {
    static LinkedList list;
    static MaxData curMax;
    private static class MaxData{
        int data;
        MaxData prevMax;

        public MaxData(int data) {
            this.data = data;
        }

        public void setPrevMax(MaxData data){
            this.prevMax=data;
        }
    }

    public static void main(String[] args) {
        list = new LinkedList();
        push(1);
        push(2);
        push(3);

        System.out.println(pop());
        //System.out.println(pop());
        System.out.println(max());

        System.out.println(pop());
        //System.out.println(pop());
        System.out.println(max());

    }

    public static void push(int data) {
        list.push(data);
        if(curMax==null){
            curMax=new MaxData(data);
        }
        if(data>curMax.data){
            MaxData temp=curMax;
            curMax=new MaxData(data);
            curMax.prevMax=temp;
        }
    }

    public static int pop() {
        int pooped = (int) list.getFirst();
        if(pooped==curMax.data){
            curMax=curMax.prevMax;
        }
        list.removeFirst();
        return pooped;
    }

    public static int max() {
        return curMax.data;

    }
}
