package pl.janusz.buchalka.dsa.pt06;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 03/11/2019. Project; bielmarcus
 */
public abstract class QueueTest {

    @Before
    public void setUp() throws Exception {

        Queue<String> queue = getQueue();

    }

    protected abstract Queue<String> getQueue();
}