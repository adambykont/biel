package pl.janusz.ut28minutes.business;

import pl.janusz.ut28minutes.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 21/10/2019. Project; bielmarcus
 */
public class TodoBusiness {

    private TodoService todoService;

    public TodoBusiness(TodoService todoService) {

        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {

        List<String> filteredTodos = new ArrayList<>();
        final List<String> allTodos = this.todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.toLowerCase().contains("spring")) {
                filteredTodos.add(todo);
            }
        }

        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {

        final List<String> allTodos = this.todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.toLowerCase().contains("spring")) {
                this.todoService.deleteTodo(todo);
            }
        }
    }
}
