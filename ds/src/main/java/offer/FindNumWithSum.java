package offer;

/**
 * Created by losye
 * 输入一个递增数组和一个数字s，在数组中找到两个数它们的和为s
 */
public class FindNumWithSum {
    public static int[] solution(int[] arr, int s) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < s) {
                start++;
            } else if (sum > s) {
                end--;
            } else {
                break;
            }
        }
        return new int[]{start, end};
    }
}
