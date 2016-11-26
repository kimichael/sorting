package ru.mail.polis.sort;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TesterSpecial {

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
                {Integer.MAX_VALUE, 0, 0, Integer.MAX_VALUE},
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
                Helper.genZeros(1),
                Helper.genZeros(10),
                Helper.genZeros(100),
                Helper.genZeros(1000),
                Helper.genZeros(10000),
                //No negatives!
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
    public void test01_checkQuickBinarySort() throws IOException {
        Assert.assertTrue(isSorted(QuickSortBinary.sort(array)));
    }

    @Test
    public void test02_checkMSDBinarySort() throws IOException {
        Assert.assertTrue(isSorted(MSDBinarySort.sort(array)));
    }
}

