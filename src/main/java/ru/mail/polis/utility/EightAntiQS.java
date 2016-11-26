package ru.mail.polis.utility;

import ru.mail.polis.sort.Helper;

import java.util.Scanner;

public class EightAntiQS {

    public static int[] genQuickWorst(int n){
        int[] ar = Helper.genSorted(n);
        antiQuickSort(ar);
        return ar;
    }

    public static void antiQuickSort(int[] ar)
    {
        for (int i = 2; i < ar.length;i++)
            swap(ar, i, i/2);
    }

    public static void swap(int[] ar, int i, int j){
        int temp = ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }

}