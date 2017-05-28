package offer;

/**
 * Created by losye
 * 快排
 */
public class QuickSort {
    public static void quickSort(int[] arr, int start, int end){
        if (arr == null || arr.length <1){
            return;
        }
        int i = start;
        int j = end-1;
        int temp = arr[i];
        while (i < j){

            while (i<j && temp<=arr[j]){
                j--;
            }
            if (i<j){
                arr[i++] = arr[j];
            }
            while (i<j && temp>arr[i]){
                i++;
            }
            if (i<j){
                arr[j--] = arr[i];
            }
            arr[i] = temp;
            quickSort(arr, start, i-1);
            quickSort(arr, i+1, end);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,8,4,2,4,1,7};
        quickSort(arr, 0, arr.length-1);
        for (int it : arr){
            System.out.print(it + " ");
        }
    }
}
