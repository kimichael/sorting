package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.InsertionBinSearchSort;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class InsertionBinSearchBench {

    //{Helper.genRandomPerm(1000),Helper.genBackwards(1000),Helper.genSorted(1000)};
    int[] array;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = Helper.genSorted(1000);
    }

    @Benchmark
    public void measureInsertionBinSearchSort(Blackhole bh) {
        bh.consume(InsertionBinSearchSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionBinSearchBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
