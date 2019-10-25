package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
public class QuickSort {

    public static void sort(Integer[] array) {

        recSort(array, 0, array.length);
    }

    private static void recSort(Integer[] array, int left, int right) {

        if (right - left < 2) {
            return;
        }

        int pivotIdx = partition(array, left, right);

        recSort(array, left, pivotIdx);
        recSort(array, pivotIdx + 1, right);
    }

    private static int partition(Integer[] array, int left, int right) {

        Integer pivot = array[left];

        int lp = left;
        int gep = right - 1;

        while (lp < gep) {
            while (lp < gep && array[gep] >= pivot) {
                gep--;
            }
            if (lp < gep) {
                array[lp] = array[gep];
                lp++;
            }

            while (lp < gep && array[lp] < pivot) {
                lp++;
            }
            if (lp < gep) {
                array[gep] = array[lp];
                gep--;
            }
        }

        array[lp] = pivot;

        return lp;
    }
}
