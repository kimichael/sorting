package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/19/16.
 */
public class KthElementModified {

    private static int findMedian(int arr[], int left, int right) {
        sort(arr, left, right);
        return ((right + left) % 2 == 0) ? arr[(left + right - 1) / 2] : arr[(left + right) / 2];
    }

    public static int kthLinear(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1;
            int i;
            int[] medians = new int[(n + 4) / 5];

            for (i = 0; i < n / 5; i++) {
                int m = l + 5 * i;
                medians[i] = findMedian(arr, m, m + 5);
            }

            if (i * 5 < n) {
                int m = l + i * 5;
                medians[i] = findMedian(arr, m, m + n % 5);
                i++;
            }

            int medOfMed = (i == 1)? medians[i-1]: kthLinear(medians, 0, i - 1, i / 2);
            int pos = partition(arr, l, r, medOfMed);

            if (pos-l == k-1) {
                return arr[pos];
            }

            if (pos-l > k-1) {
                return kthLinear(arr, l, pos - 1, k);
            }
            return kthLinear(arr, pos+1, r, k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }

    private static void sort(int[] ar, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            for (int j = i; j > left && ar[j] < ar[j - 1]; j--) {
                Helper.swap(ar, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{4,5,67,3,5,7};
        for (int i = 0; i < ar.length; i++){
            kthLinear(ar, 0, ar.length - 1, i);
        }
        System.out.println(Arrays.toString(ar));
    }

    private static int partition(int[] arr, int l, int r, int x) {
        int i;
        for (i = l; i < r; i++) {
            if(arr[i] == x) {
                break;
            }
        }
        Helper.swap(arr, i, r);

        i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                Helper.swap(arr, i, j);
                i++;
            }
        }
        Helper.swap(arr, i, r);
        return i;
    }
}