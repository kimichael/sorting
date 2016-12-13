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

//@RunWith(value = Parameterized.class)
public class TesterMSDString {
//
//    @Rule
//    public TestRule watcher = new TestWatcher() {
//        protected void starting(final Description description) {
//            System.err.println("=== Running " + description.getMethodName());
//        }
//    };
//
//    @Parameterized.Parameter
//    public String[] array;
//
//    @Parameterized.Parameters
//    public static Collection<String[]> data(){
//        return Arrays.asList(new String[][]{
//                Helper.RandomString.genStrings(200,1000)});
//    }
//
//    private boolean isSorted(String[] a) {
//        boolean isSorted = true;
//        for (int i = 0; i < a.length - 1 && isSorted; i++) {
//            isSorted = a[i].compareTo(a[i]+1) <= 0;
//        }
//        return isSorted;
//    }
//
//    @Test
//    public void test01_checkMSDString() throws IOException {
//        Assert.assertTrue(isSorted(MSDString.sort(Helper.RandomString.genStrings(200,10000))));
//    }
}