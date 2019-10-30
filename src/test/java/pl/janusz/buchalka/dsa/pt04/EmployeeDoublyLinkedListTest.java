package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 27/10/2019. Project; bielmarcus
 */
public class EmployeeDoublyLinkedListTest extends EmployeeLinkedBasicTest {

    @Override
    protected List getImplementation() {

        return new EmployeeDoublyLinkedList();
    }
}