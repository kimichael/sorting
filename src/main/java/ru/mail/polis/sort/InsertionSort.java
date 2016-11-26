package ru.mail.polis.sort;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;

import static ru.mail.polis.sort.Helper.swap;

public class InsertionSort {
    public static int[] sort(int[]ar){
        if (ar == null) {return new int[]{}; }
        for (int i = 1; i < ar.length; i++){
            int j = i-1;
            while (j >= 0 && ar[j] > ar[j+1]){
                swap(ar,j,j+1);
                j--;
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{0,1,1,0};
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }
}