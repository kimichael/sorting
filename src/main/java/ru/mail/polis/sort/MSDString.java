package ru.mail.polis.sort;

import java.util.Arrays;

public class MSDString
{
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;
    private static int charAt(String s, int d)
    {  if (d < s.length()) return s.charAt(d); else return -1;  }
    public static String[] sort(String[] ar)
    {
        if (ar == null) {return new String[]{};}
        int N = ar.length;
        aux = new String[N];
        sort(ar, 0, N-1, 0);
        return ar;
    }
    private static void sort(String[] arr, int lo, int hi, int d)
    {  // Sort from a[lo] to a[hi], starting at the dth character.
        if (hi <= lo + M)
        {  insertionSort(arr, lo, hi, d); return;  }
        int[] count = new int[R+2];        // Compute frequency counts.
        for (int i = lo; i <= hi; i++)
            count[charAt(arr[i], d) + 2]++;
        for (int r = 0; r < R+1; r++)      // Transform counts to indices.
            count[r+1] += count[r];
        for (int i = lo; i <= hi; i++)     // Distribute.
            aux[count[charAt(arr[i], d) + 1]++] = arr[i];
        for (int i = lo; i <= hi; i++)     // Copy back.
            arr[i] = aux[i - lo];
        // Recursively sort for each character value.
        for (int r = 0; r < R; r++)
            sort(arr, lo + count[r], lo + count[r+1] - 1, d+1);
    }

    public static void insertionSort(String[] a, int lo, int hi, int d)
    {  // Sort from a[lo] to a[hi], starting at the dth character.
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                swapString(a, j, j-1);
    }
    private static boolean less(String v, String w, int d)
    {  return v.substring(d).compareTo(w.substring(d)) < 0;  }

    public static void swapString(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}