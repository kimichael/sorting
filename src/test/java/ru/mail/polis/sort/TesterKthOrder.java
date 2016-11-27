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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(value = Parameterized.class)
public class TesterKthOrder {

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
                Helper.genHalfMax(1),
                Helper.genHalfMax(10),
                Helper.genHalfMax(100),
                Helper.genHalfMax(1000),
                Helper.genZeros(1),
                Helper.genZeros(10),
                Helper.genZeros(100),
                Helper.genZeros(1000),
        });
    }

    @Test
    public void test01_checkKthOrder() throws IOException {
        Random r = ThreadLocalRandom.current();
        int position = r.nextInt(array.length);
        int k = KthElement.kthElement(array, position);
        Arrays.sort(array);
        Assert.assertEquals(k, array[position]);

    }

    @Test
    public void test02_checkKthOrderModified() throws IOException {
        Random r = ThreadLocalRandom.current();
        int position = r.nextInt(array.length);
        int k = KthElementModified.kthLinear(array, 0, array.length - 1, position + 1);
        Arrays.sort(array);
        Assert.assertEquals(k, array[position]);

    }
}