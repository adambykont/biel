package pl.janusz.greencroft.isbntools;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 17/10/2019. Project; bielmarcus
 */
public class ValidateISBNTest {

    private ValidateISBN validator;

    @Before
    public void setUp() throws Exception {

        validator = new ValidateISBN();
    }

    @Test
    public void shouldCheckAnotherValidISBN() {

        int validISBN = 140177396;

        boolean result = validator.checkISBN(validISBN);

        assertThat("140177396 should be validated", result, is(true));
    }

    @Test
    public void shouldCheckValidISBN() {

        int validISBN = 1404491116;
        boolean result = validator.checkISBN(validISBN);

        assertThat("1404491116 shoould be validated", result, is(true));
    }

    @Test
    public void shouldNotPassInvalidISBNNumber() {

        int invalidISBN = 1404491117;
        boolean result = validator.checkISBN(invalidISBN);

        assertThat("1404491117 should'nt be validated", result, is(false));
    }
}