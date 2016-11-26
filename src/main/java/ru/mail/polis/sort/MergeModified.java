package ru.mail.polis.sort;

import static ru.mail.polis.sort.Helper.swap;

/**
 * Created by mikim on 19.11.16.
 */
public class MergeModified {

    public static int[] sort(int[] ar){
        if (ar == null) {return new int[]{};}
        sort(ar, 0, ar.length - 1);
        return ar;
    }

    static int[] sort(int[] ar, int min, int max){
        if (ar == null) {return new int[]{}; }
        if(max - min == 0){
        } else if(max - min == 1){
            if(ar[min]>ar[max])
                swap(ar, min, max);
        } else {
            int mid=((int) Math.floor((min+max)/2));

            sort(ar, min, mid);
            sort(ar, mid+1, max);
            merge(ar, min, max, mid);
        }
        return ar;
    }

    static void merge(int[] ar,int min,int max,int mid){
        int i = min;
        while(i <= mid){
            if(ar[i]>ar[mid+1]){
                swap(ar, i, mid+1);
                push(ar, mid+1, max);
            }
            i++;
        }
    }

    static void push(int[] ints,int s,int e){
        for(int i=s;i<e;i++){
            if(ints[i]>ints[i+1])
                swap(ints,i,i+1);
        }
    }
}
