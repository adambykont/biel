package net.forprogrammers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Janusz Kacki on 08/10/2019. Project; bielmarcus
 */
public class MyClassTest {

    private IStudent student;
    private String sAName;
    private String sBName;
    private String sASurname;
    private String sBSurname;
    private IStudent studentA;
    private IStudent studentB;
    private MyClass sut;
    private ICreateStudent createStudent;
    private List<IStudent> students;

    @Before
    public void setUp() throws Exception {

        students = Arrays.asList(studentA, studentB);

        createStudent = Mockito.mock(ICreateStudent.class);
        studentA = Mockito.mock(IStudent.class);
        studentB = Mockito.mock(IStudent.class);

        sAName = "Adam";
        sBName = "Barbara";
        sASurname = "Ant";
        sBSurname = "Brown";

        Mockito
                .when(studentA.getName())
                .thenReturn(sAName);

        Mockito
                .when(studentB.getName())
                .thenReturn(sBName);

        Mockito
                .when(studentA.getSurname())
                .thenReturn(sASurname);
        Mockito
                .when(studentB.getSurname())
                .thenReturn(sBSurname);

        Mockito
                .when(createStudent.getStudents())
                .thenReturn(students);

        sut = new MyClass(createStudent);
    }
}