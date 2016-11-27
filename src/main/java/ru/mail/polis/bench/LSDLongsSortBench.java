package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.LSDLongsSort;
import ru.mail.polis.sort.MergeModified;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LSDLongsSortBench {

    //{Helper.genRandomPerm(1000), MergeWorstCase.genMergeWorst(1000), Helper.genBackwards(1000),Helper.genSorted(1000)};
    long[] array;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = Helper.genRandomLongs(100000);
    }

    @Benchmark
    public void measureMergeModifiedSort(Blackhole bh) {
        bh.consume(LSDLongsSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDLongsSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
