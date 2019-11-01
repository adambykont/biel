package pl.janusz.buchalka.dsa.pt04.jdk;

import org.junit.Test;
import pl.janusz.buchalka.dsa.pt04.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 31/10/2019. Project; bielmarcus
 */
public class JKDImplementationsArrayTest extends JKDImplementationsTest {

    @Override
    protected List<Employee> getImplementation() {

        return new ArrayList<>();
    }


}
