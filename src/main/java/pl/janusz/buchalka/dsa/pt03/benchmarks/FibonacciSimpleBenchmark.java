package pl.janusz.buchalka.dsa.pt03.benchmarks;

import java.text.NumberFormat;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class FibonacciSimpleBenchmark {

    public static void main(String[] args) {

        int n = 43;

        long start = System.nanoTime();
        long fib = Fibonacci.fib(n);
        long end = System.nanoTime();

        long elapsed = end - start;

        final String format = NumberFormat.getInstance().format(elapsed);
        System.out.println(format + "[ns]");
    }
}
