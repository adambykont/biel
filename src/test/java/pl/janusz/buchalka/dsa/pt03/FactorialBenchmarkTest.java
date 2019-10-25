package pl.janusz.buchalka.dsa.pt03;

import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@State(Scope.Thread)
public class FactorialBenchmarkTest {

    @Param({"10"})
    private int n;

    @Setup
    public void setup() {

    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measuretTailRecursion(Blackhole blackhole) throws Exception {

        long result = Factorial.factorialTailRecursive(n);
        blackhole.consume(result);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureRecursive(Blackhole blackhole) {

        long result = Factorial.factorialRecursive(n);
        blackhole.consume(result);
    }

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureIterative(Blackhole blackhole) {

        final long result = Factorial.factorialIterative(n);
        blackhole.consume(result);
    }
}