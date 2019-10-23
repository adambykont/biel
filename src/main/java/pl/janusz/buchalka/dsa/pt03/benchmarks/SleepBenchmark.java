package pl.janusz.buchalka.dsa.pt03.benchmarks;

import org.openjdk.jmh.annotations.*;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class SleepBenchmark {

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 1)
    public void measureName(States state) throws InterruptedException {

        state.sum = state.a + state.b;
    }

    @State(Scope.Benchmark)
    public static class States {

        int a = getA();
        int b = getB();
        int sum;

        private int getA() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 7;
        }

        private int getB() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5;
        }
    }
}
