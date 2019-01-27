package leetcode.contests.contest_121;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TimeMap {
    static HashMap<String, TreeMap<Integer, String>> kv;

    @BeforeEach
    public void init() {
        kv = new HashMap<>();
    }

    public static void main(String[] args) {
    }

    public void set(String key, String value, int timestamp) {
        kv.computeIfAbsent(key, t -> new TreeMap<>()).put(timestamp, value);

    }

    public String get(String key, int timestamp) {
        if (!kv.containsKey(key)) return "";

        TreeMap<Integer, String> tree = kv.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";
    }
}
