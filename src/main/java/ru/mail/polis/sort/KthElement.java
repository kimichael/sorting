package ru.mail.polis.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by mikim on 21.11.16.
 */
public class KthElement {

    public static int kthElement(int[] ar, int k) {
        if (ar == null){return -1;}
        int left = 0;
        int right = ar.length - 1;
        while (true) {
            if (left >= right)
                return ar[left];
            int mid = partition(ar, left, right);
            if (mid == k) {
                return ar[mid];
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static int partition(int[] ar, int left, int right) {
        Random rnd = new Random();
        int index = rnd.nextInt(right - left) + left;
        Helper.swap(ar, left, index);
        int x = ar[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (ar[i] <= x) {
                j++;
                Helper.swap(ar, i , j);
            }
        }
        Helper.swap(ar, left, j);
        return j;
    }
}