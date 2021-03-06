package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class StringComparetor implements Facebook {

    /**
     *
     * 第二题是给两个字符串，比较字符串大小，返回字符串比较小的那个数。
     * 定义的比较规则是：a < b < c < d < ... < z < 0 < 1 < 2 < 100...如果两个字符串当前的字符串均为char，则根据a <b < c <...z来比较，
     * 如果当前字符是数字，则应该抽象出所有数字比较数字大小；
     * e,g1: str1 : a17; str2: a7 返回的str2, 因为a == a and 17 > 7;
     * eg2: ac < ad(c < d) ; e.g.3: a12 > ad(12 > d);
     * (数字总是大于字母），连续出现的数字应该作为一体，也不知道这样解释大家听得懂的啦~听不懂再问
     * a07 == a7(a == a; 07 == 7);
     *
     * case1: str1.charAt(i) && str.charAt(j)都是char，直接比较大小;
     * case2：str1.charAt(i)是数字，str2.charAt(j)是字母，直接返回str2;
     * case3: str1.charAt(i)是字母，str2.charAt(j)是数字，直接返回str1；. 留学申请论坛-一亩三分地
     * case4: str1.charAt(i)是数字,str.charAt(j)是数字，抽出来俩数字，比较大小；
     * 面试官的意思就是在当前字符下能够比较出大小，就直接返回小的字符串，不用再继续下去了~
     */

    //O(min(m,n)) O(1)
    // if s1 greater return 1, s2 greater return -1, equal return 0
    public int compare(String s1, String s2) {
        // null would be put as last
        if (s1 == null && s2 == null) return 0;
        if (s1 == null || s2 == null) return s1 == null ? 1 : -1;

        // use two pointers tracking chars of both input strings
        int i = 0;
        int j = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while (i < len1 && j < len2) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            // both are number, we need move two pointers same time and calculate the value
            if (Character.isDigit(c1) && Character.isDigit(c2)) {
                int val1 = 0, val2 = 0;
                // calculate continuous digits
                while (i < len1 && Character.isDigit(s1.charAt(i))) {
                    // assume no overflow
                    val1 = val1 * 10 + (s1.charAt(i) - '0');
                    i++;
                }
                while (j < len2 && Character.isDigit(s1.charAt(j))) {
                    // assume no overflow
                    val2 = val2 * 10 + (s2.charAt(j) - '0');
                    j++;
                }
                if (val1 < val2) return -1;
                if (val1 > val2) return 1;
            } else {
                // otherwise one of them are char, so just compare its ASCII value
                if (c1 < c2) return -1;
                if (c2 > c1) return 1;
                i++;
                j++;
            }
        }

        // if all chars are same and both pointers reach the end of strings
        if (i == len1 && j == len2) return 0;
        // other wise, the longer one is bigger
        return i == len1 ? -1 : 1;
    }

    public void test(){
        String s = "aaa009";
        String p = "aaa10";
        System.out.println(compare(s, p));
        s = "aaa009";
        p = "aaa010";
        System.out.println(compare(s, p));
        s = "aaa";
        p = "aab";
        System.out.println(compare(s, p));
        s = "a";
        p = "b";
        System.out.println(compare(s, p));
    }

}
