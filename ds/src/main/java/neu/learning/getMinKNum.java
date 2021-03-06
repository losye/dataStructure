package neu.learning;

/**
 * 给定一个无序数组，找到其中最小的K个数
 *
 * @author Administrator
 */
public class getMinKNum {

    //利用最大堆
    public static int[] getMinKNumByHeap(int[] arr, int k) {
        if (arr == null || arr.length < k || k < 0) {
            return null;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (kHeap[0] > arr[i]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    //建堆的过程
    public static void heapInsert(int[] heap, int value, int index) {
        heap[index] = value;
        int parent = (index - 1) / 2;
        while (index != 0) {
            if (heap[index] > heap[parent]) {
                swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    //调整的过程
    public static void heapify(int[] heap, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        while (left < heapSize) {
            if (heap[index] < heap[left]) {
                //swap(heap,index,left);
                largest = left;
            }
            if (right < heapSize && heap[largest] < heap[right]) {
                largest = right;
            }
            if (index != largest) {
                swap(heap, index, largest);
            } else {
                break;
            }
            index = largest;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }

    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static int partition(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = start;
        int r = end;
        int temp = arr[l];
        if (l < r) {
            while (l < r && temp >= arr[r]) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }
            while (l < r && temp < arr[l]) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        arr[l] = temp;
        return l;
    }

    //利用快排思想
    public static void getKNum(int[] arr, int start, int end, int k) {
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                index = partition(arr, index + 1, end);
            } else if (index > k - 1) {
                index = partition(arr, start, index - 1);
            } else {
                return;
            }
        }
    }

}
