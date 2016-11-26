package ru.mail.polis.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] ar){
        if (ar == null) {return new int[]{}; }
        if (ar.length <= 1){
            return ar;
        }

        int[] first = new int[ar.length / 2];
        int[] second = new int[ar.length - first.length];
        System.arraycopy(ar, 0, first, 0, first.length);
        System.arraycopy(ar, first.length, second, 0, second.length);

        sort(first);
        sort(second);

        merge(first, second, ar);
        return ar;
    }

    public static void merge(int[] first, int[] second, int[] ar){
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length){
            if (first[i] < second[j]){
                ar[k] = first[i];
                i++;
            } else {
                ar[k] = second[j];
                j++;
            }
            k++;
        }

        System.arraycopy(first, i, ar, k, first.length - i);
        System.arraycopy(second, j, ar, k, second.length - j);
    }

    public static void main(String[] args) {
        int[] ar = Helper.genRandomPerm(1000);
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
