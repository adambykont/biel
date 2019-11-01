package pl.janusz.buchalka.dsa.pt04;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
@State(Scope.Benchmark)
public class VectorArrayLinkedlistBenchmark {

    @Param({"1000", "10000"})
    private int size;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private Vector<Integer> vector;

    @Setup
    public void setup() {

        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        vector = new Vector<>();
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void arraylist(Blackhole blackhole) {

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        blackhole.consume(arrayList);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void linkedlist(Blackhole blackhole) {

        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        blackhole.consume(linkedList);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void vector(Blackhole blackhole) {

        for (int i = 0; i < size; i++) {
            vector.add(i);
        }
        blackhole.consume(vector);
    }
}
