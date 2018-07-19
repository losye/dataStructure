package cn.newcoder.arr;

import org.junit.Test;

/**
 * 给定一个无序数组，再给定一个值k，求累加和≤k的最大子数组(进阶题若给定一个无序矩阵呢？)
 *
 * @author zzy
 * 利用一个辅助数组h[]，数组代表遍历到当前位置时最大值
 * 如果遍历到j位置时，如何求这个最大值？ 利用这个h[j],如果知道h[j]-k 这个值第一次出现的位置
 * 比如是i，那么j-i+1 这个值就是必须以j结尾时的最大子数组。
 */
public class LongestLessSumSubArrayLength {
    public int maxLength(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        //这里记录下0这个值第一次出现的位l置，即未累加之前的值
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            //这里可以用map取到第一次出现所需要的值，也可以用二分法查
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    /**
     * 二分法
     *
     * @param arr
     * @param num
     * @return
     */
    public int getLessIndex(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, -1, 3, 2, 5, 1, 3, 4, -2};
        System.out.println(maxLength(arr, 3));
    }
}
