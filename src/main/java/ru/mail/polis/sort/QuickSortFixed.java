package ru.mail.polis.sort;

/**
 * Created by mikim on 21.11.16.
 */
public class QuickSortFixed {

    public static int[] sort(int[] ar){
        if (ar == null) {return new int[]{};}
        sort(ar, 0, ar.length - 1);
        return ar;
    }

    public static int[] sort(int[] ar, int l, int r) {

        if (l < r) {
            int index = partition(ar, l, r);
            sort(ar, l, index);
            sort(ar, index + 1, r);
        }
        return ar;
    }

    public static int partition(int[] ar, int l, int r){
        int pivot = ar[l + (r - l + 1) / 2];
        int i = l, j = r;
        while (i <= j){
            while (ar[i] < pivot) i++;
            while (ar[j] > pivot) j--;
            if (i <= j) swap(ar, i++, j--);
        }
        return j;
    }

    public static void swap(int[] ar, int i, int j){
        int temp = ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }
}
