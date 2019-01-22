# Life-coding
Solve one problem everyday. 

All of my daily problem solving lives in this repo. Some of the wrong 
attempt is also here. If you follow this repo, make sure you run the code and try
with test cases. 

## Resources
1. Cracking the coding interview book
2. https://www.geeksforgeeks.org/
3. https://www.interviewbit.com/practice/
4. https://start.interviewing.io/dashboard/interviewee
5. https://leetcode.com/
6. https://www.coursera.org/
7. https://code.google.com/codejam/kickstart/
8. https://www.pramp.com/dashboard
9. https://www.youtube.com/channel/UCWSYAntBbdd2SLYUqPIxo0w
10. https://www.byte-by-byte.com/
11. https://www.dailycodingproblem.com/
12. https://coderbyte.com/
13. https://www.interviewcake.com
14. https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/
15. https://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/
## Helper materials: 

Tree:
    
   1. Segment Tree: https://www.youtube.com/watch?v=Oq2E2yGadnU
   2. AVL Tree: https://www.youtube.com/watch?v=-9sHvAnLN_w
   
## Java Code Beauty: 

Composition Function: http://www.deadcoderising.com/2015-09-07-java-8-functional-composition-using-compose-and-andthen/

### Quick Notes   
#### Counting character frequency in a string. 

 ```
 String s="HelloWorld";
 Map<Character, Long> map = t.chars() //converting int stream
                   .mapToObj(c -> (char) c)//int stream to character stream
                   .collect(Collectors.groupingBy(Function.identity(),// collect by group
                           Collectors.counting()));
           System.out.println(map);
  ```
 
      
#### Best way to find mid point. 
 ``` 
 M=start+(end-start)/2;//overflow error free

```
  
#### Iterating over map 
  ```
 map.entrySet().stream().forEach(entry->{
            System.out.println("Key: "+entry.getKey()+"value: "+entry.getValue());
        });
```
    
#### String counting in java 8
```$xslt
        String[] strings=new String[]{"hello","world","hello"};
        List<String> list=Arrays.asList(strings);
        Map<String, Long> map1=         list.stream().collect(groupingBy(identity(), counting()));

```        

#### Sort list of object based on property
```$xslt
 private static class Inerval {
        int start;
        int end;

        public Inerval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
     ArrayList<Inerval> list=new ArrayList<>();
     list.add(new Inerval(1,3));
     list.add(new Inerval(5,8));
     list.add(new Inerval(4,10));
     list.add(new Inerval(20,25));
     list.sort(Comparator.comparingInt(v -> v.start));
     list.stream().forEach(interval -> {
                System.out.println(interval.start+"->"+interval.end);
      });
```
#### PriorityQueue with custom comparator
```$xslt
 PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.val));
```           