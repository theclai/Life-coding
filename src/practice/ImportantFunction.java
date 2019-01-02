package practice;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImportantFunction {
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
    }
}
