package offer;

/**
 * Created by losye
 * 快排
 */
public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length < 1) {
            return;
        }
        if (start < end) {
            int i = start;
            int j = end - 1;
            int temp = arr[i];
            while (i < j) {
                while (i < j && temp <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && temp > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
                arr[i] = temp;
                quickSort(arr, start, i - 1);
                quickSort(arr, i + 1, end);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 8, 7, 9, 5, 4, 2};
        quickSort(arr, 0, arr.length);
        for (int it : arr) {
            System.out.print(it + " ");
        }
    }
}
