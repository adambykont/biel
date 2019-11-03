package pl.janusz.buchalka.dsa.pt05.palindrome;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public class PalindromeCheckerTest {

    @Test
    public void emptyStringIsPalindrome() {

        assertThat(PalindromeChecker.isPalindrome(""), is(true));
    }

    @Test
    public void shouldNotBePalindrome12() {

        final boolean palindrome = PalindromeChecker.isPalindrome("12");
        assertThat(palindrome, is(false));
    }

    @Test
    public void shouldNotBePalindrome123() {

        final boolean palindrome = PalindromeChecker.isPalindrome("12");
        assertThat(palindrome, is(false));
    }

    @Test
    public void shouldBePalindrome121() {

        assertThat(PalindromeChecker.isPalindrome("121"), is(true));
    }

    @Test
    public void shouldBePalindrome1221() {

        assertThat(PalindromeChecker.isPalindrome("1221"), is(true));
    }
     @Test
    public void shouldBePalindrome12_21() {

        assertThat(PalindromeChecker.isPalindrome("1 1 2 21 1"), is(true));
    }


}