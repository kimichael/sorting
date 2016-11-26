package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.MSDString;
import ru.mail.polis.sort.QuickSortFixed;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikim on 26.11.16.
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MSDStringBench {

    //{Helper.genRandomPerm(1000),EightAntiQS.genQuickWorst(1000) , Helper.genBackwards(1000),Helper.genSorted(1000)};
    String[] array;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = Helper.RandomString.genStrings(50,1000);
    }

    @Benchmark
    public void measureMSDStringSort(Blackhole bh) {
        bh.consume(MSDString.sort(array));
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}