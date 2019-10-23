package pl.janusz.buchalka.dsa.pt03;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class BubbleSort {

    public static void sort(Integer[] array) {

        int sortedIdx = array.length;
        boolean shouldSortRunAgain = true;

        while (!(!shouldSortRunAgain || sortedIdx <= 0)) {
            shouldSortRunAgain = false;
            for (int i = 0; i < sortedIdx - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    shouldSortRunAgain = true;
                }
            }
            sortedIdx--;
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void bubbleSortBenchmark(Data data) {

        BubbleSort.sort(data.array);
    }

    @State(Scope.Benchmark)
    public static class Data {

        public Integer[] array = prepareArray();

        private Integer[] prepareArray() {

            final Integer SIZE = 100_000;
            array = new Integer[SIZE];
            for (Integer i = 0; i < SIZE; i++) {
                array[i] = ThreadLocalRandom.current().nextInt(16 * SIZE);
            }

//            Arrays.sort(array);

            return array;
        }
    }
}
