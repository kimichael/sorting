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
public class TesterLSDLongs {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public long[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<long[]> data() {
        return Arrays.asList(new long[][]{
                null,
                {1L, 2L, 3L, 4L},
                {4958L, 4859L, 398485L, 384859L},
                Helper.genRandomLongs(10),
                Helper.genRandomLongs(100),
                Helper.genRandomLongs(1000),
                Helper.genRandomLongs(10000),
                Helper.genRandomLongs(100000),
                Helper.genRandomLongs(1000000),
        });
    }

    private boolean isSorted(long[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkLSDLongsSort() throws IOException {
        Assert.assertTrue(isSorted(LSDLongsSort.sort(array)));
    }
}
