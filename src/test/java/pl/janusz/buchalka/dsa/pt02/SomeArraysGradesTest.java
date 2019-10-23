package pl.janusz.buchalka.dsa.pt02;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SomeArraysGradesTest {

    private Integer[] grades;

    @Before
    public void setUp() throws Exception {

        grades = new Integer[]{2, 3, 4, 5};
    }

    @Test
    public void shouldHasSize4() {

        assertThat(grades, arrayWithSize(4));
    }

    @Test
    public void shouldContain2() throws Exception {

        assertThat(grades, hasItemInArray(2));
    }

    @Test
    public void shouldContain2to5() throws Exception {

        assertThat(grades, arrayContaining(2, 3, 4, 5));
    }

    @Test
    public void shouldContain3to5() throws Exception {

        assertThat(grades, hasItemInArray(3));
        assertThat(grades, hasItemInArray(4));
        assertThat(grades, hasItemInArray(5));

    }
}