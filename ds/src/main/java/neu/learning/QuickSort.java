package neu.learning;

public class QuickSort {

    public static void partition(int[] arr, int start, int end) {
        int i = start, j = end;
        int middle = (start + end) / 2;
        int temp = arr[i];
        while (i < j) {
            while (i < j && arr[i] <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] > arr[j]) {
                i++;
            }
            arr[j] = arr[i];
            arr[i] = temp;
        }
        partition(arr, start, middle - 1);
        partition(arr, middle + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {11, 66, 22, 10, 55, 28, 0, 32};
        partition(arr, 0, arr.length - 1);
    }
}
