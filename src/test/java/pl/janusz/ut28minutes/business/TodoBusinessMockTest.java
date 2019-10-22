package pl.janusz.ut28minutes.business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.janusz.ut28minutes.data.api.TodoService;
import pl.janusz.ut28minutes.data.api.TodoServiceStub;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class TodoBusinessMockTest {

    @Test
    public void shouldRetrieveStringRelatedTodosUsingMock() {

//        given
        final TodoService mock = Mockito.mock(TodoService.class);
        Mockito
                .when(mock.retrieveTodos(Mockito.anyString()))
                .thenAnswer(new Answer<List<String>>() {

                    @Override
                    public List<String> answer(InvocationOnMock invocationOnMock) throws Throwable {

                        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
                    }
                });
        TodoBusiness sut = new TodoBusiness(mock);

//        when
        final String dummy = "Dummy";
        final List<String> retrievedTodos = sut.retrieveTodosRelatedToStrint(dummy);

//        then
        Mockito
                .verify(mock)
                .retrieveTodos(dummy);
        assertThat(retrievedTodos, hasSize(2));
        assertThat(retrievedTodos, hasItems("Learn Spring MVC", "Learn Spring"));
        assertThat(retrievedTodos, not(hasItem("Learn to Dance")));
    }
}