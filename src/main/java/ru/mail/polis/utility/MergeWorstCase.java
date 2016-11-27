package ru.mail.polis.utility;

import ru.mail.polis.sort.Helper;

public class MergeWorstCase {

    public static int[] genMergeWorst(int n){
        int ar[]= Helper.genSorted(n);
        separate(ar);
        return ar;
    }

    public static void print(int arr[])
    {
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void merge(int[] arr, int[] left, int[] right) {
        int i,j;
        for(i=0;i<left.length;i++)
            arr[i]=left[i];
        for(j=0;j<right.length;j++,i++)
            arr[i]=right[j];
    }

    public static void separate(int[] arr) {

        if(arr.length<=1)
            return;

        if(arr.length==2)
        {
            int swap=arr[0];
            arr[0]=arr[1];
            arr[1]=swap;
            return;
        }

        int i,j;
        int m = (arr.length + 1) / 2;
        int left[] = new int[m];
        int right[] = new int[arr.length-m];

        for(i=0,j=0;i<arr.length;i=i+2,j++)
            left[j]=arr[i];

        for(i=1,j=0;i<arr.length;i=i+2,j++)
            right[j]=arr[i];

        separate(left);
        separate(right);
        merge(arr, left, right);
    }
    public static void main(String args[])
    {
        int arr1[]= Helper.genSorted(1000);
        separate(arr1);
        System.out.print("For array 1:");
        print(arr1);
    }
}