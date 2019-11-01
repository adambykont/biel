package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeLinkedListTest extends EmployeeLinkedBasicTest {

    @Override
    protected List getImplementation() {

        return new EmployeeLinkedList();
    }
}