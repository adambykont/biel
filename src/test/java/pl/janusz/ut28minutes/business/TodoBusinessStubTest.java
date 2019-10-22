package pl.janusz.ut28minutes.business;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import pl.janusz.ut28minutes.data.api.TodoService;
import pl.janusz.ut28minutes.data.api.TodoServiceStub;

import java.util.List;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class TodoBusinessStubTest {

    @Test
    public void shuldRetrieveSpringTodosUsingStub() {

//        given
        final TodoService stub = new TodoServiceStub();
        TodoBusiness todoBusiness = new TodoBusiness(stub);

//        when
        final List<String> related = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

//        then
        assertThat(related, hasItems("Learn Spring MVC", "Learn Spring"));
        assertThat(related, hasSize(2));
        assertThat(related, not(hasItem("Learn to Dance")));
    }
}