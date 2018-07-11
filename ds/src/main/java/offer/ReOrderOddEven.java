package offer;

/**
 * Created by losye
 * 调整数组 使奇数在偶数前面
 */
public class ReOrderOddEven {
    public static void reOrder(int[] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        int l = 0;
        int r = arr.length-1;
        while (l <= r){
            while (!isOdd(arr[l])){
                l++;
            }
            while (isOdd(arr[r])){
                r--;
            }
            if (l < r){
                swap(arr, l, r);
            }
        }
    }

    private static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private static boolean isOdd(int n){
        return n%2==0;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,6,3,5,6,7};
        reOrder(arr);
        for (int it : arr){
            System.out.print(it + " ");
        }
    }
}
