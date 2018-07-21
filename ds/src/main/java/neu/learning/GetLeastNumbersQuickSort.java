package neu.learning;

import java.util.ArrayList;

/**
 * GetLeastNumbers_Solution
 *
 * @author Administrator
 * <p>
 * 给到一个无序数组, 和一个k值
 * 得到排序后的前k个的数
 */

public class GetLeastNumbersQuickSort {
    public static void main(String[] args) {

    }

    public static ArrayList solution(int[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k || k <= 0) {
            return new ArrayList<Integer>();
        }
        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, k, low, high);
        while (index != k - 1) {   //index of k-1 is numof k
            if (index > k - 1) {
                low = index + 1;
                index = partition(arr, k, low, high);
            } else {
                high = index - 1;
                index = partition(arr, k, low, high);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++)
            list.add(arr[i]);
        return list;
    }

    private static int partition(int[] arr, int k, int low, int high) {
        if (arr == null || arr.length == 0 || arr.length < k || k <= 0) {
            return 0;
        }
        int temp = arr[k - 1];
        swap(arr, low, k - 1);
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] < temp) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
