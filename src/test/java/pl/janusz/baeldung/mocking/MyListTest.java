package pl.janusz.baeldung.mocking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 20/10/2019. Project; bielmarcus
 */
@RunWith(MockitoJUnitRunner.class)
public class MyListTest {

    @Mock
    private List list;

    @Before
    public void setUp() throws Exception {

        Mockito
                .when(list.add(Mockito.anyString()))
                .thenReturn(true);
    }

    @Test
    public void addStringReturnsTrue() {

        boolean result = list.add("Hello");
        assertThat(result, is(true));

        Mockito
                .verify(list)
                .add(Mockito.anyString());
    }
}