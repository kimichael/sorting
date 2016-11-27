package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.KthElement;
import ru.mail.polis.sort.KthElementModified;
import ru.mail.polis.sort.MergeModified;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class KthOrderBench {

    int[] array;
    Random r = ThreadLocalRandom.current();

    @Setup(value = Level.Invocation)
    //{Helper.genRandomPerm(1000), MergeWorstCase.genMergeWorst(1000), Helper.genBackwards(1000),Helper.genSorted(1000)};
    public void setUpInvocation() {
        array = Helper.genSorted(1000);
    }

    @Benchmark
    public void measureKthOrder(Blackhole bh) {
        bh.consume(KthElement.kthElement(array, r.nextInt(array.length)));
    }

    @Benchmark
    public void measureKthOrderModified(Blackhole bh) {
        bh.consume(KthElementModified.kthLinear(array, 0, array.length -1, r.nextInt(array.length)));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(KthOrderBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
