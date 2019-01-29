package practice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RPTest {
    static ConcurrentHashMap<Integer, ArrayList<RP>> rel;

    static class RP {
        int parent;
        int id;
        String str;
        ArrayList<RP> child;

        public RP(int parent, int id, String str) {
            this.parent = parent;
            this.id = id;
            this.str = str;
            child = new ArrayList<>();
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        rel = new ConcurrentHashMap<>();
        List<RP> list = new ArrayList<>();
        list.add(new RP(5, 6, "A"));
        list.add(new RP(0, 1, "B"));
        list.add(new RP(1, 2, "C"));
        list.add(new RP(1, 3, "D"));
        list.add(new RP(2, 4, "E"));
        list.add(new RP(1, 5, "F"));
        list.add(new RP(1, 7, "G"));
        list.add(new RP(2, 3, "H"));


        //iterate over all data and make a map : k: int val: set
        // iterate over parents and union them


        HashMap<Integer, Integer> parents = new HashMap<>();
        Set<Integer> processed=new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            RP c = list.get(i);
            parents.put(c.id, c.parent);
            if (!rel.containsKey(c.parent)) {
                processed.add(c.parent);
                rel.computeIfAbsent(c.parent, val -> new ArrayList<>()).add(c);
            } else {
                rel.get(c.parent).add(c);
            }
        }

        System.out.println(rel);

        while (processed.size() != 1) {
            for (Map.Entry<Integer, ArrayList<RP>> entry : rel.entrySet()) {
                int key = entry.getKey();
                if (key == 0)
                    continue;
                int par = parents.get(entry.getKey());

                for (RP rp : rel.get(par)) {
                    if (rp.id == entry.getKey()) {
                        rp.child.addAll(entry.getValue());
                        processed.remove(entry.getKey());
                    }
                }


            }
        }
        System.out.println(rel.get(0));
        ArrayList<RP> l= rel.get(0);
        System.out.println(l);
    }
}
