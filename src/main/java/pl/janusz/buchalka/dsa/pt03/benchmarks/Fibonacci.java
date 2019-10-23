package pl.janusz.buchalka.dsa.pt03.benchmarks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class Fibonacci {

    private static Map<Long, Long> cache = new HashMap<>();

    public static long fib(long n) {

        long result;
        if (cache.containsKey(n)) {
            result = cache.get(n);
        } else {
            result = fibRec(n);
            cache.put(n, result);
        }

        return result;
    }

    private static long fibRec(long n) {

        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
