package pl.janusz.buchalka.dsa.pt03.benchmarks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
@State(Scope.Thread)
public class SplitingTest {

    private String text;
    private String regexp;
    private Pattern pattern;

    @Setup
    public void setUp() throws Exception {

        this.text = "foo=bar";
        regexp = "==";
        pattern = Pattern.compile(regexp);
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Fork(1)
    public void usePattern(Blackhole blackhole) {

        final String[] split = pattern.split(text);
        blackhole.consume(split);
    }

    @Benchmark
    @Warmup(iterations = 1)
    @Fork(1)
    public void oldWayNonPattern(Blackhole blackhole) {

        final String[] split = text.split(regexp);
        blackhole.consume(split);
    }
}