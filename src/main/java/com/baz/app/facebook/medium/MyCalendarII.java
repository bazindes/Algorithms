package com.baz.app.facebook.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {

    TreeMap<Integer, Integer> map;
    public MyCalendarII() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            count += entry.getValue();
            if(count > 2){
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0){
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0){
                    map.remove(end);
                }
                return false;
            }
        }

        return true;
    }

    public void test(MyCalendarII myCalendar){
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(50, 60)); // returns true
        System.out.println(myCalendar.book(10, 40)); // returns true
        System.out.println(myCalendar.book(5, 15)); // returns false
        System.out.println(myCalendar.book(5, 10)); // returns true
        System.out.println(myCalendar.book(25, 55)); // returns true
    }
}
