package pl.janusz.buchalka.dsa.pt04;

import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@State(Scope.Thread)
public class ListsBenchmark {

    private List<Integer> arrayList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();

    @Param({"1000", "10000"})
    private int size;

    @Setup
    public void setup() {

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void addToTheMiddleArrayList(Blackhole blackhole) throws Exception {

        for (int i = 0; i < size; i++) {
            final int halfCurrentSize = arrayList.size() / 2;
            arrayList.add(halfCurrentSize, i);
        }

        blackhole.consume(arrayList);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void addToTheMiddleLinkedList(Blackhole blackhole) throws Exception {

        for (int i = 0; i < size; i++) {
            final int halfCurrentSize = linkedList.size() / 2;
            linkedList.add(halfCurrentSize, i);
        }

        blackhole.consume(linkedList);
    }
}