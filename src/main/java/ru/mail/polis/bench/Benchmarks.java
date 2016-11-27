package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Benchmarks {

    int[] array;

    @Setup(value = Level.Invocation)
    /**{Helper.genRandomPerm(1000), MergeWorstCase.genMergeWorst(1000),
     Helper.genBackwards(1000),Helper.genSorted(1000)};*/
    public void setUpInvocation() {
        array = Helper.genRandomPerm(1000);
    }

    @Benchmark
    public void measureMergeSort(Blackhole bh) {
        bh.consume(MergeSort.sort(array));
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

    @Benchmark
    public void measureBubbleSort(Blackhole bh) {
        bh.consume(BubbleSort.sort(array));
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(InsertionSort.sort(array));
    }

    @Benchmark
    public void measureInsertionBinSearchSort(Blackhole bh) {bh.consume(InsertionBinSearchSort.sort(array));}

    @Benchmark
    public void measureMergeModifiedSort(Blackhole bh) {
        bh.consume(MergeModified.sort(array));
    }

    @Benchmark
    public void measureMSDBinary(Blackhole bh) {
        bh.consume(MSDBinarySort.sort(array));
    }

    @Benchmark
    public void measureShellSort(Blackhole bh) {
        bh.consume(ShellSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmarks.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}