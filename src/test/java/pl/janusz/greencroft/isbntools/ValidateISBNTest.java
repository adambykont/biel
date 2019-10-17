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
    public void checkValidISBN() {

        int validISBN = 1404491116;
        boolean result = validator.checkISBN(validISBN);

        assertThat(result, is(true));
        assertTrue(result);
    }
}