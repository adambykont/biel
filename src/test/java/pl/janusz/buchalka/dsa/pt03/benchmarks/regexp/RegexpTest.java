package pl.janusz.buchalka.dsa.pt03.benchmarks.regexp;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class RegexpTest {

    @Test
    public void name() {

        Pattern pattern = Pattern.compile("\\d{2}..");
        String text = "12ab";
        Matcher matcher = pattern.matcher(text);
        final boolean matches = matcher.matches();
        assertThat(matches, is(true));
    }

    @Test
    public void givenText_whenSimpleRegexMatchesTwice_thenCorrect() {

        final String foo = "foo";
        final Pattern pattern = Pattern.compile(foo);
        final Matcher matcher = pattern.matcher("foofoo");
        int matched = 0;
        while (matcher.find()) {
            matched++;
        }

        assertThat(matched,is(2));
    }

    @Test
    public void simpleRegexp() {

//        given
        String regexp = "foo";
        String text = "foo";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);
//        when
        final boolean matches = matcher.matches();

//        then
        assertThat(matches, is(true));
    }
}