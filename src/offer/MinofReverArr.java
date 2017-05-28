package offer;

/**
 * Created by losye
 * 输入一个递增排序数组的旋转，输出数组的最小值
 * 如:输入{3,4,5,1,2}为{1,2,3,4,5}的旋转，输出1
 */
public class MinofReverArr {
    public static int Solution(int[] arr){
        if (arr == null || arr.length <1){
            return  Integer.MIN_VALUE;
        }
        int left = 0;
        int right = arr.length-1;
        int middle = 0;
        while (arr[left] >= arr[right]){
            if (right - left == 1){
                middle = right;
                break;
            }
            middle = (left+right)/2;
            if (arr[middle] >= arr[right]){
                left = middle;
            }else {
                right = middle;
            }
        }
        return arr[middle];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        System.out.print(Solution(arr));
    }
}
