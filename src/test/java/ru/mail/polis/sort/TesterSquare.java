package ru.mail.polis.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.InsertionSort;

@RunWith(value = Parameterized.class)
public class TesterSquare {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                null,
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                Helper.genRandomPerm(1),
                Helper.genRandomPerm(10),
                Helper.genRandomPerm(100),
                Helper.genRandomPerm(1000),
                Helper.genRandomPerm(10000),
                Helper.genBackwards(1),
                Helper.genBackwards(10),
                Helper.genBackwards(100),
                Helper.genBackwards(1000),
                Helper.genBackwards(10000),
                Helper.genMaxMin(1),
                Helper.genMaxMin(10),
                Helper.genMaxMin(100),
                Helper.genMaxMin(1000),
                Helper.genMaxMin(10000),
                Helper.genHalfMax(1),
                Helper.genHalfMax(10),
                Helper.genHalfMax(100),
                Helper.genHalfMax(1000),
                Helper.genHalfMax(10000),
                Helper.genZeros(1),
                Helper.genZeros(10),
                Helper.genZeros(100),
                Helper.genZeros(1000),
                Helper.genZeros(10000),
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.sort(array)));
    }

    @Test
    public void test02_checkInsertionSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSort.sort(array)));
    }

    @Test
    public void test03_checkInsertionBinSearchSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionBinSearchSort.sort(array)));
    }

}