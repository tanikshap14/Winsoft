/* Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.

For example,

Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0 
Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 } */

import java.util.Arrays;

public class first {
    public static void mergeArrays(int[] X, int[] Y) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < X.length && j < Y.length) {
            if (X[i] == 0) {
                X[k++] = Y[j++];
            } else if (X[i] < Y[j]) {
                i++;
            } else {
                for (int l = X.length - 1; l > i; l--) {
                    X[l] = X[l - 1];
                }
                X[i] = Y[j];
                i++;
                j++;
            }
        }

        while (j < Y.length) {
            X[k++] = Y[j++];
        }
    }

    public static void main(String[] args) {
        int[] X = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
        int[] Y = { 1, 8, 9, 10, 15 };

        System.out.println("Original X[]: " + Arrays.toString(X));
        System.out.println("Y[]: " + Arrays.toString(Y));

        mergeArrays(X, Y);

        System.out.println("Merged X[]: " + Arrays.toString(X));
    }
}