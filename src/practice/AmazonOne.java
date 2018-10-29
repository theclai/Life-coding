package practice;

import java.util.*;

public class AmazonOne {

    public static void main(String[] args) {
        List<Integer> la=new ArrayList<>();
        List<Integer> lb=new ArrayList<>();
        List<Integer> lc=new ArrayList<>();

        la.add(1);la.add(2);
        lb.add(3);lb.add(4);
        lc.add(1);lc.add(-1);

        List<List<Integer>> data = new ArrayList<>();
        data.add(la);
        data.add(lc);
        data.add(lb);


        AmazonOne one=new AmazonOne();
        one.ClosestXdestinations(3,data,2);
    }
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries) {
        HashMap<Double,List<List<Integer>>> map;
        // Make a map with key as a distance and value is the list
        map=createMapOfDistance(allLocations);
        // Sort the map based based on distance

        Map<Double,List<List<Integer>>> sortedMap=new TreeMap<Double,List<List<Integer>>>(map);
        System.out.println(sortedMap.size());
        List<List<Integer>> output=new ArrayList<>();
        Iterator<Map.Entry<Double, List<List<Integer>>>> itr = sortedMap.entrySet().iterator();

        int iteration=0;
        while (itr.hasNext() && iteration<numDeliveries){
            Map.Entry<Double, List<List<Integer>>> entry = itr.next();
            output.addAll(entry.getValue());
            iteration+=1;
        }
        System.out.println(output.size());
        return output;
    }

    public HashMap<Double, List<List<Integer>>> createMapOfDistance(List<List<Integer>> allLocations) {
        HashMap<Double,List<List<Integer>>> map=new HashMap<>();
        allLocations.stream().forEach(list->{
            double distance=Math.pow(list.get(0),2)+Math.pow(list.get(1),2);
            System.out.println(distance);
            if(map.containsKey(distance)){
                List<List<Integer>> l = map.get(distance);
                l.add(list);
            }else{
                List<List<Integer>> newList=new ArrayList<List<Integer>>();
                newList.add(list);
                map.put(distance,newList);
            }
        });
        return map;
    }

}
