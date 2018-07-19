package cn.newcoder.arr;

/**
 * 求未排序数组中累加和为给定值K的最长子数组长度
 *
 * @author zzy
 * 时间复杂度O(N)
 */
public class LongestSumSubArrLength {

    public static int getMaxLen(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int lIndex = 0, rIndex = 0;
        int len = 0;
        int cur = arr[0];
        while (rIndex < arr.length) {
            if (cur > k) {
                cur -= arr[lIndex++];
//				lIndex++;
            } else {
                if (cur == k) {
                    len = Math.max(len, rIndex - lIndex + 1);
                }
                rIndex++;
                if (rIndex < arr.length) {
                    cur += arr[rIndex];
                }
            }
        }
        return len;
    }
}
