package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapLearning {
    ConcurrentHashMap<String, String> smallConcurrentHashmap;
    ConcurrentHashMap<String, String> largeConcurrentHashmap;

    @BeforeEach
    public void init() {
        smallConcurrentHashmap = new ConcurrentHashMap<>();
        largeConcurrentHashmap = new ConcurrentHashMap<>();
        populateMaps(smallConcurrentHashmap, largeConcurrentHashmap);
    }

    @Test
    public void iterate() {
        System.out.println("*************** Testing Iteration ***************");
        smallConcurrentHashmap.forEach((k, v) -> {
            System.out.print("Key: " + k);
            System.out.println(" Value: " + v);
        });
    }

    @Test
    public void computeIfAbsent() {
        System.out.println("*************** Testing ComputeIfAbsent ***************");
        smallConcurrentHashmap.computeIfAbsent("Travis", v -> "Koenig");
        smallConcurrentHashmap.forEach((k, v) -> {
            System.out.print("Key: " + k);
            System.out.println(" Value: " + v);
        });
    }

    @Test
    public void computeIfPresent() {
        smallConcurrentHashmap.computeIfAbsent("Travis", v -> "Koenig");
        System.out.println("*************** Testing ComputeIfPresent ***************");
        smallConcurrentHashmap.computeIfPresent("Travis",(k,v)->v.concat("VP"));
        smallConcurrentHashmap.forEach((k, v) -> {
            System.out.print("Key: " + k);
            System.out.println(" Value: " + v);
        });
    }

    private void populateMaps(ConcurrentHashMap<String, String> smallConcurrentHashmap, ConcurrentHashMap<String, String> largeConcurrentHashmap) {
        populate(smallConcurrentHashmap);
        populate(largeConcurrentHashmap);
        addMore(largeConcurrentHashmap);
    }

    private void populate(ConcurrentHashMap<String, String> map) {
        map.put("Omar", "Faroque");
        map.put("Asam", "Akter");
        map.put("Taslima", "Eshika");
    }

    private void addMore(ConcurrentHashMap<String, String> map) {
        map.put("James", "Bond");
        map.put("Michael", "Jackson");
    }
}
