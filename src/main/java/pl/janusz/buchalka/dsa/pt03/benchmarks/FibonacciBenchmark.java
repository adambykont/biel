package pl.janusz.buchalka.dsa.pt03.benchmarks;

import org.openjdk.jmh.annotations.*;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class FibonacciBenchmark {

    @Benchmark
    @Warmup(iterations = 0)
    @Fork(1)
    public void measureName(Args args) {

        Fibonacci.fib(args.n);
    }

    @State(Scope.Benchmark)
    public static class Args {

        public int n = 92;
    }
}
