package practice;
import java.util.*;
public class MapIterations {
    public static void main(String[] args){
        Map<String,String> map=new HashMap<String,String>();
        map.put("Omar","Asma");
        map.put("Faroque","Lucky");
        map.put("Anik","Zinnat");
        map.put("Pagla","Asma");

        map.forEach((key,val)->{
            System.out.println("KEY: "+key+" VALUE: "+val);
        });

        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(i->System.out.println(i));
    }

}
