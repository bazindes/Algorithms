package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;
import com.baz.app.util.Utils;

public class FlippingAnImage implements Google {
    public int [][] flipAndInvertImage(int [][]A){
        int [][] B = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            int index = 0;
            for (int j = A[i].length - 1; j > -1; j--) {
                if(A[i][j] == 0){
                    B[i][index++] = 1;
                }else {
                    B[i][index++] = 0;
                }
            }
        }
        return B;
    }

    public int[][] flipAndInvertImage2(int [][]A){
        int n = A.length;
        for(int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if(row[i] == row[n-i-1])
                    row[i] = row[n-i-1] ^= 1;
        return A;
    }

    public void test(){
        int[][] a = new int[3][3];
        a[0][0] = 1;
        a[0][1] = 1;
        a[0][2] = 0;
        a[1][0] = 1;
        a[1][1] = 0;
        a[1][2] = 1;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 0;

        Utils.printMatrix(a, 3, 3);
        System.out.println(" --- ");
        Utils.printMatrix(flipAndInvertImage(a) , 3 , 3);
        System.out.println(" --- ");
        Utils.printMatrix(flipAndInvertImage2(a) , 3 , 3);
    }
}
