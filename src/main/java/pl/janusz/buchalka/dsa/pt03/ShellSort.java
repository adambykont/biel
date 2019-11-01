package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 24/10/2019. Project; bielmarcus
 */
public class ShellSort {

    public static void sort(Integer[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            Integer buffer = null;
            int slider;

            for (int i = gap; i < array.length; i++) {
                slider = i;
                buffer = array[i];
                while (slider >= gap && buffer < array[slider - gap]) {
                    array[slider] = array[slider - gap];
                    slider -= gap;
                }
                array[slider] = buffer;
            }
        }
    }
}
