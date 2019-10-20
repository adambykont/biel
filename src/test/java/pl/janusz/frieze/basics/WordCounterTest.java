package pl.janusz.frieze.basics;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 19/10/2019. Project; bielmarcus
 */
public class WordCounterTest {

    private WordCounter counter;

    @Before
    public void setUp() throws Exception {

        counter = new WordCounter();
    }

    @Test
    public void twoSingleWordStringHaveTwoWords() {

        String s1 = "Hello";
        String s2 = "Word";
        counter.add(s1);
        counter.add(s2);
        int uniqueWordsCount = counter.getUniqueWordsCount();

        assertThat(uniqueWordsCount, is(equalTo(2)));
    }

    @Test
    public void singleWordstringHasOneWord() {

        String hello = "Hello";
        counter.add(hello);
        int uniqueWordsCount = counter.getUniqueWordsCount();

        assertThat(uniqueWordsCount, is(equalTo(1)));
    }

    @Test
    public void emptyStringHsNoWords() {

        String s = "";
        counter.add(s);
        int uniqueWordsCount = counter.getUniqueWordsCount();

        assertThat(uniqueWordsCount, is(equalTo(0)));
    }

    @Test
    public void multiWordsStringHasCorrectCount() {

        String s = "One Two Three";
        counter.add(s);
        int uniqueWordsCount = counter.getUniqueWordsCount();
        assertThat(uniqueWordsCount, is(3));
    }

    @Test
    public void severalMultiWordsStringsCountedCorrectly() {

        String s1 = "One Two Three";
        String s2 = "Four Five Six";

        counter.add(s1);
        counter.add(s2);
        int uniqueWordsCount = counter.getUniqueWordsCount();
        assertThat(uniqueWordsCount, is(6));
    }

    @Test
    public void spacedOuteveralMultiWordsStringsCountedCorrectly() {

        String s1 = "     One Two Three";
        String s2 = "Four Five Six   ";
        String s3 = "  Seven Eight Nine   ";
        String s4 = "  Ten  Eleven   Twelve   ";
        String s5 = "  Thirteen,  Fourteen.   Fifteen:   ";

        counter.add(s1);
        counter.add(s2);
        counter.add(s3);
        counter.add(s4);
        counter.add(s5);
        int uniqueWordsCount = counter.getUniqueWordsCount();
        assertThat(uniqueWordsCount, is(15));
    }

    @Test
    public void inputWithDuplicatesCountsOnlyIndividualCases() {

        String s = "Tora Tora Tora";
        counter.add(s);
        int uniqueWordsCount = counter.getUniqueWordsCount();
        assertThat(uniqueWordsCount, is(1));
    }

    @Test
    public void inputWithPunctuationstillSpotDuplicates() {

        String s1 = "Tora, tora. tora; 'tora' tora' 'tora; ";
        String s2 = " tora;";
        String s3 = "TORA.";
        counter.add(s1);
        counter.add(s2);
        counter.add(s3);
        int uniqueWordsCount = counter.getUniqueWordsCount();
        assertThat(uniqueWordsCount, is(1));
    }

    @Test
    public void inputsWithDifferentCasesCountOnlyIndividualCases() {

        String s = "Tora tora TORA";
        counter.add(s);
        int uniqueWordsCount = counter.getUniqueWordsCount();
        assertThat(uniqueWordsCount, is(1));
    }
}