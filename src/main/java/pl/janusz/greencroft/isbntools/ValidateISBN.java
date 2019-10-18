package pl.janusz.greencroft.isbntools;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class ValidateISBN {

    private static final int TEN_DIGITS = 10;
    private static final int THIRTEEN_DIGITS = 13;

    private boolean checkISBN(String isbn) {

        checkFormat(isbn);

        boolean result;

        if (isbn.length() == TEN_DIGITS) {
            result = tenDigitsCheck(isbn);
        } else {
            result = thirteenDigitsCheck(isbn);
        }

        return result;
    }

    private void checkFormat(String isbn) {

        if (isbn == null) {
            throw new NumberFormatException("non 10 or 13 digits ISBN");
        }

        if (!(isbn.length() == TEN_DIGITS || isbn.length() == THIRTEEN_DIGITS)) {

            throw new NumberFormatException("non 10 or 13 digits ISBN");
        }

        if (isbn.length() == TEN_DIGITS && !isbn.matches("^[0-9]{9}[0-9X]$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }

        if (isbn.length() == THIRTEEN_DIGITS && !isbn.matches("^[0-9]{12}[0-9X]$")) {
            throw new IllegalArgumentException(" Non digit ISBN");
        }
    }

    private boolean thirteenDigitsCheck(String isbn) {

        int sumSoFar = 0;
        int digit;

        for (int i = 0; i < THIRTEEN_DIGITS; i++) {
            digit = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            if (i % 2 == 0) {
                sumSoFar += digit;
            } else {
                sumSoFar += 3 * digit;
            }
        }

        return sumSoFar % TEN_DIGITS == 0;
    }

    private boolean tenDigitsCheck(String isbn) {

        int sumSoFar = 0;
        int digit;
        int weight;

        for (int i = 0; i < 9; i++) {
            digit = Integer.parseInt(String.valueOf(isbn.charAt(i)));
            weight = TEN_DIGITS - i;
            sumSoFar += digit * weight;
        }

        if (isbn.charAt(9) == 'X') {
            sumSoFar += TEN_DIGITS;
        } else {
            sumSoFar += Integer.parseInt(String.valueOf(isbn.charAt(9)));
        }

        return sumSoFar % 11 == 0;
    }
}
