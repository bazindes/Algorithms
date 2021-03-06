package com.baz.app.Interface.Twitter.oa;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HackerlandElection {
    private String hackerlandElection(String[] votes) {
        // create a treemap to store the value in order
        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder()); // order by value
        for (String vote : votes) {
            map.put(vote, map.getOrDefault(vote, 1) + 1);
        }

        // return
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public void test() {
        String[] votes = { "victor", "veronica", "ryan", "dave", "maria", "farah", "farah", "ryan", "veronica" };
        System.out.println(hackerlandElection(votes));
        String[] votes2 = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
        System.out.println(hackerlandElection(votes2));
    }
}
