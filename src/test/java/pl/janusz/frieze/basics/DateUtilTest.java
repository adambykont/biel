package pl.janusz.frieze.basics;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 18/10/2019. Project; bielmarcus
 */
public class DateUtilTest {

    @Test
    public void shouldNotBeLeapYear() {

        int year = 1991;
        boolean leapYear = DateUtil.isLeapYear(year);

        assertThat(leapYear, is(equalTo(false)));
    }

    @Test
    public void shouldBeLeapYear() {

        int year = 1992;
        boolean isLeap = DateUtil.isLeapYear(year);

        assertThat(isLeap, is(true));
    }

    @Test
    public void year2000WasLeap() {

        int year = 2000;
        boolean leapYear = DateUtil.isLeapYear(year);

        assertThat(leapYear, is(true));
    }
}