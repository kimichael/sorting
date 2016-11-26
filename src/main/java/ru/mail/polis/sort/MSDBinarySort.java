package ru.mail.polis.sort;

/**
 * Created by mikim on 21.11.16.
 */
public class MSDBinarySort {

    public static int[] sort(int[] ar){
        if (ar == null) {return new int[]{}; }
        int[] res = new int[ar.length];
        sort(ar, res, 0, ar.length - 1, 31);
        return ar;
    }

    private static void sort(int[] a, int[] res, int left, int right, int r) {
        if (r < 0 || left >= right) return;
        int[] count = new int[32];

        for (int i = left; i <= right; i++) {
            count[digit(a[i], r)]++;
        }
        for (int i = 1; i < 32; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --count[digit(a[i], r)]] = a[i];
        }
        System.arraycopy(res, left, a, left, right - left + 1);
        for (int i = 0; i < 31; i++) {
            sort(a, res, left + count[i], left + count[i + 1] - 1, r - 1);
        }
    }

    private static int digit(int i, int r) {
        return (i >> r) & 1;
    }
}
