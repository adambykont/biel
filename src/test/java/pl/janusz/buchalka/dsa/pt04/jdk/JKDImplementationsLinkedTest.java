package pl.janusz.buchalka.dsa.pt04.jdk;

import pl.janusz.buchalka.dsa.pt04.Employee;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Janusz Kacki on 31/10/2019. Project; bielmarcus
 */
public class JKDImplementationsLinkedTest extends JKDImplementationsTest {

    @Override
    protected List<Employee> getImplementation() {

        return new LinkedList<>();
    }
}
