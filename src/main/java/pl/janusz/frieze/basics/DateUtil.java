package pl.janusz.frieze.basics;

/**
 * Created by Janusz Kacki on 18/10/2019. Project; bielmarcus
 */
public class DateUtil {

    /**
     * Is leap year
     *
     * @param year four digit year
     * @return true if leap year
     */
    public static boolean isLeapYear(int year) {

        return year % 4 == 0
                && year % 100 != 0
                || year % 400 == 0;
    }
}
