package pl.janusz.frieze.basics;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 18/10/2019. Project; bielmarcus
 */
public class DateUtilLongerTest {

    @Test
    public void normallLeapYearIsLeap() {

        int year = 1992;
        boolean leapYear = DateUtil.isLeapYear(year);

        assertThat(leapYear, is(equalTo(true)));
    }

    @Test
    public void anotherNormallLeapYearIsLeap() {

        int year = 1996;
        boolean leapYear = DateUtil.isLeapYear(year);
        assertThat(leapYear, is(true));
    }

    @Test
    public void centuryYearIsNotLeap() {

        int year = 1900;
        boolean leapYear = DateUtil.isLeapYear(year);
        assertThat(leapYear, is(false));
    }

    @Test
    public void normallNonLeapYearIsNotLeap() {

        int year = 1991;
        boolean leapYear = DateUtil.isLeapYear(year);

        assertThat(leapYear, is(false));
    }
}