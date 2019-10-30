package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class SortShuffleCat {

    private ArrayList<Cat> cats;

    @Before
    public void setUp() throws Exception {

        cats = new ArrayList<>();
    }

    @Test
    public void sort() throws Exception {

        cats.sort(new Comparator<Cat>() {

            @Override
            public int compare(Cat o1, Cat o2) {

                return o1.name.compareTo(o2.name);
            }
        });
    }

    @Test
    public void shuffle() {

        Collections.shuffle(cats);
    }

    private class Cat {

        private String name;

        public Cat(String name) {

            this.name = name;
        }
    }
}