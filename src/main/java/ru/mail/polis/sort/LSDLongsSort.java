package ru.mail.polis.sort;


import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LSDLongsSort {

    public static long[] sort(long[] ar) {
        if (ar == null) {return new long[] {};}
        final int R = 1 << 8;
        final int MASK = R - 1;
        final int w = 8;
        int n = ar.length;
        long[] temp = new long[n];

        for (int d = 0; d < w; d++) {
            long[] counter = new long[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (int) ((ar[i] >> 8 * d) & MASK);
                counter[(c + 1)]++;
            }

            for (int r = 0; r < R; r++)
                counter[r + 1] += counter[r];

            if (d == w - 1) {
                long shift1 = counter[R] - counter[R / 2];
                long shift2 = counter[R / 2];
                for (int r = 0; r < R / 2; r++)
                    counter[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    counter[r] -= shift2;
            }

            for (int i = 0; i < n; i++) {
                int c = (int) ((ar[i] >> 8 * d) & MASK);
                temp[(int) counter[c]++] = ar[i];
            }

            for (int i = 0; i < n; i++)
                ar[i] = temp[i];
        }
        return ar;
    }

}
