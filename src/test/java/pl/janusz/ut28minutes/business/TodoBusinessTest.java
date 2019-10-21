package pl.janusz.ut28minutes.business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import pl.janusz.ut28minutes.data.api.TodoService;
import pl.janusz.ut28minutes.data.api.TodoServiceStub;

import java.util.List;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class TodoBusinessTest {

    private TodoBusiness todoBusiness;

    @Before
    public void setUp() throws Exception {

        final TodoService stub = new TodoServiceStub();
        todoBusiness = new TodoBusiness(stub);
    }

    @Test
    public void shuldRetrieveSpringTodosUsingStub() {

        final List<String> related = todoBusiness.retrieveTodosRelatedToStrint("Dummy");
        assertThat(related, hasItems("Learn Spring MVC", "Learn Spring"));
        assertThat(related,hasSize(2));
        assertThat(related, not(hasItem("Learn to Dance")));
    }
}