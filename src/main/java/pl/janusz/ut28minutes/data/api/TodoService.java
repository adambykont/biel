package pl.janusz.ut28minutes.data.api;

import java.util.List;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public interface TodoService {

    List<String> retrieveTodos(String user);
}
