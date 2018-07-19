package cn.newcoder.arr;

public class MaxSumBetweenTwoSubArr {

    public int maxSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        //和一个子数组思路相同  只不过用一个数组来记录从右到左
        int[] h = new int[arr.length];
        h[arr.length - 1] = arr[arr.length - 1];
        int cur = arr[arr.length - 1];
        for (int i = arr.length - 2; i > -0; i--) {
            cur = cur < 0 ? 0 : cur;
            cur += arr[i];
            h[i] = Math.max(h[i + 1], cur);
        }
        int res = arr[0] + arr[1];
        int lmax = arr[0];
        cur = arr[0];
        //这里用一个lmax变量代替那个数组
        for (int i = 1; i < arr.length - 1; i++) {
            cur = cur < 0 ? 0 : cur;
            cur += arr[i];
            lmax = Math.max(lmax, cur);
            res = Math.max(res, lmax + h[i + 1]);
        }
        return res;
    }
}
