package pl.janusz.buchalka.dsa.pt03.benchmarks;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class Factorial {

    public static long factorialIterative(int n) {

        long fact = 1L;

        for (long i = 0; i < n; i++) {
            fact *= (i + 1L);
        }

        return fact;
    }

    public static long factorialRecursive(int n) {

        if (n < 2) {
            return 1L;
        }

        return n * factorialIterative(n - 1);
    }

    public static long factorialTailRecursive(int n) {

        return tailRecFact(n, 1L);
    }

    private static long tailRecFact(int n, long acc) {

        if (n < 2) {
            return acc;
        }

        return tailRecFact(n - 1, n * acc);
    }
}
