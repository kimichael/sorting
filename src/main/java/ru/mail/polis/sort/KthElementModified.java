package ru.mail.polis.sort;

/**
 * Created by iters on 11/19/16.
 */
public class KthElementModified {

    private static int findMedian(int ar[], int left, int right) {
        sort(ar, left, right);
        return ((right + left) % 2 == 0) ? ar[(left + right - 1) / 2] : ar[(left + right) / 2];
    }

    public static int kthLinear(int[] ar, int left, int right, int k) {
        if (k > 0 && k <= right - left + 1) {
            int n = right - left + 1;
            int i;
            int[] medians = new int[(n + 4) / 5];

            for (i = 0; i < n / 5; i++) {
                int m = left + 5 * i;
                medians[i] = findMedian(ar, m, m + 5);
            }

            if (i * 5 < n) {
                int m = left + i * 5;
                medians[i] = findMedian(ar, m, m + n % 5);
                i++;
            }

            int medOfMed = (i == 1)? medians[i-1]: kthLinear(medians, 0, i - 1, i / 2);
            int pos = partition(ar, left, right, medOfMed);

            if (pos-left == k-1) {
                return ar[pos];
            }

            if (pos-left > k-1) {
                return kthLinear(ar, left, pos - 1, k);
            }
            return kthLinear(ar, pos+1, right, k-pos+left-1);
        }
        return -1;
    }

    private static void sort(int[] ar, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            for (int j = i; j > left && ar[j] < ar[j - 1]; j--) {
                Helper.swap(ar, j, j - 1);
            }
        }
    }

    private static int partition(int[] ar, int l, int r, int x) {
        int i;
        for (i = l; i < r; i++) {
            if(ar[i] == x) {
                break;
            }
        }
        Helper.swap(ar, i, r);

        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (ar[j] <= x) {
                Helper.swap(ar, i, j);
                i++;
            }
        }
        Helper.swap(ar, i, r);
        return i;
    }
}