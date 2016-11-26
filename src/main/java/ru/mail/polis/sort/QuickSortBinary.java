package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by mikim on 21.11.16.
 */
public class QuickSortBinary {

    private static final int INT_BINARY_LENGTH = 31;

    public static int[] sort(int[] ar){
        if (ar == null) {return new int[] {};}
        sort(ar, 0, ar.length - 1, INT_BINARY_LENGTH);
        return ar;
    }

    static int getBit(int n, int k) {
        return (n >> k) & 1;
    }

    public static int[] sort(int[] ar, int l, int r, int bit){
        if (l < r && !(bit < 0)) {
            int index = partition(ar, l, r, bit);

            sort(ar, l, index, bit - 1);
            sort(ar, index + 1, r, bit - 1);
        }
        return ar;
    }

    public static int partition(int[] ar, int l, int r, int bit){
        int i = l;
        int j = r;
        while (i <= j){
            while (i < ar.length && getBit(ar[i], bit) == 0) i++;
            while (j > -1 && getBit(ar[j], bit) == 1) j--;
            if (i <= j) swap(ar, i++, j--);
        }
        return j;
    }

}
