package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class PeakIndexInaMountainArray implements Google {

    public int peakIndexInMountainArray(int[] A){
        if(A == null || A.length < 4) return 0;
        int index = 0;
        int num = A[0];
        for (int i = 1; i < A.length; i++) {
            if(A[i] > num){
                num = A[i];
                index = i;
            }else break;
        }
        for (int i = A.length-1; i > index ; i--) {
            if(A[i] > num) return 0;
        }
        return index;
    }

}
