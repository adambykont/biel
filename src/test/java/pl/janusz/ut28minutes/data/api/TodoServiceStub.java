package pl.janusz.ut28minutes.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodos(String user) {

        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}