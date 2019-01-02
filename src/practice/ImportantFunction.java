package practice;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImportantFunction {
    static BiFunction<Integer,Integer,Integer> biFunction=(a,b)->a+b;
    static BiFunction<Integer,Integer,Boolean> compare=(a,b)->a>b?true:false;
    static BiFunction<String,String,String> concate=(x,y)->{
        String hello="Hello ";
        return hello+ x.concat(y);
    };
    public static void main(String[] args) {
        String s="i love shbanglade";
        String out=Stream.of(s.split("")).sorted().collect(Collectors.joining());
        System.out.println(out);

        ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<>();
        map.put("hell4oe",2);
        map.put("two",2);
        map.put("three",3);

        List<Integer> o= map.values().stream().filter(k-> k>=2).collect(Collectors.toList());
        System.out.println(o.size());

        // iterate over map
        map.entrySet().stream().forEach(entry->{
            System.out.println("Key: "+entry.getKey()+"value: "+entry.getValue());
        });

        int result=biFunction.apply(100,100);
        System.out.println(result);
        System.out.println(biFunction.apply(10,10));

        System.out.println(compare.apply(10,12));
        System.out.println(compare.apply(12,12));

        System.out.println(concate.apply("Asma","Faroque"));
    }
}
