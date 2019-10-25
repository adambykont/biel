package pl.janusz.buchalka.dsa.pt03;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
@State(Scope.Thread)
public class SortBenchmarkTest {

    @Param({"10", "1000", "100000"})
    public int dataSize;

    private Integer[] array;

    @Setup
    public void setUp() {

        array = new Integer[dataSize];

        for (int i = 0; i < dataSize; i++) {
            array[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void selectionSort(Blackhole blackhole) {

        SelectionSort.sort(array);
        blackhole.consume(array);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void bubbleSort(Blackhole blackhole) {

        BubbleSort.sort(array);
        blackhole.consume(array);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void insertionSort(Blackhole blackhole) {

        InsertionSort.sort(array);
        blackhole.consume(array);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void shellsort(Blackhole blackhole) {

        ShellSort.sort(array);
        blackhole.consume(array);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureMergesort(Blackhole blackhole) {

        MergeSort.sort(array);
        blackhole.consume(array);
    }
}