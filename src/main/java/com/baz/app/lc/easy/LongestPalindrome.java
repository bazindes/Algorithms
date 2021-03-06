package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome implements Facebook {

    public int longestPalindrome(String s){
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count ++;
            }else {
                set.add(s.charAt(i));
            }
        }
        if(set.size() > 0) count = count * 2 + 1;
        else count = count * 2;
        return count;
    }

    public void test(){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

}
