package pl.janusz.ut28minutes;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Janusz Kacki on 01/11/2019. Project; bielmarcus
 */
public class Zero {

    public static void main(String[] args) {

        final ArrayList<Integer> arrayList = new ArrayList<>();
        final LinkedList<Integer> linkedList = new LinkedList<>();

        arrayList.add(0,0);
        linkedList.add(0,0);
        System.out.println(arrayList.get(0));
        System.out.println(linkedList.get(0));

        arrayList.clear();
        linkedList.clear();

        arrayList.set(0, 0);
        linkedList.set(0, 0);

        System.out.println(arrayList.get(0));
        System.out.println(linkedList.get(0));

    }
}
