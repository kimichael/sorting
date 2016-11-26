package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by mikim on 19.11.16.
 */
public class InsertionBinSearchSort {

    public static int[] sort(int ar[]) {
        if (ar == null) {return new int[]{}; }
        int ins, i, j;
        int temp;

        for (i = 1; i < ar.length; i++) {
            ins = binSearch(ar, ar[i], -1, i);
            temp = ar[i];
            for (j = i - 1; j >= ins; j--)
                ar[j + 1] = ar[j];
            ar[ins] = temp;
        }
        return ar;
    }


    public static int binSearch(int[] ar, int elem, int l, int r){
        while (l < r - 1){
            int m = (l + r) / 2;
            if (ar[m] > elem) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] ar = Helper.genRandomPerm(1000);
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}