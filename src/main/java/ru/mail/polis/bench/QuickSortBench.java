package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.QuickSortBinary;
import ru.mail.polis.sort.QuickSortFixed;
import ru.mail.polis.sort.QuickSortRandomThree;
import ru.mail.polis.utility.EightAntiQS;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class QuickSortBench {

    //{Helper.genRandomPerm(1000),EightAntiQS.genQuickWorst(1000) , Helper.genBackwards(1000),Helper.genSorted(1000)};
    int[] array;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = EightAntiQS.genQuickWorst(1000);
    }

    @Benchmark
    public void measureQuickBinarySort(Blackhole bh) {
        bh.consume(QuickSortBinary.sort(array));
    }

    @Benchmark
    public void measureQuickFixedSort(Blackhole bh) {
        bh.consume(QuickSortFixed.sort(array));
    }

    @Benchmark
    public void measureQuickRandomThreeSort(Blackhole bh) {
        bh.consume(QuickSortRandomThree.sort(array));
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
