package pl.janusz.ut28minutes.business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.janusz.ut28minutes.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class TodoBusinessMockTest {

    private TodoService mock;
    private TodoBusiness sut;
    private String dummy;

    @Before
    public void setUp() throws Exception {

        //        given
        mock = Mockito.mock(TodoService.class);
        Mockito
                .when(mock.retrieveTodos(Mockito.anyString()))
                .thenAnswer(new Answer<List<String>>() {

                    @Override
                    public List<String> answer(InvocationOnMock invocationOnMock) throws Throwable {

                        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance", "Learn to Sing");
                    }
                });

        sut = new TodoBusiness(mock);
        dummy = "Dummy";
    }

    @Test
    public void shouldDeleteTodosnotRelatedToSpring() {

        sut.deleteTodosNotRelatedToSpring(dummy);
        Mockito
                .verify(mock, Mockito.times(2))
                .deleteTodo(Mockito.anyString());
    }

    @Test
    public void shouldNeverRunDeleteOnSpringTodosWhenRemovingNonSpringTodos() {

        sut.deleteTodosNotRelatedToSpring(dummy);

        Mockito
                .verify(mock, Mockito.never())
                .deleteTodo("Learn Spring MVC");

        Mockito
                .verify(mock, Mockito.never())
                .deleteTodo("Learn Spring");
    }

    @Test
    public void shouldDeleteLearnToDanceAndLearnSingA() {

        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        sut.deleteTodosNotRelatedToSpring(dummy);

        Mockito
                .verify(mock, Mockito.atLeast(1))
                .deleteTodo(captor.capture());

        final List<String> allValues = captor.getAllValues();
        assertThat(allValues.get(0), is(equalTo("Learn to Dance")));
        assertThat(allValues.get(1), is(equalTo("Learn to Sing")));
    }

    @Test
    public void shouldCallDeleteOnDanceTodoWhenremovingNonSpringTodos() {

        sut.deleteTodosNotRelatedToSpring(dummy);

        Mockito
                .verify(mock)
                .deleteTodo("Learn to Dance");
    }

    @Test
    public void shouldRetrieveStringRelatedTodosUsingMock() {

//        when
        final List<String> retrievedTodos = sut.retrieveTodosRelatedToSpring(dummy);

//        then
        Mockito
                .verify(mock)
                .retrieveTodos(dummy);
        assertThat(retrievedTodos, hasSize(2));
        assertThat(retrievedTodos, hasItems("Learn Spring MVC", "Learn Spring"));
        assertThat(retrievedTodos, not(hasItem("Learn to Dance")));
    }
}