package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by mikim on 19.11.16.
 */
public class ShellSort {

    public static int[] sort(int[] ar) {
        if (ar == null) {return new int[]{}; }
        int inner, outer;
        int temp;

        int h = 1;
        while (h <= ar.length / 2) {
            h = h * 2 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < ar.length; outer++) {
                temp = ar[outer];
                inner = outer;

                while (inner > h - 1 && ar[inner - h] >= temp) {
                    ar[inner] = ar[inner - h];
                    inner -= h;
                }
                ar[inner] = temp;
            }
            h = (h - 1) / 2;
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] ar = Helper.genRandomPerm(1000);
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
