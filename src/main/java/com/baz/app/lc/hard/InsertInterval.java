package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval implements Facebook {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        int i = 0;
        while ( i<intervals.size() && intervals.get(i).end < newInterval.start){
            ans.add(intervals.get(i));
            i++;
        }

        while ( i<intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end)
            );
            i++;
        }

        ans.add(newInterval);
        while (i < intervals.size()){
            ans.add(intervals.get(i));
            i ++;
        }
        return ans;
    }

    public void test(){
        List<Interval> its = Arrays.asList(new Interval(1,5) );
        Interval nit = new Interval(5,7);
        insert(its , nit).forEach(i -> System.out.print(i + " "));
        System.out.println();
        its = Arrays.asList(new Interval(1,2) , new Interval(3,5), new Interval(6,7), new Interval(8,10), new Interval(12,16));
        nit = new Interval(4,8);
        insert(its , nit).forEach(i -> System.out.print(i + " "));
    }

}
