package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum implements Facebook {

    /**
     * Given a list of non-negative numbers and a target integer k,
     * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
     * that is, sums up to n*k where n is also an integer.
     *
     * Example 1:
     * Input: [23, 2, 4, 6, 7],  k=6
     * Output: True
     * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     * Example 2:
     * Input: [23, 2, 6, 4, 7],  k=6
     * Output: True
     * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     * Note:
     * The length of the array won't exceed 10,000.
     * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
     */

    /**
     * We iterate through the input array exactly once, keeping track of the running sum mod k of the elements in the process.
     * If we find that a running sum value at index j has been previously seen before in some earlier index i in the array,
     * then we know that the sub-array (i,j] contains a desired sum.
     */

    // O(n) O(k)
    public boolean checkSubarraySum(int[] nums, int k) {
        // corner case
        if(nums == null || nums.length == 0) return 0 == k;

        // use map to track sums of previous sub-arrays
        // key is sum of running sub-array, value is the current index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // add current value to sum
            sum += nums[i];
            // calculate target sum
            if(k != 0)
                sum %= k;
            // try to get target sum
            Integer prev = map.get(sum);
            // if there is one
            if(prev != null){
                // at least two elements
                if(i - prev > 1) return true;
            }else {
                // if not seen previously, put it into map
                map.put(sum, i);
            }
        }
        return false;
    }

    public void test(){
        int[]nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums, 6));
    }

}
