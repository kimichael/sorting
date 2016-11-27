
package ru.mail.polis.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void swapLongs(long[] a, int i, int j) {
        long x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] genRandomPerm(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static long[] genRandomLongs(int length){
        Random r = ThreadLocalRandom.current();
        long[] a = new long[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swapLongs(a, i, j);
        }
        return a;
    }

    public static int[] genBackwards(int n) {
        int[] a = new int[n];
        int j = n;
        for (int i = 0; i < a.length; i++){
            a[i] = j--;
        }
        return a;
    }

    public static int[] genSorted(int n){
        int[] ar = genRandomPerm(1000);
        Arrays.sort(ar);
        return ar;
    }

    public static int[] genMaxMin(int n) {
        int[] a = new int[n];
        int j = n;
        for (int i = 0; i < a.length / 2; i++){
            if (i <= a.length / 2) {
                a[i] = Integer.MAX_VALUE;
            } else {
                a[i] = Integer.MIN_VALUE;
            }
        }
        return a;
    }

    public static int[] genHalfMax(int n) {
        int[] a = new int[n];
        int j = n;
        for (int i = 0; i < a.length / 2; i++){
            if (i <= a.length / 2) {
                a[i] = Integer.MAX_VALUE;
            } else {
                a[i] = 0;
            }
        }
        return a;
    }

    public static int[] genZeros(int n){
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++){
            ar[i] = 0;
        }
        return ar;
    }

    public static int[] genSmall(int n){
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            r.nextInt(10);
        }
        return ar;
    }

    public static class RandomString {

        private static final char[] symbols;

        static {
            StringBuilder tmp = new StringBuilder();
            for (char ch = 'A'; ch <= 'Z'; ++ch)
                tmp.append(ch);
            for (char ch = 'a'; ch <= 'z'; ++ch)
                tmp.append(ch);
            symbols = tmp.toString().toCharArray();
        }

        private final Random random = new Random();

        private final char[] buf;

        public RandomString(int length) {
            if (length < 1)
                throw new IllegalArgumentException("length < 1: " + length);
            buf = new char[length];
        }

        public String nextString() {
            for (int idx = 0; idx < buf.length; ++idx)
                buf[idx] = symbols[random.nextInt(symbols.length)];
            return new String(buf);
        }

        public static String[] genStrings(int strLength, int arLength){
            RandomString rs = new RandomString(strLength);
            String[] ar = new String[arLength];
            for (int i = 0; i < arLength; i++){
                ar[i] = rs.nextString();
            }
            return ar;
        }
    }

}