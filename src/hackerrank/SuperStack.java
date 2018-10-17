package hackerrank;

import java.util.LinkedList;

public class SuperStack {
   // static ;
    public static void main(String[] args) {
        //stack=new LinkedList<>();
        String[] operations=new String[]{"push 4","pop","push 3","push 5","push 2","inc 3 1",
                "pop","push 1","inc 2 2"};
        superStack(operations);
    }

    private static void superStack(String[] operations) {
        LinkedList<Integer> stack=new LinkedList<>();
        for (String str:operations) {
            String[] splited = str.split("\\s+");
            int pushValue;
            int levelDown;
            int incr;
            if(splited.length==1){
                stack.removeFirst();
                if(stack.size()==0)
                    System.out.println("EMPTY");
                else
                    System.out.println(stack.getFirst());
            }else if(splited.length==2){
                pushValue=Integer.parseInt(splited[1]);
                stack.addFirst(pushValue);
                System.out.println(stack.getFirst());
            }else if(splited.length==3){
                levelDown=Integer.parseInt(splited[1]);
                incr=Integer.parseInt(splited[2]);

                if(levelDown<=stack.size()){
                    // increment bottom "level down element"
                    while(levelDown!=0){
                        int targetPosition=stack.size()-levelDown;
                        int oldVal=stack.get(targetPosition);
                        stack.add(targetPosition,oldVal+incr);
                        //remove immediate next
                        stack.remove(targetPosition+1);
                        levelDown--;
                    }
                }
                System.out.println(stack.getFirst());
            }
        }

    }
}
