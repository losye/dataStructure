package neu.learning;

/**
 * 求数组排序后相邻数的最大差值
 *
 * @author Administrator
 * {9,3,1,10} 返回6
 */
public class maxGapInSortArr {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 10};
        System.out.println(maxGap(arr));
    }

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        if (max == min) {
            return 0;
        }
        int[] maxArr = new int[len + 1];
        int[] minArr = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        int k = 0;
        for (int i = 0; i < len; i++) {
            k = getBucket(arr[i], max, min, len);
            maxArr[k] = hasNum[k] ? Math.max(arr[i], maxArr[k]) : arr[i];
            minArr[k] = hasNum[k] ? Math.min(arr[i], minArr[k]) : arr[i];
            hasNum[k] = true;
        }
        int lastMax = 0;
        int nextMin = 0;
        int i = 0;
        for (; i < len; i++) {
            if (!hasNum[i]) {
                lastMax = maxArr[i - 1];
                break;
            }
        }
        while (i < len + 1) {
            if (hasNum[i]) {
                nextMin = minArr[i];
                break;
            }
            i++;
        }
        return nextMin - lastMax;
    }

    /**
     * 计算进入哪个桶  max直接放入n+1桶中
     */
    private static int getBucket(int num, int max, int min, int len) {
        return ((num - min) * len) / (max - min);
    }
}
