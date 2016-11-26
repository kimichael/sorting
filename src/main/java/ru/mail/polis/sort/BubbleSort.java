package ru.mail.polis.sort;

public class BubbleSort {

    public static int[] sort(int ar[]) {
        if (ar == null) {return new int[]{}; }
        boolean wasSwap = true;
        int j = 0;
        while (wasSwap) {
            wasSwap = false;
            for (int i = 0; i < ar.length - j - 1; i++) {
                if (ar[i] > ar[i + 1]) {
                    Helper.swap(ar, i, i + 1);
                    wasSwap = true;
                }
            }
            j++;
        }
        return ar;
    }
}
