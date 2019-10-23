package pl.janusz.buchalka.dsa.pt03.benchmarks;

import java.text.NumberFormat;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class FibonacciTable {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            printFib(i);
        }
    }

    private static void printFib(int n) {

        long fibonacci = Fibonacci.fib(n);
        final String formated = NumberFormat.getIntegerInstance().format(fibonacci);
        System.out.println(n + " -> " + formated);
    }
}
