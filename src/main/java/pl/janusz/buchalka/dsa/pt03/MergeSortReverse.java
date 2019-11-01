package pl.janusz.buchalka.dsa.pt03;

/**
 * Created by Janusz Kacki on 25/10/2019. Project; bielmarcus
 */
public class MergeSortReverse {

    public static void sort(Integer[] array) {

        recSort(array, 0, array.length);
    }

    private static void recSort(Integer[] array, int left, int right) {

        if ((right - left) < 2) {
            return;
        }

        int mid = (left + right) / 2;
        recSort(array, left, mid);
        recSort(array, mid, right);
        combine(array, left, right);
    }

    private static void combine(Integer[] array, int left, int right) {

        Integer[] temp = new Integer[right - left];
        int mid = (left + right) / 2;

        int leftSlider = left;
        int rightSlider = mid;
        int slider = 0;

        while (leftSlider < mid && rightSlider < right) {
            if (array[leftSlider] > array[rightSlider]) {
                temp[slider] = array[leftSlider];
                leftSlider++;
            } else {
                temp[slider] = array[rightSlider];
                rightSlider++;
            }
            slider++;
        }

        while (leftSlider < mid) {
            temp[slider] = array[leftSlider];
            leftSlider++;
            slider++;
        }

        while (rightSlider < right) {
            temp[slider] = array[rightSlider];
            rightSlider++;
            slider++;
        }

        for (int i = 0; i < right - left; i++) {
            array[left + i] = temp[i];
        }
    }
}
